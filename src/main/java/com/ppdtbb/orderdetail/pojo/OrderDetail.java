package com.ppdtbb.orderdetail.pojo;

/**
 * 订单明细表
 */
public class OrderDetail {
	
	private Integer id;
	//订单id
	private Integer ordersId;
	//商品id
	private Integer itemsId;
	//商品购买数量
	private Integer itemsNum;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}
	public Integer getItemsId() {
		return itemsId;
	}
	public void setItemsId(Integer itemsId) {
		this.itemsId = itemsId;
	}
	public Integer getItemsNum() {
		return itemsNum;
	}
	public void setItemsNum(Integer itemsNum) {
		this.itemsNum = itemsNum;
	}
	
}
