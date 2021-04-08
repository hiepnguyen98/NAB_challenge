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
@Table(name = "branch")
public class BranchEntity {
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Column(name = "branch_name")
	private String branchName;
	
	@OneToMany(targetEntity = ProductEntity.class, mappedBy = "branch", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ProductEntity> products;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public BranchEntity(long id, String branchName) {
		super();
		this.id = id;
		this.branchName = branchName;
	}
	public BranchEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
