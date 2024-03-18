package org.example;

public class ThreadOne extends Thread {

    public ThreadOne(String threadName){
        super(threadName);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread()+" -> " + i);
        }
    }
}
