package com.miniMVC.plugin.security;

import org.apache.shiro.web.env.EnvironmentLoaderListener;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * Created by yjq14 on 2018/4/4.
 */
public class MiniSecurityPlugin implements ServletContainerInitializer{
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("shiroConfigLocations", "class-path:mini-security.ini");
        servletContext.addListener(EnvironmentLoaderListener.class);
        FilterRegistration.Dynamic securityFilter = servletContext.addFilter("MiniSecurityFilter", MiniSecurityFilter.class);
        securityFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}
