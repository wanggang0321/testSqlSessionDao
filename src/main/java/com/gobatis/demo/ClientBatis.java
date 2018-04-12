package com.gobatis.demo;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gobatis.plugins.ExamplePlugin;

/**
 * @author wanggang
 * @date 2018年4月12日 下午1:52:59
 * 
 */
public class ClientBatis {
	
	public static void main(String[] args) {
		try {
			String resource = "mybatis/mybatis-config.xml"; //获取mybatis配置文件路径
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			Map map = new HashMap();
			map = (Map)new ExamplePlugin().plugin(map);
			System.out.println(map.get(""));
		} catch(Exception e) {
			
		}
	}
	
}
