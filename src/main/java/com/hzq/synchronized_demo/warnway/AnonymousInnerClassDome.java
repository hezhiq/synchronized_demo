package com.hzq.synchronized_demo.warnway;

/**
 * created by hezq on 2019/12/16
 */
public class AnonymousInnerClassDome {

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }

}
