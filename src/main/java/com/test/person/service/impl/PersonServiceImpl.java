package com.test.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hutool.core.util.IdcardUtil;

import com.test.address.service.IAddressService;
import com.test.idcard.service.IdCardService;
import com.test.name.service.INameService;
import com.test.person.entity.Person;
import com.test.person.service.IPersonService;
import com.test.phone.service.IPhoneService;

@Service
public class PersonServiceImpl implements IPersonService {
	
	@Autowired
	private IdCardService idCardService;
	@Autowired
	private INameService nameService;
	@Autowired
	private IPhoneService phoneService;
	@Autowired
	private IAddressService addressService;
	
	public Person createPerson() throws Exception {
		
		Person person = new Person();
		
		//姓名
		String chineseName = nameService.generate();
		person.setName(chineseName);
		
		//身份证号
		String idCardNumber = idCardService.generate();
		person.setIdCardNumber(idCardNumber);
		
		//性别
		int sex = IdcardUtil.getGenderByIdCard(idCardNumber);
		person.setSex(1==sex?"男":"女");
		
		//年龄
		int age = IdcardUtil.getAgeByIdCard(idCardNumber);
		person.setAge(age);
		
		//所属地区
		String address = IdcardUtil.getProvinceByIdCard(idCardNumber);
		person.setAddress(address);
		
		//手机号
		String tel = phoneService.getTel();
		person.setCellphone(tel);
		
		return person;
	}
	
}
