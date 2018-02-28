package com.miniMVC.chapter2.test;

import com.miniMVC.chapter2.model.Customer;
import com.miniMVC.chapter2.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yjq14 on 2018/2/27.
 */
public class CustomerServiceTest {
    private final CustomerService customerService;

    public CustomerServiceTest() {
        this.customerService = new CustomerService();
    }
    @Before
    public void init() {
        // TODO 初始化数据库
    }
    @Test
    public void getCustomerListTest() {
        List<Customer> customerList = customerService.getCustomerList();
        Assert.assertEquals(2, customerList.size());
    }
    @Test
    public void createCustomerTest() throws Exception{
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("name", "customer100");
        fieldMap.put("contact", "john");
        fieldMap.put("telephone", "13434343232");
        boolean customer = customerService.createCustomer(fieldMap);
        Assert.assertTrue(customer);
    }
    @Test
    public void updateCustomerTest() {
        long id = 1;
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("contact", "Eric");
        customerService.updateCustomer(1, fieldMap);
    }
}
