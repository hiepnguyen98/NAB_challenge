package com.challenge.eCommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "order_detail")
public class OrderDetailEntity {
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "orders_id")
	private OrderEntity orders;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;
	
	@NotNull
	@Column(name = "unit_price")
	private double unitPrice;
	
	@NotNull
	@Column(name = "quantity")
	private int quantity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OrderEntity getOrder() {
		return orders;
	}

	public void setOrder(OrderEntity orders) {
		this.orders = orders;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderDetailEntity(long id, OrderEntity orders, ProductEntity product, double unitPrice, int quantity) {
		super();
		this.id = id;
		this.orders = orders;
		this.product = product;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public OrderDetailEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
