package com.ppdtbb.orders.vo;

import com.ppdtbb.orders.pojo.Orders;

/**
 * 通过此类映射订单和用户的查询结果，让此类继承包括字段较多的po类
 */
public class OrdersCustom extends Orders {
	
	//继承了orders，已经拥有orders的所有属性了
	
	//添加用户属性
	private String username;
	private String sex;
	private String address;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
}
