package com.ppdtbb.mybatis;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ppdtbb.mybatis.mapper.UserMapper;
import com.ppdtbb.user.pojo.User;
import com.ppdtbb.user.pojo.UserQueryVo;

public class UserMapperTest {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 创建SqlSessionFactory
	 */
	@Before
	public void createSqlSessionFactory() throws Exception {
		//配置文件
		String file = "mybatis/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(file);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，MyBatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		logger.info("user info is :" + user.getUsername() + user.getBirthday() + user.getAddress());
		sqlSession.close();
	}
	
	@Test
	public void testFindUserByName() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，MyBatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = userMapper.findUserByName("国");
		for(User user : userList) {
			logger.info("user info is :" + user.getUsername() + user.getBirthday() + user.getAddress());
		}
		sqlSession.close();
	}
	
	@Test
	public void testFindUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，MyBatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		User userQuery = new User();
		userQuery.setSex("男");
		userQuery.setUsername("国");
		userQueryVo.setUser1(userQuery);
		
		//传入多个id
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		ids.add(4);
		userQueryVo.setIds(ids);
		
		try {
			List<User> userList = userMapper.findUserList(userQueryVo);
			for(User user : userList) {
				logger.info("user info is :" + user.getUsername() + user.getBirthday() + user.getAddress());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
}
