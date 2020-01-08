package com.hzq.synchronized_demo.stopthreads.volatileDemo;

/**
 * created by hezq on 2020/1/7
 * 演示用volatile的局限：part1 看似可行
 */
public class WrongWayVolatile implements Runnable{
    private volatile boolean canceled = false;

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 100000){
                if(num % 100 == 0 && !canceled){
                    System.out.println(num+"是100的倍数");
                }
                num++;

                    Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatile r = new WrongWayVolatile();
        Thread thread = new Thread(r);
        thread.start();
        Thread.sleep(5000);
        r.canceled = true;
    }
}
