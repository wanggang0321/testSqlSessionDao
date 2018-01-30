package com.test.address.service.impl;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.address.dao.AddressDao;
import com.test.address.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private AddressDao addressDao;
	
	public int randomAreaCode() throws Exception {  
        int index = (int) (Math.random() * addressDao.areaCode.size());  
        Collection<Integer> values = addressDao.areaCode.values();  
        Iterator<Integer> it = values.iterator();  
        int i = 0;  
        int code = 0;  
        while (i < index && it.hasNext()) {  
            i++;  
            code = it.next();  
        }  
        return code;  
    }
	
}
