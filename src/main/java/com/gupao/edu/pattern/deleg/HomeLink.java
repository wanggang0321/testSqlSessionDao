package com.gupao.edu.pattern.deleg;

/**
 * @author wanggang
 * @date 2018年4月16日 上午10:52:05
 * 
 */
public class HomeLink implements FindHouse {

	public void getHouse(String requirement) {
		System.out.println("HomeLinke find house by " + requirement);
	}

}
