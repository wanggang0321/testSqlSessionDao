package com.test.idcard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.idcard.service.IdCardService;

@Controller
@RequestMapping("/idCard")
public class IdCardController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IdCardService idCardService;
	
	
	public void generate() throws Exception {
		
	}
	
}
