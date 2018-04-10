package com.miniMVC.chapter3.controller;

import com.google.gson.Gson;
import com.miniMVC.chapter3.bean.Customer;
import com.miniMVC.chapter3.service.CustomerService;
import com.miniMVC.framework.annotation.Action;
import com.miniMVC.framework.annotation.Controller;
import com.miniMVC.framework.annotation.Inject;
import com.miniMVC.framework.bean.Data;
import com.miniMVC.framework.bean.FileParam;
import com.miniMVC.framework.bean.Param;
import com.miniMVC.framework.helper.ServletHelper;
import com.miniMVC.framework.helper.UploadHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by yjq14 on 2018/4/2.
 */
@Controller
public class CustomerController {
    @Inject
    private CustomerService customerService;

    @Action("get:/customerList")
    public Data customerList() {
        HttpServletRequest request = ServletHelper.getRequest();
        List<Customer> customerList = customerService.getCustomerList();
        Data data = new Data();
        data.setModel(new Gson().toJson(customerList));
        return data;
    }

    @Action("post:/createCustomer")
    public Data createCustomer(Param param) {
        Data data = new Data();
        FileParam file = param.getFile("file");
        UploadHelper.uploadFile("/home/files/", file);
        Map<String, Object> fieldMap = param.getFieldMap();
        boolean customer = customerService.createCustomer(fieldMap);
        if (customer) {
           data.setModel("success");
        } else {
            data.setModel("failure");
        }
        return data;
    }

}
