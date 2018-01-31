package com.test.name.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.name.service.INameService;


/**
 * 
 * @author wanggang
 * from：http://blog.csdn.net/zzy2011266/article/details/42011047
 */
@Controller
@RequestMapping("/name")
public class ChineseName {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private INameService nameService;
	
	@RequestMapping(value="/generate", method={RequestMethod.GET, RequestMethod.POST})
	public void generateName() {
		try {
			nameService.generate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
