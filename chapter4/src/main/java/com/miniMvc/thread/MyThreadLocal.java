package com.miniMvc.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义实现一个threadLocal
 * Created by yjq14 on 2018/3/16.
 */
public class MyThreadLocal <T>{
    private Map<Thread, T> container = Collections.synchronizedMap(new HashMap<Thread, T>());

    public void set(T value) {
       container.put(Thread.currentThread(), value);
    }

    public T get() {
        Thread thread = Thread.currentThread();
        T value = container.get(thread);
        if (value == null && !container.containsKey(thread)) {
            value = initValue();
            container.put(thread, value);
        }
        return value;
    }

    public void remove() {
        container.remove(Thread.currentThread());
    }
    protected T initValue() {
        return null;
    }
}
