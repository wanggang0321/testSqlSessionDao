package com.test.person.service;

import com.test.person.entity.Person;

public interface IPersonService {
	
	/**
	 * 创建个人信息
	 * @return
	 * @throws Exception
	 */
	public Person createPerson() throws Exception;
	
}
