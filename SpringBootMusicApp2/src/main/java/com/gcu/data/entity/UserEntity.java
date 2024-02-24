package com.gcu.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity
{
	@Id
	String id;
	
	@Column(name="username")
	String username;
	
	@Column(name="password")
	String password;
	
	public UserEntity()
	{
		
	}
	
	public UserEntity(String id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
