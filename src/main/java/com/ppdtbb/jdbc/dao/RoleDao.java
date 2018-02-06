package com.ppdtbb.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ppdtbb.jdbc.model.Role;
import com.ppdtbb.jdbc.util.DbUtil;

public class RoleDao {
	
	public Role get() throws SQLException {
		
		//获取连接
		Connection conn = DbUtil.getConnection();
		
		//sql
		String sql = "select * from role where roldId=?";
		
		//预编译sql，减少sql执行
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		//传参
		ptmt.setInt(0, 1);
		
		//执行
		ResultSet rs = ptmt.executeQuery();
		
		return null;
	}
	
}
