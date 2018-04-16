package com.gupao.edu.pattern.deleg1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanggang
 * @date 2018年4月16日 上午11:17:12
 * 
 */
public class Leader implements ITarget {
	
	private Map<String, ITarget> targetMap = new HashMap<String, ITarget>();
	
	public Leader() {
		targetMap.put("登录", new EmployeeA());
		targetMap.put("注册", new EmployeeB());
	}
	
	public void doing(String someting) {
		targetMap.get(someting).doing(someting);
	}

}
