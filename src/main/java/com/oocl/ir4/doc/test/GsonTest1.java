package com.oocl.ir4.doc.test;

import java.io.IOException;

import org.junit.Test;

import com.oocl.common.utils.EntityUtils;
import com.oocl.ir4.doc.entity.Address;
import com.oocl.ir4.doc.entity.Customer;

public class GsonTest1 {
	
	@Test
	public void test01() throws IOException{
		Address address = new Address(12, "GZ", "�����з�خ����ѧ��");
		Customer customer = new Customer(222111547l, "Kelvin", "11222223333", 24, 5000.0, address);
		
		Address address1 = new Address(13, "GZ1", "�����з�خ����ѧ��1");
		Customer customer1 = new Customer(222111548l, "Kelvi1n", "11222223334", 25, 5000.0, address);
		
		Address address2 = new Address(14, "GZ2", "�����з�خ����ѧ��2");
		Customer customer2 = new Customer(222111549l, "Kelvin", "11222223335", 29, 5000.0, address);
		
		Address address3 = new Address(15, "GZ3", "�����з�خ����ѧ��3");
		Customer customer3 = new Customer(222111540l, "Kelvin", "11222223336", 28, 5000.0, address);
		
		EntityUtils.generateJsonFile(Customer.class.getSimpleName()+String.valueOf(customer.getCid()), customer);
	}
}
