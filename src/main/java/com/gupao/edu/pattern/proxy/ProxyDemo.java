package com.gupao.edu.pattern.proxy;

import java.lang.reflect.Proxy;

/**
 * @author wanggang
 * @date 2018年4月11日 上午10:56:57
 * 
 */
public class ProxyDemo {
	
	public static void main(String[] args) {
		Moveable move = (Moveable) Proxy.newProxyInstance(Moveable.class.getClassLoader(), new Class[]{Moveable.class}, new CarProxy(new Car()));
		move.move(100);
	}
	
}
