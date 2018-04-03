package com.gupao.edu.gpmybatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gupao.edu.mybatis.entity.SysUser;

/**
 * @author wanggang
 * @date 2018年4月2日 下午1:49:29
 * 
 */
public class GpSimpleExecutor implements GpExecutor {

	public <T> T query(String statement, String parameter) {
		
		Connection connection = null;
		SysUser sysUser = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://140.143.153.135:3306/luwak?useUnicode=true&characterEncoding=UTF8&characterSetResults=UTF8&autoReconnect=true&failOverReadOnly=false", 
					"root", "root");
			String sql = String.format(statement, Integer.parseInt(parameter));
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				sysUser = new SysUser();
				sysUser.setUserId(resultSet.getInt(1));
				sysUser.setUserName(resultSet.getString(2));
				sysUser.setEmail(resultSet.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null!=connection) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return (T) sysUser;
	}

}
