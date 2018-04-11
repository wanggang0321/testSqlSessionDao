package com.gupao.edu.pattern.proxy;

/**
 * @author wanggang
 * @date 2018年4月11日 上午10:53:48
 * 
 */
public class Car implements Moveable {

	public void move(Integer meters) {
		try {
			Thread.sleep(1000);
			System.out.println("The car is moving, " + meters + " meters.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
