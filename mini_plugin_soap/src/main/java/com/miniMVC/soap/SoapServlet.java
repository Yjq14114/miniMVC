package com.miniMVC.soap;

import com.miniMVC.commons.CollectionUtil;
import com.miniMVC.commons.StringUtil;
import com.miniMVC.framework.helper.BeanHelper;
import com.miniMVC.framework.helper.ClassHelper;
import com.miniMVC.soap.annotation.Soap;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import java.util.Set;

/**
 * Created by yjq14 on 2018/4/6.
 */
@WebServlet(urlPatterns = SoapConstant.SERVLET_URL, loadOnStartup = 0)
public class SoapServlet extends CXFNonSpringServlet{
    @Override
    protected void loadBus(ServletConfig sc) {
        super.loadBus(sc);
        Bus bus = getBus();
        BusFactory.setDefaultBus(bus);

    }
    private void publishSoapService() {
        Set<Class<?>> classSetByAnnotation = ClassHelper.getClassSetByAnnotation(Soap.class);
        if (CollectionUtil.isNotEmpty(classSetByAnnotation)) {
            for (Class<?> aClass:
                    classSetByAnnotation
                 ) {
                String address = getAddress(aClass);
                Class<?> soapInterfaceClass = getSoapInterfaceClass(aClass);
                Object bean = BeanHelper.getBean(soapInterfaceClass);
                SoapHelper.publishService(address, soapInterfaceClass, bean);
            }
        }
    }
    private Class<?> getSoapInterfaceClass(Class<?> soapClass) {
        return soapClass.getInterfaces()[0];
    }

    private String getAddress(Class<?> soapClass) {
        String address;
        String value = soapClass.getAnnotation(Soap.class).value();
        if (StringUtil.isNotEmpty(value)) {
            address = value;
        } else {
            address = getSoapInterfaceClass(soapClass).getSimpleName();
        }
        if (!address.startsWith("/")) {
            address = "/" + address;
        }
        address = address.replaceAll("\\/+", "/");
        return address;
    }
}
