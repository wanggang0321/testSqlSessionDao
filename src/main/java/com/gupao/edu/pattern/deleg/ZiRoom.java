package com.gupao.edu.pattern.deleg;

/**
 * @author wanggang
 * @date 2018年4月16日 上午10:53:26
 * 
 */
public class ZiRoom implements FindHouse {

	public void getHouse(String requirement) {
		System.out.println("ZrRoom App find house by " + requirement);
	}

}
