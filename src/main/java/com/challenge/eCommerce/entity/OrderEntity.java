package com.challenge.eCommerce.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "orders")
public class OrderEntity {
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Column(name = "total_price")
	private double totalPrice;
	
	@NotNull
	@Column(name = "customer_name")
	private String customerName;
	
	@NotNull
	@Column(name = "order_email")
	private String orderEmail;
	
	@NotNull
	@Column(name = "order_phone_number")
	private String orderPhoneNumber;
	
	@NotNull
	@Column(name = "order_address")
	private String orderAddress;
	
	@OneToMany(targetEntity = OrderDetailEntity.class, mappedBy = "orders", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<OrderDetailEntity> orderDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOrderEmail() {
		return orderEmail;
	}

	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
	}

	public String getOrderPhoneNumber() {
		return orderPhoneNumber;
	}

	public void setOrderPhoneNumber(String orderPhoneNumber) {
		this.orderPhoneNumber = orderPhoneNumber;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrder_address(String order_address) {
		this.orderAddress = order_address;
	}

	public OrderEntity(long id, double totalPrice, String customerName, String orderEmail, String orderPhoneNumber,
			String orderAddress) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.customerName = customerName;
		this.orderEmail = orderEmail;
		this.orderPhoneNumber = orderPhoneNumber;
		this.orderAddress = orderAddress;
	}

	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
