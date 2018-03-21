package com.miniMVC.chapter3.controller;

import com.miniMVC.chapter3.service.TestService;
import com.miniMVC.framework.ClassUtil;
import com.miniMVC.framework.annotation.Action;
import com.miniMVC.framework.annotation.Controller;
import com.miniMVC.framework.annotation.Inject;

import java.util.Set;

/**
 * Created by yjq14 on 2018/3/18.
 */
@Controller
public class TestController {
    @Inject
    private TestService testService;
    @Action("get:/test")
    public String test() {
       return testService.test();
    }

//    public static void main(String[] args) {
//        try {
//            Class<?> aClass = Class.forName("com.miniMVC.chapter3.controller.TestController");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
}
