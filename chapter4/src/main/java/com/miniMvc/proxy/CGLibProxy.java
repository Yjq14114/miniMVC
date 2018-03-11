package com.miniMvc.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by yjq14 on 2018/3/11.
 */
public class CGLibProxy implements MethodInterceptor{

    private static CGLibProxy instance = new CGLibProxy();

    private CGLibProxy() {

    }
    public static CGLibProxy getInstance() {
        return instance;
    }
    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls, this);
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }
    private void before() {
        System.out.println("before");
    }
    private void after() {
        System.out.println("after");
    }

    public static void main(String[] args) {
        StaticHello hello = CGLibProxy.getInstance().getProxy(StaticHelloImpl.class);
        hello.say("jack");
    }
}
