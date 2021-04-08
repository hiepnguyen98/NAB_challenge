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
@Table(name="staff")
public class StaffEntity {
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Column(name = "full_name")
	private String fullName;
	
	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "user_name")
	private String userName;
	
	@NotNull
	@Column(name = "password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleEntity role;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RoleEntity getRole() {
		return role;
	}
	public void setRole(RoleEntity role) {
		this.role = role;
	}
	public StaffEntity(long id, String fullName, String email, String userName, String password, RoleEntity role) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public StaffEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
