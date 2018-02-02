package com.oocl.ir4.doc.test;

import com.oocl.common.utils.DBMockUtils;
import com.oocl.common.utils.EntityUtilExtend;
import com.oocl.ir4.doc.entity.Address;
import com.oocl.ir4.doc.entity.Company;
import com.oocl.ir4.doc.entity.Customer;
import com.oocl.ir4.doc.entity.Partner;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class EntityUtilExtendTest {
    Customer customer, customer1;

    @Before
    public void setUp(){
        Address address = new Address(12, "GZ", "software load");
        Company company = new Company(2, "OOCL", "OOCLL Company");
        Partner partner = new Partner(23, "Lisa", "0002222999");
        customer = new Customer(222111547l, "Kelvin", "11222223333", 24, 5000.0, address);
        customer.setCompany(company);
        customer.setPartner(partner);

        Address address1 = new Address(13, "GZ1", "software load1");
        customer1 = new Customer(222111548l, "Kelvi1n", "11222223334", 25, 5000.0, address);
    }

    @Test
    public void test01() throws IOException {
        EntityUtilExtend entityUtilExtend = EntityUtilExtend.buildEntityUtilWithNoSkipField();
        entityUtilExtend.generateJsonFile(DBMockUtils.getFileName(EntityUtilExtend.class, customer.getCid()), customer);
    }

    @Test
    public void test01_1() throws Exception {
        EntityUtilExtend entityUtilExtend = EntityUtilExtend.buildEntityUtilWithNoSkipField();
        Customer c = entityUtilExtend.generateObjFromJsonFile(DBMockUtils.getFileName(EntityUtilExtend.class, customer.getCid()), Customer.class);
        System.out.println(c);
    }

    @Test
    public void test02() throws Exception {
        EntityUtilExtend entityUtilExtend = EntityUtilExtend.buildEntityUtilWithSkipAllRelatedField();
        entityUtilExtend.generateJsonFile(DBMockUtils.getFileName(EntityUtilExtend.class, "all"), customer);
    }

    @Test
    public void test02_1() throws Exception {
        EntityUtilExtend entityUtilExtend = EntityUtilExtend.buildEntityUtilWithSkipAllRelatedField();
        Customer c = entityUtilExtend.generateObjFromJsonFile(DBMockUtils.getFileName(EntityUtilExtend.class, "all"), Customer.class);
        System.out.println(c);
    }

    @Test
    public void test03() throws Exception {
        EntityUtilExtend entityUtilExtend = EntityUtilExtend.buildEntityUtil(true, false, false);
        entityUtilExtend.generateJsonFile(DBMockUtils.getFileName(EntityUtilExtend.class, "03"), customer);
    }

    @Test
    public void test04() throws Exception {
        EntityUtilExtend entityUtilExtend = EntityUtilExtend.buildEntityUtil(true, true, false);
        entityUtilExtend.generateJsonFile(DBMockUtils.getFileName(EntityUtilExtend.class, "04"), customer);
    }

    @Test
    public void test03_1() throws Exception {
        EntityUtilExtend entityUtilExtend = EntityUtilExtend.buildEntityUtil(true, false, false);
        Customer c = entityUtilExtend.generateObjFromJsonFile(DBMockUtils.getFileName(EntityUtilExtend.class, "03"), Customer.class);
        System.out.println(c);
        System.out.println(c.getPartner());
    }
}
