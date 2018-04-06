package com.miniMVC.rest;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.miniMVC.framework.helper.BeanHelper;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.jsonp.JsonpInInterceptor;
import org.apache.cxf.jaxrs.provider.jsonp.JsonpPostStreamInterceptor;
import org.apache.cxf.jaxrs.provider.jsonp.JsonpPreStreamInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharingFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjq14 on 2018/4/6.
 */

public class RestHelper {
    private static final List<Object> providerList = new ArrayList<>();
    private static final List<Interceptor<? extends Message>> inInterceptorList = new ArrayList<>();
    private static final List<Interceptor<? extends Message>> outInterceptorList = new ArrayList<>();

    static {
        JacksonJsonProvider jsonProvider = new JacksonJsonProvider();
        providerList.add(jsonProvider);

        if (RestConfig.isLog()) {
            LoggingInInterceptor loggingInInterceptor = new LoggingInInterceptor();
            inInterceptorList.add(loggingInInterceptor);
            LoggingOutInterceptor loggingOutInterceptor = new LoggingOutInterceptor();
            outInterceptorList.add(loggingOutInterceptor);
        }
        if (RestConfig.isJsonP()) {
            JsonpInInterceptor jsonpInInterceptor = new JsonpInInterceptor();
            jsonpInInterceptor.setCallbackParam(RestConfig.getJsonPFunction());
            inInterceptorList.add(jsonpInInterceptor);
            JsonpPreStreamInterceptor jsonpPreStreamInterceptor = new JsonpPreStreamInterceptor();
            outInterceptorList.add(jsonpPreStreamInterceptor);
            JsonpPostStreamInterceptor jsonpPostStreamInterceptor = new JsonpPostStreamInterceptor();
            outInterceptorList.add(jsonpPostStreamInterceptor);
        }
        if (RestConfig.isCors()) {
            CrossOriginResourceSharingFilter crossOriginResourceSharingFilter = new CrossOriginResourceSharingFilter();
            crossOriginResourceSharingFilter.setAllowOrigins(RestConfig.getCorsOriginList());
            providerList.add(crossOriginResourceSharingFilter);
        }
    }

    public static void publishService(String wadl, Class<?> resourceClass) {
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setAddress(wadl);
        factoryBean.setResourceClasses(resourceClass);
        factoryBean.setResourceProvider(resourceClass, new SingletonResourceProvider(BeanHelper.getBean(resourceClass)));
        factoryBean.setInInterceptors(inInterceptorList);
        factoryBean.setOutInterceptors(outInterceptorList);
        factoryBean.create();
    }
    public static <T> T createClient(String wadl, Class<? extends T> resourceClass) {
        return JAXRSClientFactory.create(wadl, resourceClass, providerList);
    }
}
