package com.shine.castle.security.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.shine.castle.config.CamelMap;
import com.shine.castle.security.vo.UserVo;

@Mapper
public interface SecurityMapper {
	public UserVo findUserDetails(String userId);
	
	public CamelMap idCheck(UserVo userVo);
}
