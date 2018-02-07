package com.ppdtbb.user;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.ppdtbb.user.dao.UserDao;
import com.ppdtbb.user.dao.impl.UserDaoImpl;

public class UserDaoImplTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception {
		//MyBatis的配置文件
		String xmlFile = "mybatis/mybatis-config.xml";
		
		//得到配置文件的流
		InputStream inputStream = Resources.getResourceAsStream(xmlFile);
		
		//创建回话工厂SqlSessionFactory，要传入MyBatis的配置文件的流
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		System.out.println(userDao.findUserById(1));
	}
	
}
