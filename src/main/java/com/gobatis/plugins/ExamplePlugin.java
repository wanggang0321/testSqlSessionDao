package com.gobatis.plugins;

import java.util.Iterator;
import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;

/**
 * @author wanggang
 * @date 2018年4月12日 下午1:47:55
 * 
 */
public class ExamplePlugin implements Interceptor {

	/*
	 * 此方法用于实现拦截逻辑
	 * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin.Invocation)
	 */
	public Object intercept(Invocation invocation) throws Throwable {
		
//		return "ExamplePlugin";
		return invocation.proceed();
	}

	/*
	 * 使用当前的这个拦截器实现对目标对象的代理（内部实现时Java的动态代理）
	 * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object)
	 */
	public Object plugin(Object target) {
		
		return Plugin.wrap(target, this);
	}

	/*
	 * 此方法和上一节所讲的自定义对象工厂中的setProperties一样，初始化Configuration时通过配置文件配置property传递参数给此方法并调用。
	 * @see org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)
	 */
	public void setProperties(Properties properties) {
		Iterator iterator = properties.keySet().iterator();
		while (iterator.hasNext()){
			String keyValue = String.valueOf(iterator.next());
			System.out.println("读取初始化参数：" + properties.getProperty(keyValue));
		}
	}

}
