package com.ppdtbb.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ppdtbb.user.pojo.User;

public class MyBatisFirst {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public SqlSession getSqlSession() throws Exception {
		
		//MyBatis的配置文件
		String xmlFile = "mybatis/mybatis-config.xml";
		
		//得到配置文件的流
		InputStream inputStream = Resources.getResourceAsStream(xmlFile);
		
		//创建回话工厂SqlSessionFactory，要传入MyBatis的配置文件的流
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
	
	@Test
	public void get() {
		try {
//			findUserById(1);
			findUserByName("1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findUserById(Integer userId) throws Exception {
		
		//获得SqlSession
		SqlSession session = getSqlSession();
		
		/*
		 * 通过SqlSession操作数据库
		 * 第一个参数：映射文件中statement的id = namespace + statement的id
		 * 第二个参数：指定和映射文件中parameterType类型所匹配的参数
		 */
		//selectOne查询出一条记录进行映射
		User user = session.selectOne("test0206.findUserById", userId);
		
		logger.info("user is :" + user);
		
		//释放资源
		session.close();
	}
	
	public void findUserByName(String name) throws Exception {
		
		//获得SqlSession
		SqlSession session = getSqlSession();
		
		/*
		 * 通过SqlSession操作数据库
		 * 第一个参数：映射文件中statement的id = namespace + statement的id
		 * 第二个参数：指定和映射文件中parameterType类型所匹配的参数
		 */
		//selectOne查询出一条记录进行映射
		List<User> userList = session.selectList("test0206.findUserByName", name);
		
		logger.info("userList is :" + userList);
		
		//释放资源
		session.close();
	}
	
}
