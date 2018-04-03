package com.gupao.edu.mybatis.example;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gupao.edu.mybatis.mapper.BlogMapper;

/**
2  * @author wanggang
3  * @date 2018年3月29日 上午9:27:46
4  * 
5  */
public class MyBatisTest {
	
	public static void main(String[] args) {
		try {
			String resource = "mybatis/example/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
			blogMapper.selectByPrimaryKey(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
