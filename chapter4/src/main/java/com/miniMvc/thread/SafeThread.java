package com.miniMvc.thread;

/**
 * Created by yjq14 on 2018/3/15.
 */
public class SafeThread implements Sequence{
    private ThreadLocal<Integer> integerThreadLocal = ThreadLocal.withInitial(() -> 0);
    @Override
    public int getNumber() {
        integerThreadLocal.set(integerThreadLocal.get() + 1);
        return integerThreadLocal.get();
    }

    public static void main(String[] args) {
        Sequence sequence = new SafeThread();
        ClientThread client1 = new ClientThread(sequence);
        ClientThread client2 = new ClientThread(sequence);
        ClientThread client3 = new ClientThread(sequence);
        client1.start();
        client2.start();
        client3.start();
    }
}
