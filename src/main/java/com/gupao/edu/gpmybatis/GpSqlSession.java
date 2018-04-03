package com.gupao.edu.gpmybatis;

import java.lang.reflect.Proxy;

/**
 * @author wanggang
 * @date 2018年4月2日 上午10:18:35
 * 
 */
public class GpSqlSession {

	private GpConfiguration gpConfiguration;
	private GpExecutor gpExecutor;
	
	public GpSqlSession(GpConfiguration gpConfiguration, GpExecutor gpExecutor) {
		this.gpConfiguration = gpConfiguration;
		this.gpExecutor = gpExecutor;
	}
	
	public <T> T getMapper(Class<T> clazz) {
		return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, new GpMapperProxy(this));
	}
	
	public <T> T selectOne(String statement, String parameter) {
		return gpExecutor.query(statement, parameter);
	}
	
}
