package com.test.address.controller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.address.service.IAddressService;

@Controller
@RequestMapping("/address")
public class AddressController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IAddressService addressService;
	
	@RequestMapping(value="/getAddressInfo", method={RequestMethod.GET, RequestMethod.POST})
	public void getAddressInfo() {
		try {
			logger.info(addressService.randomAreaCode() + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
