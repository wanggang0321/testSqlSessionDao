package com.ppdtbb.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ppdtbb.jdbc.model.Role;
import com.ppdtbb.jdbc.util.DbUtil;

public class RoleDao {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	public void testJdbc() {
		try {
			Role role = get(2);
			System.out.println(role);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Role get(Integer id) throws SQLException {
		
		Role role = null;
		
		//获取连接
		Connection conn = DbUtil.getConnection();
		
		//sql
		String sql = "select * from role where roleId=?";
		
		//预编译sql，减少sql执行
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参
		ptmt.setString(1, "2");
		
		//执行
		ResultSet rs = ptmt.executeQuery();
		
		while(rs.next()) {
			role = new Role();
			String roleId = rs.getString("roleId");
			String roleName = rs.getString("roleName");
			logger.info("roleId is {}, roleName is {}", roleId, roleName);
			
			role.setRoleID(roleId);
			role.setRoleName(roleName);
		}
		
		return role;
	}
	
}
