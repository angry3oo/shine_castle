package com.shine.castle.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shine.castle.security.mapper.SecurityMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SecurityPassWordService implements UserDetailsPasswordService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SecurityMapper securityMapper;

	/**
	 * Spring Security 
	 * 비밀번호 변경
	 */
	@Override
	public UserDetails updatePassword(UserDetails user, String newPassword) {
		String userId = user.getUsername();
		String newPassWord = passwordEncoder.encode(newPassword);
		
		return null;
	}


}
