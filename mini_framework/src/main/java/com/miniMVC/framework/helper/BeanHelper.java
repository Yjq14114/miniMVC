package com.miniMVC.framework.helper;

import com.miniMVC.framework.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yjq14 on 2018/3/3.
 */
public final class BeanHelper {
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass :
                beanClassSet) {
            Object obj = null;
            try {
                obj = ReflectionUtil.newInstance(beanClass);
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
            BEAN_MAP.put(beanClass, obj);
        }
    }

    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    public static <T> T getBean(Class<T> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not get been by class:" + cls);
        }
        return (T) BEAN_MAP.get(cls);
    }

    public static void setBean(Class<?> cls, Object obj) {
        BEAN_MAP.put(cls, obj);
    }
}
