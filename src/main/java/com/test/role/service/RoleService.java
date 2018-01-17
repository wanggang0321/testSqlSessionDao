package com.test.role.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.role.dao.RoleDao;
import com.test.role.entity.Role;

@Service
public class RoleService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RoleDao roleDao;
	
	public List<Role> SelectRoleALL(Map map) {
		List<Role> list = roleDao.selectRoleAll(map);
		return list;
	}
	
	public int SelectRoleALL_Count(Map map) {
		
		return roleDao.SelectRoleALL_Count( map);
	}
	
}
