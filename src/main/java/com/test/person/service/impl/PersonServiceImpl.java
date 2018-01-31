package com.test.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.idcard.service.IdCardService;
import com.test.name.service.INameService;
import com.test.person.entity.Person;
import com.test.person.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {
	
	@Autowired
	private IdCardService idCardService;
	@Autowired
	private INameService nameService;
	
	public Person createPerson() throws Exception {
		
		//姓名
		
		//身份证号
		
		//性别
		
		//所属地区
		
		//手机号
		
		return null;
	}
	
}
