package com.miniMvc.thread;

/**
 * Created by yjq14 on 2018/3/15.
 */
public class ClientThread extends Thread{

    private Sequence sequence;

    public ClientThread(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        for (int i = 0;i<3;i++) {
            System.out.println(Thread.currentThread().getName()+ "=" + sequence.getNumber());
        }
    }
}
