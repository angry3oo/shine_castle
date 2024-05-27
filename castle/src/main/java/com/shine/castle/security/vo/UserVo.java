package com.shine.castle.security.vo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVo implements UserDetails{

	private String userId = "";
	private String userPassWord = "";
	
	private String userName = "";
	
	//USER(일반유저), ADMIN(관리자)
	private String userRole = "";
	private String userMail = "";
	private String userPhoneNum = "";
	private String userAddress = "";
	private String userSex = "";
	private String userBirth = "";
	private String userRgsDate = "";
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> roles = new ArrayList<>();
		roles.add(
			new GrantedAuthority() {
				@Override
				public String getAuthority() {
					return "ROLE_"+userRole;
				}
			}
		);
		return roles;
	}

	@Override
	public String getPassword() {
		return userPassWord;
	}

	@Override
	public String getUsername() {
		return userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
