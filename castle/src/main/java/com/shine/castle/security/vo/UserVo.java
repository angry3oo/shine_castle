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
	private String userRole;
	private String userMail;
	private String userPhoneNum;
	private String userAddress;
	private String userSex;
	private String userBirth;
	private String userRgsDate;
	private String userNonExpired;
	private String userNonLocked;
	private String userNonPassExpired;
	private String userNonEnabled;
	
	
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
		return this.accountNon(userNonExpired);
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNon(userNonLocked);
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.accountNon(userNonPassExpired);
	}

	@Override
	public boolean isEnabled() {
		return this.accountNon(userNonEnabled);
	}
	
	public boolean accountNon(String non) {
		return non != null && non.equals("Y") ? true : false;
	}

}
