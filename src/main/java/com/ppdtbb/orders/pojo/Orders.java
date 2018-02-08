package com.ppdtbb.orders.pojo;

import java.util.Date;

/**
 * 订单表
 */
public class Orders {
	
	private Integer id;
	//下单用户id
	private Integer userId;
	//订单号
	private String number;
	//创建订单时间
	private Date createtime;
	//备注
	private String note;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
