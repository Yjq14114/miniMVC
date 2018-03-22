package com.miniMVC.framework.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yjq14 on 2018/3/22.
 */
public class InvokeObj {
    public void show() {
        System.out.println("无参show()方法");
    }
    public void show (String name) {
        System.out.println("show()方法:" + name);
    }
    public String[] arrayShow (String[] arr) {
        return arr;
    }
    public String StringShow(String str) {
        return str;
    }
    public int intShow(int num) {
        return num;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<InvokeObj> clazz = InvokeObj.class;
//        Method[] methods = clazz.getMethods();
//        for (Method method:methods) {
//            System.out.println(method);
//        }
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method :
                declaredMethods) {
//            method.invoke(new InvokeObj(), null);
            if (method.getName().equals("intShow")) {
                System.out.println(method.getName());
                System.out.println(method.getParameterTypes());
                Class<?>[] parameterTypes = method.getParameterTypes();
                Method declaredMethod = clazz.getDeclaredMethod(method.getName(), method.getParameterTypes());
                Object invoke = declaredMethod.invoke(new InvokeObj(), 9);
                System.out.println(invoke);
            }
        }
        System.out.println("InvokeObj类的无参show()方法：");
        Method show = clazz.getMethod("show", null);
        show.setAccessible(true);
        InvokeObj invokeObj = new InvokeObj();
        Object obj = show.invoke(invokeObj, null);
        System.out.println("输出无参show()方法的返回值："+obj);
        System.out.println("InvokeObj类的show()方法： ");
        System.out.println("输出有参show()方法： ");
        Method show1 = clazz.getMethod("show", String.class);
        Object jack = show1.invoke(new InvokeObj(), "jack");
        System.out.println("输出有参show()方法的返回值："+jack);
        System.out.println("InvokeObj类的arrayShow()方法： ");
                                                   // 方法名    返回值类型
        Method arrayShow = clazz.getMethod("arrayShow", String[].class);
        String[] strs = new String[] {"mic", "jerry"};
                                                    // 对象实例         参数
        String[] invoke = (String[])arrayShow.invoke(new InvokeObj(), new Object[]{strs});
        for (String str :
                invoke) {
            System.out.println(str);
        }


    }
}
