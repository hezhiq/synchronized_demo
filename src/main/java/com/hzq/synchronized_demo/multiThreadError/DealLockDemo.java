package com.hzq.synchronized_demo.multiThreadError;

/**
 * created by hezq on 2020/8/6
 * 死锁例子
 */
public class DealLockDemo implements Runnable{

    int flag = 1;
    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        DealLockDemo d1 = new DealLockDemo();
        DealLockDemo d2 = new DealLockDemo();
        d1.flag=1;
        d2.flag=0;
        new Thread(d1).start();
        new Thread(d2).start();
    }

    @Override
    public void run() {
        System.out.println("flag="+flag);
        if(flag == 1){
            synchronized(o1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("1");
                }
            }
        }
        if(flag == 0){
            synchronized(o2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("0");
                }
            }
        }
    }
}
