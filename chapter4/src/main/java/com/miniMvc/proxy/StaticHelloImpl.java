package com.miniMvc.proxy;

/**
 * Created by yjq14 on 2018/3/11.
 */
public class StaticHelloImpl implements StaticHello{
    @Override
    public void say(String name) {
        System.out.println("hello !" + name);
    }
}
