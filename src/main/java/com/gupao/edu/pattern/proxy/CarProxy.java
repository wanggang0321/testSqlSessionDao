package com.gupao.edu.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wanggang
 * @date 2018年4月11日 上午10:54:37
 * 
 */
public class CarProxy implements InvocationHandler {
	
	private Object target;
	
	public CarProxy(Object target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		long start = System.currentTimeMillis();
		System.out.println("Starting move.");
		method.invoke(target, args[0]);
		long end = System.currentTimeMillis();
		System.out.println("End moving, cost (" + (end-start) + ") ms.");
		
		return null;
	}

}
