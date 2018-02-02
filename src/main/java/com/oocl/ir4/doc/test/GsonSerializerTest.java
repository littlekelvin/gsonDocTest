package com.oocl.ir4.doc.test;

import com.oocl.common.utils.DBMockUtils;
import com.oocl.common.utils.GsonSerializer;
import com.oocl.common.utils.GsonSerializerBuilder;
import com.oocl.ir4.doc.entity.Address;
import com.oocl.ir4.doc.entity.Company;
import com.oocl.ir4.doc.entity.Customer;
import com.oocl.ir4.doc.entity.Partner;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class GsonSerializerTest {
    Customer customer, customer1;

    @Before
    public void setUp(){
        Address address = new Address(12, "GZ", "software load");
        Company company = new Company(2, "OOCL", "OOCLL Company");
        Partner partner = new Partner(23, "Lisa", "0002222999");
        customer = new Customer(222111547l, "Kelvin", "11222223333", 24, 5000.0, address);
        customer.setCompany(company);
        customer.setPartner(partner);
    }

    @Test
    public void test01() throws IOException {
        GsonSerializer gsonSerializer = GsonSerializerBuilder.buildEntityUtil(true, false, false);
        gsonSerializer.generateJsonFile(DBMockUtils.getFileName(GsonSerializer.class, "011"), customer);
    }
}
