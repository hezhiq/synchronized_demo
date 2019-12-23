package com.hzq.synchronized_demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by hezq on 2019/12/10
 */
public class SynchronizedToLock {

    Lock lock = new ReentrantLock();

    public synchronized void method(){
        System.out.println("我是 synchronized 方法");
    }

    public void method2(){
        lock.lock();
        try {
            System.out.println("我是 lock 方法");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedToLock synchronizedToLock = new SynchronizedToLock();
        synchronizedToLock.method();
        synchronizedToLock.method2();
    }
}
