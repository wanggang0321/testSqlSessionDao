package com.gupao.edu.pattern.deleg;

/**
 * @author wanggang
 * @date 2018年4月16日 上午10:54:22
 * 
 */
public class Member implements FindHouse {
	
	private FindHouse finder = new HomeLink();
	
	public void getHouse(String requirement) {
		finder.getHouse(requirement);
	}
	
	public void toHomeLink() {
		finder = new HomeLink();
	}
	
	public void toZiRoom() {
		finder = new ZiRoom();
	}

}
