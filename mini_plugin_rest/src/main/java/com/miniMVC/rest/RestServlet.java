package com.miniMVC.rest;

import com.miniMVC.commons.CollectionUtil;
import com.miniMVC.commons.StringUtil;
import com.miniMVC.framework.helper.ClassHelper;
import com.miniMVC.rest.annotation.Rest;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import java.util.Set;

/**
 * Created by yjq14 on 2018/4/6.
 */
@WebServlet(urlPatterns = RestConstant.SERVLET_URL, loadOnStartup = 0)
public class RestServlet extends CXFNonSpringServlet{
    @Override
    protected void loadBus(ServletConfig sc) {
        super.loadBus(sc);
        Bus bus = getBus();
        BusFactory.setDefaultBus(bus);

    }

    private void publishRestService() {
        Set<Class<?>> classSetByAnnotation = ClassHelper.getClassSetByAnnotation(Rest.class);
        if (CollectionUtil.isNotEmpty(classSetByAnnotation)) {
            for (Class<?> aClass :
                    classSetByAnnotation) {
                String address = getAddress(aClass);
                RestHelper.publishService(address, aClass);
            }
        }
    }
    private String getAddress(Class<?> restClass) {
        String address;
        String value = restClass.getAnnotation(Rest.class).value();
        if (StringUtil.isNotEmpty(value)) {
            address = value;
        } else {
            address = restClass.getSimpleName();
        }
        if (!address.startsWith("/")) {
            address = "/" + address;
        }
        address = address.replaceAll("\\/+", "/");
        return address;
    }
}
