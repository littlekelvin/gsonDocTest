package com.oocl.ir4.doc.entity;

import javax.persistence.Entity;

@Entity
public class Address {
	private int aid;
	private String code;
	private String name;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public Address(int aid, String code, String name) {
		super();
		this.aid = aid;
		this.code = code;
		this.name = name;
	}



	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Address{" +
				"aid=" + aid +
				", code='" + code + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
