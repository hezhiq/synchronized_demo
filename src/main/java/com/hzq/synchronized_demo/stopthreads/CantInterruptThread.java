package com.hzq.synchronized_demo.stopthreads;

/**
 * created by hezq on 2019/12/25
 */
public class CantInterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;

            while (num <= 10000 && !Thread.currentThread().isInterrupted()){
                if(num % 100 == 0){
                    System.out.println(num + "是100的倍数");
                }
                num++;

                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();

    }
}

