package com.gupao.edu.pattern.deleg1;

/**
 * @author wanggang
 * @date 2018年4月16日 上午11:17:37
 * 
 */
public class EmployeeA implements ITarget {

	public void doing(String someting) {
		System.out.println("我是员工 A，我现在开始做 " + someting + " 功能。");
	}

}
