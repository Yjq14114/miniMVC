package com.miniMvc.proxy;

/**
 * 静态代理
 * 代理模式
 * Created by yjq14 on 2018/3/11.
 */
public class StaticProxy implements StaticHello{
    private StaticHello hello;

    public StaticProxy() {
        this.hello = new StaticHelloImpl();
    }

    @Override
    public void say(String name) {
        before();
        hello.say(name);
        after();
    }
    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }

    public static void main(String[] args) {
        StaticHello helloProxy = new StaticProxy();
        helloProxy.say("mid");
    }
}
