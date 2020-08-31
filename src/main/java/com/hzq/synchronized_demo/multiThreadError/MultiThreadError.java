package com.hzq.synchronized_demo.multiThreadError;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * created by hezq on 2020/8/6
 * i++线程不安全问题
 */
public class MultiThreadError implements Runnable {

    static int index = 0;
    static MultiThreadError instance = new MultiThreadError();
    static AtomicInteger realIndex = new AtomicInteger();
    static AtomicInteger errorCount = new AtomicInteger();
    static CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
    static CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);
    final boolean[] marked = new boolean[200000];

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("表面上i++的结果是="+index);
        System.out.println("真正运行的次数是="+realIndex);
        System.out.println("错误的次数是="+errorCount);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            marked[0]=true;
            try {
                cyclicBarrier2.reset();
                cyclicBarrier1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            index++;
            try {
                cyclicBarrier1.reset();
                cyclicBarrier2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            realIndex.incrementAndGet();
            synchronized (instance){
                if(marked[index] && marked[index-1]){
                    System.out.println("发生错误："+index);
                    errorCount.incrementAndGet();
                }
                marked[index] = true;
            }
        }
    }
}
