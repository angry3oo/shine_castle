package com.shine.castle.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import com.shine.castle.config.SuccessLoginHandler;

@Order(2)
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	/**
	 * 
	 * login url Security Handler
	 * .permitAll() = 허용
	 * .hasRole("ADMIN") = 특정권한 ADMIN
	 * .denyAll() = 거부
	 * .anyRequest().authenticated() = 그 외에 url은 인증이 필요 하다.
	 * 
	 * http.csrf().disable(); = 크로스사이트 위조 요청에 대한 설정(사용안할때 disable)
	 * Rest API 통신인 경우에는 사용할 필요없음
	 * 
	 * 또한 default csrf를 설정을 안하게 되면 
	 * 
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//http.addFilterBefore(new FilterHandler(), BasicAuthenticationFilter.class);
		//http.addFilterAfter(new FilterHandler(), BasicAuthenticationFilter.class);
		http.csrf()
		.csrfTokenRepository(csrfTokenRepository())
		.and()
		.authorizeHttpRequests()
		.antMatchers("/login/**").permitAll()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/js/**").permitAll()
		.anyRequest().authenticated()
		;
		
		http.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/login/auth")
		.usernameParameter("userId")
		.passwordParameter("passWord")
		.successHandler(new SuccessLoginHandler())
		;
		
		
		return http.build();
	}
	
	/**
	 * csrf 토큰을 추가
	 * Header에 추가하기 위한 세팅
	 * 
	 * 
	 * default			Setting value
	 * Session Id = ...HttpSessionCsrfTokenRepository.CSRF_TOKEN => CSRF_TOKEN  세션에 담기는 속성 이름 변경
	 * HeaderName = X-CSRF-TOKEN => X-XSRF-TOKEN  헤더네임 변경
	 * ParameterName(valueName) = _csrf => csrfToken  파라미터 이름 변경
	 * @return
	 */
	@Bean
    public CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        repository.setParameterName("csrfToken");
        repository.setSessionAttributeName("CSRF_TOKEN");
        return repository;
    }
}
