package com.ppdtbb.user.mapper;

import java.util.List;

import com.ppdtbb.orders.vo.OrdersCustom;

public interface UserMapperOrders {
	
	/**
	 * 查询订单，关联查询用户信息
	 */
	public List<OrdersCustom> findOrdersUser() throws Exception;
	
}
