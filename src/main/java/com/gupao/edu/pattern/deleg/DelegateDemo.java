package com.gupao.edu.pattern.deleg;

/**
 * @author wanggang
 * @date 2018年4月16日 上午10:56:32
 * 
 */
public class DelegateDemo {

	public static void main(String[] args) {
		Member me = new Member();
		me.getHouse("便宜");
		me.toZiRoom();
		me.getHouse("便宜");
	}

}
