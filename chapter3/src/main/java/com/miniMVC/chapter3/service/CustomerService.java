package com.miniMVC.chapter3.service;

import com.miniMVC.chapter3.bean.Customer;
import com.miniMVC.framework.annotation.Service;
import com.miniMVC.framework.helper.DatabaseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by yjq14 on 2018/2/26.
 */
@Service
public class CustomerService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    /**
     * 获取客户列表
     * @return
     */
    public List<Customer> getCustomerList() {
        String sql = "select * from customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
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
        return DatabaseHelper.inertEntity(Customer.class, fieldMap);
    }
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
