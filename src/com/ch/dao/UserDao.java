package com.ch.dao;

import org.apache.ibatis.annotations.Param;

import com.ch.model.User;

/**
 * �û���Ϣ�ӿ�
 * 
 * @author livi.cui
 *
 */
public interface UserDao {

	
	public User getUser(@Param("username")  String username,  @Param("password") String password);
	
	
	
	
}
