package com.miniMVC.framework;

import com.google.common.collect.Maps;
import com.miniMVC.framework.bean.DynamicBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 反射工具类
 * Created by yjq14 on 2018/3/2.
 */
public final class ReflectionUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    public static Object newInstance(Class<?> cls)  {
        Object instance = null;
        try {
            instance = cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error("new instance error", e);
            new RuntimeException(e);
        }
        return  instance;
    }
    public static Object newInstance(String className) {
        Class<?> aClass = ClassUtil.loadClass(className);
        return newInstance(aClass);
    }
    public static Object invokeMethod(Object obj, Method method) {
        return invokeMethod(obj, method, null);
    }
    public static Object invokeMethod(Object obj, Method method, Object ... args) {
        Object result = null;
        try {
            method.setAccessible(true);
            result = method.invoke(obj, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            LOGGER.error("invokeMethod error", e);
            new RuntimeException(e);
        }
        return result;
    }

    public static void setField(Object obj, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            LOGGER.error("setField error", e);
            new RuntimeException(e);
        }
    }
    private static DynamicBean instanceDynamicBean(Object dest, Map<String, Object> addProperties) {
        // get property map
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(dest);
        Map<String, Class> propertyMap = Maps.newHashMap();
        for (PropertyDescriptor d : descriptors) {
            if (!"class".equalsIgnoreCase(d.getName())) {
                propertyMap.put(d.getName(), d.getPropertyType());
            }
        }
        // add extra properties
        addProperties.forEach((k, v) -> propertyMap.put(k, v.getClass()));
        // new dynamic bean
        DynamicBean dynamicBean = new DynamicBean(dest.getClass(), propertyMap);
        // add old value
        propertyMap.forEach((k, v) -> {
            try {
                // filter extra properties
                if (!addProperties.containsKey(k)) {
                    dynamicBean.setValue(k, propertyUtilsBean.getNestedProperty(dest, k));
                }
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        });
        // add extra value
        addProperties.forEach((k, v) -> {
            try {
                dynamicBean.setValue(k, v);
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        });
        return dynamicBean;
    }

    public static <K,V>Map<K,V> getBeanMap(Object dest, Map<String, Object> addProperties) {
        return instanceDynamicBean(dest, addProperties).getMap();

    }
    public static Object getTarget(Object dest, Map<String, Object> addProperties) {
        return instanceDynamicBean(dest, addProperties).getTarget();
    }

}
