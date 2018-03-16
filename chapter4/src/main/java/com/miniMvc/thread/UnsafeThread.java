package com.miniMvc.thread;

/**
 * Created by yjq14 on 2018/3/15.
 */
public class UnsafeThread implements Sequence{
    private int number = 0;
    @Override
    public int getNumber() {
        number ++;
        return number;
    }

    public static void main(String[] args) {
        Sequence sequence = new UnsafeThread();
        ClientThread client1 = new ClientThread(sequence);
        ClientThread client2 = new ClientThread(sequence);
        ClientThread client3 = new ClientThread(sequence);
        client1.start();
        client2.start();
        client3.start();
    }
}
