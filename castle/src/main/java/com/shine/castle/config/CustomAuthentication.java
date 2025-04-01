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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userId = determineUsername(authentication);
			try {
				UserDetails user = securityService.loadUserByUsername(userId);
				this.additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken) authentication);
				this.check(user);
				return createSuccessAuthentication(authentication, user);
			} catch (UsernameNotFoundException ex) {
				log.debug(userId+" 가 존재하지 않습니다.");
				return null;
			} catch (LockedException le) {
				log.debug("계정이 잠겼습니다.");
				return null;
			} catch (DisabledException de) {
				log.debug("계정이 비활성화 되었습니다.");
				return null;
			} catch (AccountExpiredException aee) {
				log.debug("계정이 만료되었습니다.");
				return null;
			} catch (CredentialsExpiredException ce) {
				log.debug("비밀번호가 만료되었습니다.");
				return null;
			} catch (NullPointerException ne) {
				log.debug("입력 받은 비밀번호 null 체크");
				return null;
			} catch (BadCredentialsException be) {
				log.debug("현재 비밀번호 랑 저장되어있는 비밀번호 체크");
				return null;
			} catch (AuthenticationException ae) {
				return null;
			}
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
			throw new LockedException(toCheck.getUsername());
		}
		if (!toCheck.isEnabled()) {
			throw new DisabledException(toCheck.getUsername());
		}
		if (!toCheck.isAccountNonExpired()) {
			throw new AccountExpiredException(toCheck.getUsername());
		}
		if (!toCheck.isCredentialsNonExpired()) {
			throw new CredentialsExpiredException(toCheck.getUsername());
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
		if (authentication.getCredentials() == null) {
			throw new NullPointerException();
		}
		String presentedPassword = authentication.getCredentials().toString();
		if (!this.passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
			throw new BadCredentialsException("no password");
		}
	}
	
}
