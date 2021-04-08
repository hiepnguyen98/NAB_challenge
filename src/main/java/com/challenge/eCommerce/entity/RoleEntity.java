package com.challenge.eCommerce.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(targetEntity = StaffEntity.class, mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<StaffEntity> staff;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public RoleEntity(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
