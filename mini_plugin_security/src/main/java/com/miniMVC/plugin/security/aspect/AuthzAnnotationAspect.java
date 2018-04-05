package com.miniMVC.plugin.security.aspect;

import com.miniMVC.framework.annotation.Aspect;
import com.miniMVC.framework.annotation.Controller;
import com.miniMVC.framework.proxy.AspectProxy;
import com.miniMVC.plugin.security.annotation.User;
import com.miniMVC.plugin.security.exception.AuthzException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by yjq14 on 2018/4/5.
 */
@Aspect(Controller.class)
public class AuthzAnnotationAspect extends AspectProxy{

    private static final Class[] ANNOTATION_CLASS_ARRAY = {User.class};
    @SuppressWarnings("unchecked")
    private Annotation getAnnotation(Class<?> cls, Method method) {
        for (Class<? extends Annotation> annotationClass: ANNOTATION_CLASS_ARRAY) {
            if (method.isAnnotationPresent(annotationClass)) {
                return method.getAnnotation(annotationClass);
            }
            if (cls.isAnnotationPresent(annotationClass)) {
                return cls.getAnnotation(annotationClass);
            }
        }
        return null;
    }
    private void handleUser() {
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principals = subject.getPrincipals();
        if (principals == null || principals.isEmpty()) {
            throw new AuthzException("当前用户未登录");
        }
    }

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        Annotation annotation = getAnnotation(cls, method);
        if (annotation != null) {
            Class<? extends Annotation> aClass = annotation.annotationType();
            if (aClass.equals(User.class)) {
                handleUser();
            }
        }
        super.before(cls, method, params);
    }
}
