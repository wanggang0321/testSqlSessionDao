package com.gupao.edu.pattern.deleg1;

/**
 * @author wanggang
 * @date 2018年4月16日 上午11:21:44
 * 
 */
public class Boss {

	public static void main(String[] args) {
		Leader leader = new Leader();
		leader.doing("登录");
		leader.doing("注册");
	}

}
