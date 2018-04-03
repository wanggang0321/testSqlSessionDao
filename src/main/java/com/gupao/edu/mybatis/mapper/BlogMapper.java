package com.gupao.edu.mybatis.mapper;

import com.gupao.edu.mybatis.entity.Blog;

/**
 * @author wanggang
 * @date 2018年4月2日 上午10:30:36
 * 
 */
public interface BlogMapper {
	
	public Blog selectByPrimaryKey(Integer id);
	
}
