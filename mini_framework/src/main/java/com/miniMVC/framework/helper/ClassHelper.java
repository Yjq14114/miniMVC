package com.miniMVC.framework.helper;

import com.miniMVC.framework.ClassUtil;
import com.miniMVC.framework.ConfigHelper;
import com.miniMVC.framework.annotation.Action;
import com.miniMVC.framework.annotation.Controller;
import com.miniMVC.framework.annotation.Inject;
import com.miniMVC.framework.annotation.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yjq14 on 2018/3/2.
 */
public final class ClassHelper {

    private static Set<Class<?>> classSet;

    static {
        String basePackage = ConfigHelper.getBasePackage();
        classSet = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClassSet() {
        return classSet;
    }

    /**
     * 获取service 注解
     * @return
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls :
                classSet) {
            cls.isAnnotationPresent(Service.class);
            classSet.add(cls);
        }
        return classSet;
    }

    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls :
                classSet) {
            cls.isAnnotationPresent(Controller.class);
            classSet.add(cls);
        }
        return classSet;
    }

    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> classSet = new HashSet<>();
        classSet.addAll(getControllerClassSet());
        classSet.addAll(getServiceClassSet());
        return classSet;
    }

//    public static Set<Class<?>> getInjectClassSet() {
//        Set<Class<?>> classSet = new HashSet<>();
//        for (Class<?> cls :
//                classSet) {
//            cls.isAnnotationPresent(Inject.class);
//            classSet.add(cls);
//        }
//        return classSet;
//    }
//
//    public static Set<Class<?>> getActionClassSet() {
//        Set<Class<?>> classSet = new HashSet<>();
//        for (Class<?> cls :
//                classSet) {
//            cls.isAnnotationPresent(Action.class);
//            classSet.add(cls);
//        }
//        return classSet;
//    }
}
