package com.miniMVC.chapter3.controller;

import com.miniMVC.chapter3.service.TestService;
import com.miniMVC.framework.annotation.Action;
import com.miniMVC.framework.annotation.Controller;
import com.miniMVC.framework.annotation.Inject;
import com.miniMVC.framework.bean.Data;
import com.miniMVC.framework.bean.Param;
import com.miniMVC.framework.bean.View;

/**
 * Created by yjq14 on 2018/3/18.
 */
@Controller
public class TestController {
    @Inject
    private TestService testService;

    @Action("get:/test")
    public Data test() {
        Data data = new Data();
        data.setModel(testService.test());
        return data;
    }
    @Action("post:/test2")
    public Data test2(Param param) {
        Data data = new Data();
        data.setModel(param);
        return data;
    }

    @Action("get:/testView")
    public View testView() {
        View view = new View("hello.jsp");
        view.addModel("name", "michael");
        return view;
    }
}
