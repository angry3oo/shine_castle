package com.shine.castle.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shine.castle.config.SenderMail;
import com.shine.castle.security.mapper.SecurityMapper;
import com.shine.castle.security.vo.MailInfoVo;
import com.shine.castle.security.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SecurityService implements UserDetailsService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SecurityMapper securityMapper;
	
	@Autowired
	private SenderMail senderMail;
	
	@Value("${mail_user}")
	private String from;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException{
		UserVo user = securityMapper.findUserDetails(userId);
		if(user == null) {
			log.debug("[{}] Login Fail", userId);
			throw new UsernameNotFoundException(userId);
		}
		user.setUserPassWord(passwordEncoder.encode(user.getUserPassWord()));
		return user;
	}
	
	/**
	 * @param userVo
	 * @return
	 */
	public int idCheck(UserVo userVo) {
		return securityMapper.idCheck(userVo);
	}
	
	/**
	 * @param mailInfoVo
	 * @return
	 */
	public Boolean emailCheck(MailInfoVo mailInfoVo) {
		mailInfoVo.setFrom(from);
		mailInfoVo.setSubject("제목");
		mailInfoVo.setText("본문");
		return senderMail.simpleCreateMessage(mailInfoVo);
	}

}
