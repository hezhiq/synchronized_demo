package com.hzq.synchronized_demo.warnway;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * created by hezq on 2019/12/16
 */
public class TreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Task(){
            });
        }
    }

}

class Task implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
