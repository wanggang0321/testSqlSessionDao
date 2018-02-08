package com.ppdtbb.user.pojo;

import java.util.Date;

public class User {
	
	private Integer id;
	//用户名称
	private String username;
	//Integer这里是个坑
	private Integer chineseName;
	//生日
	private Date birthday;
	//性别
	private String sex;
	//地址
	private String address;
	
	public User() {
		super();
	}

	public User(String username, Integer chineseName, Date birthday, String sex,
			String address) {
		super();
		this.username = username;
		this.chineseName = chineseName;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getChineseName() {
		return chineseName;
	}
	public void setChineseName(Integer chineseName) {
		this.chineseName = chineseName;
	}
	
}
