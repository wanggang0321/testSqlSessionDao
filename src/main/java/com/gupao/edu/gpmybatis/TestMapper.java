package com.gupao.edu.gpmybatis;

import com.gupao.edu.mybatis.entity.SysUser;

/**
 * @author wanggang
 * @date 2018年4月2日 下午4:29:34
 * 
 */
public interface TestMapper {
	
	public SysUser selectByPrimaryKey(Integer userId);

}
