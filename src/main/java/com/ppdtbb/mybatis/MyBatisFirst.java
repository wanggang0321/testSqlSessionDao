package com.ppdtbb.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisFirst {
	
	public SqlSession getSqlSession() throws Exception {
		
		//MyBatis的配置文件
		String xmlFile = "mybatis-config.xml";
		
		//得到配置文件的流
		InputStream inputStream = Resources.getResourceAsStream(xmlFile);
		
		//创建回话工厂SqlSessionFactory，要传入MyBatis的配置文件的流
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
	
}
