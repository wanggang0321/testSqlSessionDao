package com.gupao.edu.gpmybatis;

import com.gupao.edu.mybatis.entity.SysUser;

/**
 * @author wanggang
 * @date 2018年4月2日 下午4:30:16
 * 
 */
public class Entry {

	public static void main(String[] args) {
		GpSqlSession sqlSession = new GpSqlSession(new GpConfiguration(), new GpSimpleExecutor());
		TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
		SysUser sysUser = testMapper.selectByPrimaryKey(1);
		System.out.println(sysUser.getUserId() + " " + sysUser.getUserName() + " " + sysUser.getEmail());
	}

}
