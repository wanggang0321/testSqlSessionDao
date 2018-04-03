package com.gupao.edu.gpmybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wanggang
 * @date 2018年4月2日 上午11:49:04
 * 
 */
public class GpMapperProxy implements InvocationHandler {
	
	private GpSqlSession gpSqlSession;
	
	public GpMapperProxy(GpSqlSession gpSqlSession) {
		this.gpSqlSession = gpSqlSession;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		if(method.getDeclaringClass().getName().equals(GpConfiguration.TestMapperXml.namespace)) {
			
			String sql = GpConfiguration.TestMapperXml.methodSqlMapping.get(method.getName());
			return gpSqlSession.selectOne(sql, String.valueOf(args[0]));
		}
		return method.invoke(this, args);
	}

}
