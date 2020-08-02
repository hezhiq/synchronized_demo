package com.hzq.synchronized_demo.joinPackage;

/**
 * created by hezq on 2020/8/2
 * 查看join的中断效果
 */
public class JoinInterruptor {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread.interrupt();
                    Thread.sleep(5000);
                    System.out.println("thread1 finshed!");
                } catch (InterruptedException e) {
                    System.out.println("子线程被中断！");
                }
            }
        });
        thread1.start();
        System.out.println("等待子线程执行完毕！");
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"被中断");
            thread1.interrupt();
        }
        System.out.println("子线程执行完毕");
    }
}
