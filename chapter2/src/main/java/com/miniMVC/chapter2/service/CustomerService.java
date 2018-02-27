package com.miniMVC.chapter2.service;

import com.miniMVC.chapter2.helper.DatabaseHelper;
import com.miniMVC.chapter2.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Created by yjq14 on 2018/2/26.
 */
public class CustomerService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    /**
     * 获取客户列表
     * @return
     */
    public List<Customer> getCustomerList() {
//        Connection conn = null;
//        try {
//            List<Customer> customerList = new ArrayList<>();
//            String sql = "select * from customer";
//            conn = DatabaseHelper.getConnection();
//            PreparedStatement statement = conn.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery();
//            while (rs.next()) {
//                Customer customer = new Customer();
//                customer.setId(rs.getLong("id"));
//                customer.setName(rs.getString("name"));
//                customer.setContact(rs.getString("contact"));
//                customer.setTelephone(rs.getString("telephone"));
//                customer.setEmail(rs.getString("email"));
//                customer.setRemark(rs.getString("remark"));
//                customerList.add(customer);
//            }
//            return customerList;
//        } catch (SQLException e) {
//            LOGGER.error("execute sql failure", e);
//        } finally {
//            DatabaseHelper.closeConnection(conn);
//        }
        String sql = "select * from customer";
        try {
            return DatabaseHelper.queryEntityList(Customer.class, sql);
        } finally {
            DatabaseHelper.closeConnection();
        }
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
