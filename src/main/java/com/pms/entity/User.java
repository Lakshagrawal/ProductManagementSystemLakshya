package com.pms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long uid;
	
	@Column(name = "fname")
    private String firstName;
	
	@Column(name = "lname")
    private String lastName;
	
	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "Please provide a valid email address")
    private String email;
	
	@Column(name = "mobile_number")
    private long mobileNumber;
	
	@Column(name = "isAdmin")
	private boolean isAdmin;
	
	public boolean getAdmin() {
		return this.isAdmin;
	}
	public User() {
		
	}
	
	@Column(name = "username", nullable=false)
    private String username;
	
	public User(String firstName, String lastName,
			@Email(message = "Please provide a valid email address") String email, long mobileNumber, 
			String username, String password, boolean isAdmin) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.isAdmin = isAdmin;
		this.username = username;
		this.password = password;
	}

	@Column(name = "password")
    private String password;
    
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
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
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
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
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", isAdmin=" + isAdmin + ", username=" + username + ", password="
				+ password + "]";
	}
    
	

    
}
