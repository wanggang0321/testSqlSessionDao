package com.gupao.edu.pattern.deleg1;

/**
 * @author wanggang
 * @date 2018年4月16日 上午11:17:57
 * 
 */
public class EmployeeB implements ITarget {

	public void doing(String someting) {
		System.out.println("我是员工 B，我现在开始做 " + someting + " 功能。");
	}

}
