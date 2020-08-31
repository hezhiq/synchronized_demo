package com.hzq.synchronized_demo.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by hezq on 2020/8/31
 * 不适用于volatile的场景 a++问题
 */
public class NoVolatile implements Runnable{
    int a;
    AtomicInteger reala = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        NoVolatile noVolatile = new NoVolatile();
        Thread thread1 = new Thread(noVolatile);
        Thread thread2 = new Thread(noVolatile);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(noVolatile.a);
        System.out.println(noVolatile.reala.get());
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            a++;
            reala.incrementAndGet();
        }
    }
}
