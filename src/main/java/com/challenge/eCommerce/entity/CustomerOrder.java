package com.challenge.eCommerce.entity;

import java.util.List;

public class CustomerOrder {
	private OrderEntity order;
	private List<OrderDetailEntity> orderDetails;
	
	public OrderEntity getOrder() {
		return order;
	}
	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	public List<OrderDetailEntity> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetailEntity> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public CustomerOrder(OrderEntity order, List<OrderDetailEntity> orderDetails) {
		super();
		this.order = order;
		this.orderDetails = orderDetails;
	}
	public CustomerOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
