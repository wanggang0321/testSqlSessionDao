package com.test.phone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.phone.service.IPhoneService;

@Controller
@RequestMapping("/phone")
public class IPhoneController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IPhoneService phoneService;
	
	@RequestMapping(value="/getPhoneNumber", method={RequestMethod.GET, RequestMethod.POST})
	public void getPhoneNumber() {
		try {
			logger.info(phoneService.getTel());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
