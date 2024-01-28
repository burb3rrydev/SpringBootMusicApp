package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class UserEntity
{
	 @Id
	 private Long id;
	
	 @Column("firstName")
	 private String firstName;

	 @Column("lastName")
	 private String lastName;

	 @Column("email")
	 private String email;

	 @Column("phoneNumber")
	 private String phoneNumber;

	 @Column("username")
	 private String username;

	 /**
	  * UserEntity default constructor
	  */
	 public UserEntity()
	 {
		 
	 }
	 
	 /**
	  * UserEntity constructor with id
	  * @param id
	  * @param firstName
	  * @param lastName
	  * @param email
	  * @param phoneNumber
	  * @param username
	  * @param password
	  */
	 public UserEntity(Long id, String firstName, String lastName, String email, String phoneNumber, String username,
			String password)
	 {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	 }
	 
	 /**
	  * UserEntity constructor without id
	  * @param firstName
	  * @param lastName
	  * @param email
	  * @param phoneNumber
	  * @param username
	  * @param password
	  */
	 public UserEntity(String firstName, String lastName, String email, String phoneNumber, String username,
				String password) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.username = username;
			this.password = password;
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	@Column("password")
	 private String password;
}
