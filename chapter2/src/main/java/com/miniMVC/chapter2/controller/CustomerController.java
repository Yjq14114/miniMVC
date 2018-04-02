package com.miniMVC.chapter2.controller;

import com.miniMVC.chapter2.service.CustomerService;
import com.miniMVC.framework.annotation.Action;
import com.miniMVC.framework.annotation.Controller;
import com.miniMVC.framework.annotation.Inject;
import com.miniMVC.framework.bean.Param;

import java.util.Map;

/**
 * Created by yjq14 on 2018/4/2.
 */
@Controller
public class CustomerController {
    @Inject
    private CustomerService service;
    @Action("get:/create")
    public String create(Param param)  {
        Map<String, Object> fieldMap = param.getFieldMap();
        boolean customer = service.createCustomer(fieldMap);
        return "success";
    }
}
