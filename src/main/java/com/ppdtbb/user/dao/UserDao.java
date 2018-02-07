package com.ppdtbb.user.dao;

import java.util.List;

import com.ppdtbb.user.pojo.User;

public interface UserDao {
	
	//添加用户
	public void insertUser(User user) throws Exception;
	
	//根据ID查找用户
	public User findUserById(Integer userId) throws Exception;
	
	//根据姓名模糊查询
	public List<User> findUserByName(String name) throws Exception;
	
	//删除用户
	public void deleteUser(Integer id) throws Exception;
	
	//更新用户
	public void updateUser() throws Exception;
	
}
