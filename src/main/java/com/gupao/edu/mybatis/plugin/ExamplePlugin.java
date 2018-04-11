package com.gupao.edu.mybatis.plugin;

import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

/**
 * @author wanggang
 * @date 2018年4月9日 上午9:37:11
 * 
 */
@Intercepts(value = { @Signature(args = { Objects.class }, method = "get", type = Map.class) })
public class ExamplePlugin implements Interceptor {

	/*
	 * 此方法用于实现拦截逻辑
	 * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin.Invocation)
	 */
	public Object intercept(Invocation invocation) throws Throwable {
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object)
	 */
	public Object plugin(Object target) {
		
		return null;
	}

	public void setProperties(Properties properties) {

	}

}
