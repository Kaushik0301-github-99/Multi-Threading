package org.example;

import java.util.ArrayList;


public class Stack {
    //stack is  data structure which uses the Last in first out algorithm
    private int[] array;
    private int stackTop;


    public Stack(int stackCapacity) {
        array = new int[stackCapacity];
        stackTop = -1;
    }

    public boolean isFull() {
        return stackTop >= array.length- 1;
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public synchronized boolean push(int element) {
        if (isFull()) return false;
        ++stackTop;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {

        }
        array[stackTop]=element;
        return true;
    }
// as we know that every synchronized process require a specific type lock that that only that specific thread can access the resource
    public synchronized int pop() {
//        synchronized (){    that is when we apply the synchronization to the specific code then we have to pass the lock and for the method synchronization we already get the lock the (this) as
        // this referece to the same class object but when the method is static and we no that we can only make static method when class is static class so in that case we can not pass the
        // (this ) keyword instead of that we have to pass the (Class.name with the class extenstion)
            if (isEmpty())
                return Integer.MIN_VALUE;
            int value = array[stackTop];
            array[stackTop] =Integer.valueOf(Integer.MAX_VALUE);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            stackTop--;
            return value;
//        }
        }

}
