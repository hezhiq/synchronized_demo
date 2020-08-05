package com.hzq.synchronized_demo.uncaughEnxception;

/**
 * created by hezq on 2020/8/5
 */
public class useOwnerUncaughtExceptionHandle implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHanlder("德玛捕获器"));
        new Thread(new useOwnerUncaughtExceptionHandle(),"myThread-1").start();
        Thread.sleep(300);
        new Thread(new useOwnerUncaughtExceptionHandle(),"myThread-2").start();
        Thread.sleep(300);
        new Thread(new useOwnerUncaughtExceptionHandle(),"myThread-3").start();
        Thread.sleep(300);
        new Thread(new useOwnerUncaughtExceptionHandle(),"myThread-4").start();
    }
    @Override
    public void run() {
        throw new RuntimeException();
    }
}
