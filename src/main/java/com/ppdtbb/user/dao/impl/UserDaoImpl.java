package com.ppdtbb.user.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ppdtbb.user.dao.UserDao;
import com.ppdtbb.user.pojo.User;

public class UserDaoImpl implements UserDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	//需要向Dao实现类中注入SqlSessionFactory，由于没有和spring整合，这里通过构造函数注入
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void insertUser(User user) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("test0206.insertUser", user);
		session.commit();
		session.close();
	}

	public User findUserById(Integer userId) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("test0206.findUserById", userId);
		session.close();
		return user;
	}

	public List<User> findUserByName(String name) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		List<User> userList = session.selectList("test0206.findUserByName", name);
		session.close();
		return userList;
	}

	public void deleteUser(Integer id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("test0206.deleteUser", id);
		session.commit();
		session.close();
	}

	public void updateUser() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		User updateUser = new User("奚文文", new Date(), "女", "北京市西城区");
		updateUser.setId(4);
		session.update("test0206.updateUser", updateUser);
		session.commit();
		session.close();
	}

}
