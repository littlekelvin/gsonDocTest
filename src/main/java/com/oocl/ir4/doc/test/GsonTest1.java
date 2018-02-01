package com.oocl.ir4.doc.test;

import java.io.IOException;

import com.oocl.common.utils.DBMockUtils;
import com.oocl.common.utils.EntityUtils;
import com.oocl.ir4.doc.entity.Address;
import com.oocl.ir4.doc.entity.Company;
import com.oocl.ir4.doc.entity.Customer;
import org.junit.Before;
import org.junit.Test;

public class GsonTest1 {
	Customer customer, customer1, customer2, customer3;

	@Before
	public void setUp(){
		Address address = new Address(12, "GZ", "software load");
		Company company = new Company(2, "OOCL", "OOCLL Company");
		customer = new Customer(222111547l, "Kelvin", "11222223333", 24, 5000.0, address);
		customer.setCompany(company);

		Address address1 = new Address(13, "GZ1", "software load1");
		customer1 = new Customer(222111548l, "Kelvi1n", "11222223334", 25, 5000.0, address);

		Address address2 = new Address(14, "GZ2", "software load2");
		customer2 = new Customer(222111549l, "Kelvin", "11222223335", 29, 5000.0, address);

		Address address3 = new Address(15, "GZ3", "software load3");
		customer3 = new Customer(222111540l, "Kelvin", "11222223336", 28, 5000.0, address);
	}

	@Test
	public void test01() throws IOException{

		EntityUtils.generateJsonFile(DBMockUtils.getFileName(Customer.class, String.valueOf(customer.getCid())), customer);
	}

	@Test
	public void test02() throws IOException{

		EntityUtils.generateJsonFile(Customer.class.getSimpleName()+String.valueOf(customer.getCid()), customer);
	}

	@Test
	public void test03() throws Exception {
		Customer c = EntityUtils.generateObjFromJsonFile(DBMockUtils.getFileName(Customer.class, "222111547"), Customer.class);
		System.out.println(c);
	}
}
