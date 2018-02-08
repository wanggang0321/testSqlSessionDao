package com.ppdtbb.user.pojo;

import java.util.List;


public class UserQueryVo {
	
	//在这里添加其它查询条件
	
	//传入多个id
	private List<Integer> ids;
	
	//用户查询条件
	private User user1;

	public User getUser1() {
		return user1;
	}
	public void setUser1(User user1) {
		this.user1 = user1;
	}
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

}
