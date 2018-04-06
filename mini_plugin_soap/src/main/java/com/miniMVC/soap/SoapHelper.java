package com.miniMVC.soap;

import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjq14 on 2018/4/6.
 */
public class SoapHelper {
    private static final List<Interceptor<? extends Message>> inInterceptorList = new ArrayList<>();
    private static final List<Interceptor<? extends Message>> outInterceptorList = new ArrayList<>();

    static {
        if (SoapConfig.isLog()) {
            LoggingInInterceptor loggingInInterceptor = new LoggingInInterceptor();
            inInterceptorList.add(loggingInInterceptor);
            LoggingOutInterceptor loggingOutInterceptor = new LoggingOutInterceptor();
            outInterceptorList.add(loggingOutInterceptor);
        }
    }

    public static void publishService(String wsdl, Class<?> interfaceClass, Object implementInstance) {
        ServerFactoryBean factoryBean = new ServerFactoryBean();
        factoryBean.setAddress(wsdl);
        factoryBean.setServiceClass(interfaceClass);
        factoryBean.setServiceBean(implementInstance);
        factoryBean.setInInterceptors(inInterceptorList);
        factoryBean.setOutInterceptors(outInterceptorList);
        factoryBean.create();
    }
    public static <T> T createClient(String wsdl, Class<? extends T> interfaceClass) {
        ClientProxyFactoryBean factoryBean = new ClientProxyFactoryBean();
        factoryBean.setAddress(wsdl);
        factoryBean.setServiceClass(interfaceClass);
        factoryBean.setInInterceptors(inInterceptorList);
        factoryBean.setOutInterceptors(outInterceptorList);
        return factoryBean.create(interfaceClass);
    }
}
