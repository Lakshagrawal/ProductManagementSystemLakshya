package com.pms.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
	public Product(String pname, int qty, int price) {
		super();
		this.pname = pname;
		this.qty = qty;
		this.price = price;
	}
	public Product() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long pid;

	@Column(name = "pname")
	private String pname;

	@Column(name = "qty")
	private int qty;

	@Column(name = "price")
	private int price;
	
	@Column(name = "created_date", nullable = false, updatable = false)
	private LocalDateTime createdDate;
	
	@PrePersist
	protected void onCreate() {
		createdDate = LocalDateTime.now();
	}
		
	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", price=" + price + ", createdDate="
				+ createdDate + "]";
	}

}
