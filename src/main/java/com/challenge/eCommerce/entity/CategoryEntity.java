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
@Table(name = "category")
public class CategoryEntity {
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Column(name = "category_name")
	private String categoryName;
	
	@OneToMany(targetEntity = ProductEntity.class, mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ProductEntity> products;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public CategoryEntity(long id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	public CategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
