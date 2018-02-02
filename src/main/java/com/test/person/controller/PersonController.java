package com.test.person.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.person.entity.Person;
import com.test.person.service.IPersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IPersonService personService;
	
	@RequestMapping(value="/create", method={RequestMethod.GET, RequestMethod.POST})
	public void createPerson() {
		try {
			Person person = personService.createPerson();
			logger.info(person.getName() + " " 
					+ person.getIdCardNumber() + " " 
					+ person.getCellphone());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
