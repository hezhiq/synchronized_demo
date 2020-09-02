package com.hzq.synchronized_demo.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * created by hezq on 2020/9/1
 * 一定会发生死锁
 */
public class MustDeallock implements Runnable{
    int flag;
    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        MustDeallock d1 = new MustDeallock();
        MustDeallock d2 = new MustDeallock();
        d1.flag = 1;
        d2.flag = 0;
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t1.start();
        t2.start();
        Thread.sleep(1000);

        //ThreadMXBean 发现死锁
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        if(deadlockedThreads != null && deadlockedThreads.length > 0){
            for (int i = 0; i < deadlockedThreads.length; i++) {
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadlockedThreads[i]);
                System.out.println("发现死锁啦+"+threadInfo.getThreadName());
            }
        }
    }

    @Override
    public void run() {
        System.out.println("flag=" + flag);
        if(flag == 1){
            synchronized(o1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(o2){
                    System.out.println("thread1");
                }
            }

        }
        if (flag == 0){
            synchronized(o2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(o1){
                    System.out.println("thread2");
                }
            }

        }
    }
}
