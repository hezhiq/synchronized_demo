package com.hzq.synchronized_demo.joinPackage;

import java.util.concurrent.TimeUnit;

/**
 * created by hezq on 2020/8/2
 * 通过理解join的原理，分析jion的代替写法
 */
public class JoinPrinciple {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕");
        });
        thread.start();
        System.out.println("等待子线程的结束");
//        thread.join();
        //join的等价写法
        synchronized(thread){
            thread.wait();//这个wait没有被notify，它是这么被唤醒的呢，因为thread的run方法底层会默认唤醒wait
        }
        System.out.println("子线程结束");
    }

}
