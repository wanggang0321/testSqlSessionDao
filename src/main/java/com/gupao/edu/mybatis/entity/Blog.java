package com.gupao.edu.mybatis.entity;

import java.util.Date;

/**
 * @author wanggang
 * @date 2018年4月2日 上午10:31:15
 * 
 */
public class Blog {
	
	private Integer id;
	private String title;
	private Date createTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
