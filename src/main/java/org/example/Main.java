package org.example;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Entering Into Main Thread");
//        ThreadOne threadOne = new ThreadOne("User Thread");
//        threadOne.setDaemon(true);
////        threadOne.start();
//        Thread threadTwo = new Thread(()->{
//            for (int i =2000; i <3000 ; i++) {
//                System.out.println(Thread.currentThread()+" "+i);
//            }
//        },"Thread 2");
//        threadTwo.start();

//        for (int i = 1000; i <2000 ; i++) {
//            System.out.println("Parent Thread -> "+i);
//        }
        // usually there are three type of thread main thread,user thread,demon thread
        // when main thread complete it's execution and if user thread is still in running then i will continue to run but if all the thread have completed there process and demon is not then it will get auto terminated
        // when it is a demon thread it depends upon the JVM mercy that when thread execution will end
//        System.out.println("Existing  Main Thread");
       // calling the stack class to watch the behaviour of Synchronization
//        Stack stack = new Stack(5);
//
//        new Thread(()->{
//           int counter =0;
//           while (++counter<10)
//               System.out.println("pushed : -> "+stack.push(100));
//        },"pusher").start();
//
//        new Thread(()->{
//            int counter =0;
//            while (++counter<10)
//                System.out.println("popped : -> "+stack.pop());
//        },"popper").start();
        // the problem is that two different-different thread trying to access the same resource and that's why we ran into problem
        // what we can do that we have to make the process of pop and push synchronized so that at a time only one thread should access the resource




        // to under stand the Multithreading nature at the pulisher and the subscriber we will implement the BolkingQueue and see how it behave at that time



        // lets produce the dead lock senario dead lock senario is a senario in which program execution goes into infinite and it don't even terminate
        // creating two different-different lock object
        String lock1="kaushik";
        String lock2="patel";
        Thread thread1 = new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2){
                    System.out.println("lock aquired");
                }
            }
        },"thread1");

        Thread thread2 = new Thread(()->{
            synchronized (lock2){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1){
                    System.out.println("lock aquired");
                }
            }
        },"thread2");

        thread1.start(); thread2.start();
        System.out.println("Exiting  Main Thread");
    }

    // when we use lock
}