package com.gupao.edu.gpmybatis;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wanggang
 * @date 2018年4月2日 上午10:25:32
 * 
 */
public class GpConfiguration {
	
	public <T> T getMapper(Class<T> clazz, GpSqlSession sqlSession) {
		return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new GpMapperProxy(sqlSession));
	}
	
	/**
	 * xml解析好了
	 */
	static class TestMapperXml {
		
		public static final String namespace = "com.gupao.edu.gpmybatis.TestMapper";
		public static final Map<String, String> methodSqlMapping = new HashMap<String, String>();
		
		static {
			methodSqlMapping.put("selectByPrimaryKey", "SELECT * FROM sys_user WHERE user_id=%d");
		}
	}
	
}
