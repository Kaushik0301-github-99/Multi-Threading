package org.example;

import java.util.Queue;

public class BlockingQueue {

    private Queue<Integer> q;
    private int capacity;

      // we can add the data into the queue
    // basically we know that when two different-different thread tries to access the data it will throw index out of bond or another problem so we have to make is snchnonized
    public boolean add(int value){
        // applying log on the object queue
        synchronized (q) {
            // when the queue is full
            //            if(q.size()==0)  there is a problem with this condition it can cause the thread waiting
            while(q.size()==capacity){
                // do something
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            // other wise
            q.add(value);
            q.notifyAll();
            return true;
        }
    }

    // we can pop out the data from queue
    public int remove(){
        synchronized (q) {
            // when the queue is fully empty
//            if(q.size()==0)  there is a problem with this condition
            while(q.size()==0){
                // do something
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            // otherwise
            int value = q.poll();
            q.notifyAll();
            return value;
        }
    }

    //as it notifies all the waiting thread and let suppose there are two thread in waiting and let suppose after notifing next thread goes into the process and another is still and waiting and again all the resource got filled and
  // and then same problem arises again

}
