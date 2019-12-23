package com.hzq.synchronized_demo.warnway;

/**
 * created by hezq on 2019/12/16
 */
public class Lambda {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }

}
