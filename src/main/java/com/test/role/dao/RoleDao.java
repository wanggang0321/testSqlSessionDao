package com.test.role.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.test.common.dao.BaseDao;
import com.test.role.entity.Role;

@Repository
public class RoleDao extends BaseDao<Role> {
	
	public List<Role> selectRoleAll(Map map) {
		List<Role> roleList = super.getSqlSession().selectList("Role.SelectRoleAll", map);
		return roleList;
	}
	
	public int SelectRoleALL_Count(Map map){
		int count = super.getSqlSession().selectOne("Role.SelectRoleALL_Count",map);
		return count;
	}
	
}
