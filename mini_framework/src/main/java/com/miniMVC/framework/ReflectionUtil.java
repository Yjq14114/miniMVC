package com.miniMVC.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射工具类
 * Created by yjq14 on 2018/3/2.
 */
public final class ReflectionUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    public static Object newInstance(Class<?> cls) throws IllegalAccessException, InstantiationException {
        //        try {
//            instance = cls.newInstance();
//        } catch (InstantiationException | IllegalAccessException e) {
//            LOGGER.error("new instance error", e);
//            new RuntimeException(e);
//        }
        return  cls.newInstance();
    }
    public static Object invokeMethod(Object obj, Method method, Class<?>  clazz, Object ... args) {
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

}
