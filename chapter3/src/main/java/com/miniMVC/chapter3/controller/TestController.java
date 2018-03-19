package com.miniMVC.chapter3.controller;

import com.miniMVC.chapter3.service.TestService;
import com.miniMVC.framework.annotation.Controller;

/**
 * Created by yjq14 on 2018/3/18.
 */
@Controller
public class TestController {
    private TestService testService;

    public String test() {
       return testService.test();
    }
}
