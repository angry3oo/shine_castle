package com.shine.castle.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shine.castle.security.service.SecurityService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class CustomAuthentication implements AuthenticationProvider {
	@Autowired
	private SecurityService securityService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();
	
	@Override
	public Authentication authenticate(Authentication authentication) throws CustomAuthenticationException {
		String userId = determineUsername(authentication);
		UserDetails user = securityService.loadUserByUsername(userId);
		this.additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken) authentication);
		this.check(user);
		return createSuccessAuthentication(authentication, user);
	}
	

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

	/**
	 * @param principal
	 * @param authentication
	 * @param user
	 * @return
	 */
	private Authentication createSuccessAuthentication(Authentication authentication, UserDetails user) {
		UsernamePasswordAuthenticationToken result = UsernamePasswordAuthenticationToken.authenticated(
				user,
				authentication.getCredentials(), 
				this.authoritiesMapper.mapAuthorities(user.getAuthorities()));
		result.setDetails(authentication.getDetails());
		return result;
	}
	
	/**
	 * Spring Security
	 * 입력받은 ID 체크
	 * @param authentication
	 * @return
	 */
	private String determineUsername(Authentication authentication) {
		return (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
	}
	
	/**
	 * Spring Security
	 * 권한체크
	 * @param toCheck
	 */
	private void check(UserDetails toCheck) {
		if (!toCheck.isAccountNonLocked()) {
			log.debug("계정이 잠겼습니다.");
			throw new LockedException("LE");
		}
		if (!toCheck.isEnabled()) {
			log.debug("계정이 비활성화 되었습니다.");
			throw new DisabledException("DE");
		}
		if (!toCheck.isAccountNonExpired()) {
			log.debug("계정이 만료되었습니다.");
			throw new AccountExpiredException("AEE");
		}
		if (!toCheck.isCredentialsNonExpired()) {
			log.debug("비밀번호가 만료되었습니다.");
			throw new CredentialsExpiredException("CEE");
		}
	}

	/**
	 * 
	 * Spring Security
	 * 비밀번호 체크
	 * @param userDetails
	 * @param authentication
	 * @throws AuthenticationException
	 */
	private void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) {
		String presentedPassword = authentication.getCredentials().toString();
		if (!this.passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
			log.debug("현재 비밀번호 랑 저장되어있는 비밀번호 체크");
			throw new BadCredentialsException("BCE");
		}
	}
	
}
