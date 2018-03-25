package com.miniMVC.chapter3.aop;

import com.miniMVC.framework.annotation.Aspect;
import com.miniMVC.framework.annotation.Controller;
import com.miniMVC.framework.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by yjq14 on 2018/3/14.
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {
    private static final Logger log = LoggerFactory.getLogger(ControllerAspect.class);
    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        log.info("---------begin--------");
        log.info(String.format("class: %s", cls.getName()));
        log.info(String.format("method: %s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        log.info(String.format("time: %dms", System.currentTimeMillis() - begin));
        log.info("----------end----------");
    }

}
