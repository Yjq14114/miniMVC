package com.miniMVC.framework.helper;

import com.miniMVC.framework.ClassUtil;
import com.miniMVC.framework.ConfigHelper;
import com.miniMVC.framework.annotation.Controller;
import com.miniMVC.framework.annotation.Service;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yjq14 on 2018/3/2.
 */
public final class ClassHelper {

    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取service 注解
     * @return
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls :
                CLASS_SET) {
            cls.isAnnotationPresent(Service.class);
            classSet.add(cls);
        }
        return classSet;
    }

    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls :
                CLASS_SET) {
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

    /**
     * 获取应用包名下某父类（或接口）的所有子类（或实现）
     * @param superClass
     * @return
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls : CLASS_SET) {
            if (superClass.isAssignableFrom(cls) && !superClass.equals(cls)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下带有某注解的所有类
     * @param annotationClass
     * @return
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass) {
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(annotationClass)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }
//    public static Set<Class<?>> getInjectClassSet() {
//        Set<Class<?>> CLASS_SET = new HashSet<>();
//        for (Class<?> cls :
//                CLASS_SET) {
//            cls.isAnnotationPresent(Inject.class);
//            CLASS_SET.add(cls);
//        }
//        return CLASS_SET;
//    }
//
//    public static Set<Class<?>> getActionClassSet() {
//        Set<Class<?>> CLASS_SET = new HashSet<>();
//        for (Class<?> cls :
//                CLASS_SET) {
//            cls.isAnnotationPresent(Action.class);
//            CLASS_SET.add(cls);
//        }
//        return CLASS_SET;
//    }
}
