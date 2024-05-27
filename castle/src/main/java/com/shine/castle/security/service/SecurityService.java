package com.shine.castle.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shine.castle.security.mapper.SecurityMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SecurityService implements UserDetailsService {
	
	@Autowired
	private SecurityMapper securityMapper;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		UserDetails user = securityMapper.findUserDetails(userId);
		return user;
	}

}
