package com.miniMvc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yjq14 on 2018/3/11.
 */
public class DynamicProxy implements InvocationHandler{
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(target, args);
        after();
        return invoke;
    }
    private void before() {
        System.out.println("before");
    }
    private void after() {
        System.out.println("after");
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    public static void main(String[] args) {
        StaticHello hello = new StaticHelloImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(hello);
//        StaticHello helloProxy = (StaticHello) Proxy.newProxyInstance(
//                hello.getClass().getClassLoader(),
//                hello.getClass().getInterfaces(),
//                dynamicProxy
//        );
//        helloProxy.say("jack");
        StaticHello proxy = dynamicProxy.getProxy();
        proxy.say("jack");
    }
}
