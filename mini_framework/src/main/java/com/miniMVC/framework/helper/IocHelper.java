package com.miniMVC.framework.helper;

import com.miniMVC.commons.CollectionUtil;
import com.miniMVC.framework.ReflectionUtil;
import com.miniMVC.framework.annotation.Inject;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by yjq14 on 2018/3/3.
 */
public final class IocHelper {
    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> beanEntry: beanMap.entrySet()){
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(beanFields)) {
                    for (Field field: beanFields) {
                        if (field.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFiledClass = field.getType();
                            Object beanFieldInstance = beanMap.get(beanFiledClass);
                            if (beanFieldInstance != null) {
                                ReflectionUtil.setField(beanInstance, field, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
