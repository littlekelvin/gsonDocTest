package com.oocl.ir4.doc.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Customer {
	
	private long cid;
	private String name;
	private String phone;
	private int age;
	private double salary;
	
	@ManyToMany
	private Address address;

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(long cid, String name, String phone, int age, double salary, Address address) {
		super();
		this.cid = cid;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.salary = salary;
		this.address = address;
	}



	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
