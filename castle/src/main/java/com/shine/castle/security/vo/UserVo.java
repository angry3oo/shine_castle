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

	private String id = "";
	private String password = "";
	
	private String name = "";
	
	//USER(일반유저), ADMIN(관리자)
	private String role = "";
	private String mail = "";
	private String phoneNum = "";
	private String address = "";
	private String sex = "";
	private String birth = "";
	private String rgsDate = "";
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> roles = new ArrayList<>();
		roles.add(
			new GrantedAuthority() {
				@Override
				public String getAuthority() {
					return "ROLE_"+role;
				}
			}
		);
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return id;
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
