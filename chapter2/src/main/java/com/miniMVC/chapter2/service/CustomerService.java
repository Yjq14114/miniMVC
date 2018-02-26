package com.miniMVC.chapter2.service;

import com.miniMVC.chapter2.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * Created by yjq14 on 2018/2/26.
 */
public class CustomerService {
    /**
     * 获取客户列表
     * @param keyword
     * @return
     */
    public List<Customer> getCustomerList(String keyword) {
        // TODO
        return null;
    }

    /**
     * 获取用户
     * @param id
     * @return
     */
    public Customer getCustomer(long id) {
        // TODO
        return null;
    }
    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        // TODO
        return false;
    }
    public boolean updateCustomer(Map<String, Object> fieldMap) {
        // TODO
        return false;
    }
    public boolean deleteCustomer(long id) {
        // TODO
        return false;
    }
}
