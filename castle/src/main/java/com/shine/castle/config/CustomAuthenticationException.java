package com.shine.castle.config;

import org.springframework.security.core.AuthenticationException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("serial")
public class CustomAuthenticationException extends AuthenticationException {

	/**
	 * @param msg
	 */
	public CustomAuthenticationException(String msg) {
		super(msg);
	}
	
	/**
	 * @param msg
	 * @param cause
	 */
	public CustomAuthenticationException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
