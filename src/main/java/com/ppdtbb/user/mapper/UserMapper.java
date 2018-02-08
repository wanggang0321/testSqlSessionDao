package com.ppdtbb.user.mapper;

import java.util.List;

import com.ppdtbb.user.pojo.User;
import com.ppdtbb.user.pojo.UserQueryVo;

//mapper接口，相当于dao接口
public interface UserMapper {
	
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
	
	//用户信息综合查询
	public List<User> findUserList(UserQueryVo userQueryVo) throws Exception;
	
}
