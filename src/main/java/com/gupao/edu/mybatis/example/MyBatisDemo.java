package com.gupao.edu.mybatis.example;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gupao.edu.mybatis.mapper.TestMapper;

/**
 * @author wanggang
 * @date 2018年4月2日 上午9:13:25
 * 
 */
public class MyBatisDemo {
	
	public static void main(String[] args) {
		String resource = "";
		try {
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
			SqlSession sqlSession = sqlSessionFactory.openSession();
			TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
