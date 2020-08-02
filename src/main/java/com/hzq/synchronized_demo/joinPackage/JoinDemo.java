package com.hzq.synchronized_demo.joinPackage;

import java.util.concurrent.TimeUnit;

/**
 * created by hezq on 2020/8/1
 * join 关键字的用法
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        });
        Thread thread1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        });

        thread.start();
        thread1.start();
        System.out.println("等待子线程的结束");
//        thread.join();
//        thread1.join();
        System.out.println("子线程结束");
    }
}
