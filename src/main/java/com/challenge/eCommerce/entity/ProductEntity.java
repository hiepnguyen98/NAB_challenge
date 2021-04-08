package com.challenge.eCommerce.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "product")
public class ProductEntity {
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Column(name = "product_name")
	private String productName;
	
	@NotNull
	@Column(name = "price")
	private double price;
	
	@NotNull
	@Column(name = "quantity")
	private int quantity;
	
	@NotNull
	@Column(name = "decription")
	private String decription;
	
	@Column(name = "color")
	private String color;
	
	@NotNull
	@Column(name = "image")
	private String image;
	@ManyToOne
	@JoinColumn(name = "branch_id")
	private BranchEntity branch;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
	@OneToMany(targetEntity = OrderDetailEntity.class, mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<OrderDetailEntity> orderDetail;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BranchEntity getBranch() {
		return branch;
	}

	public void setBranch(BranchEntity branch) {
		this.branch = branch;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ProductEntity(long id, String productName, double price, int quantity, String decription, String color,
			String image, BranchEntity branch, CategoryEntity category) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.decription = decription;
		this.color = color;
		this.image = image;
		this.branch = branch;
		this.category = category;
	}

	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
