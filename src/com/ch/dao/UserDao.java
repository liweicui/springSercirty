package com.ch.dao;

import org.apache.ibatis.annotations.Param;

import com.ch.model.User;

/**
 * 用户信息接口
 * 
 * @author livi.cui
 *
 */
public interface UserDao {

	
	public User getUser(@Param("username")  String username,  @Param("password") String password);
	
	
	
	
}
