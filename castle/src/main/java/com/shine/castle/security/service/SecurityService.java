package com.shine.castle.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shine.castle.config.CamelMap;
import com.shine.castle.security.mapper.SecurityMapper;
import com.shine.castle.security.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SecurityService implements UserDetailsService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SecurityMapper securityMapper;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException{
		UserVo user = securityMapper.findUserDetails(userId);
		user.setUserPassWord(passwordEncoder.encode(user.getUserPassWord()));
		log.info(user.toString());
//		if(user == null){
//			log.info("[{}] Login Fail", userId);
//            // 로그인 실패시 예외 던지기
//        }
		return user;
	}
	
	public int idCheck(UserVo userVo) {
		return securityMapper.idCheck(userVo);
	}

}
