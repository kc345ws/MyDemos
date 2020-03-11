package com.kc345ws.Concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class _006ReentrantLock extends Thread {
   // static ReentrantLock lock = new ReentrantLock();
    //多个对象互斥

    private ReentrantLock lock = new ReentrantLock();
    //同一对象多个线程执行同一个方法互斥

    public void run(){
        lock.lock();
        for(int i = 0 ; i < 5 ;i++){
            System.out.print(i+" ");
        }
        lock.unlock();// 确保释放锁，从而避免发生死锁。
    }
}
