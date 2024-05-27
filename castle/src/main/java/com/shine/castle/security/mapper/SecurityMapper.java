package com.shine.castle.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper
public interface SecurityMapper {
	public UserDetails findUserDetails(String userId);
}
