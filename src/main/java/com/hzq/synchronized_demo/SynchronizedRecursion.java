package com.hzq.synchronized_demo;

/**
 * created by hezq on 2019/12/10
 */
public class SynchronizedRecursion {

    int a = 0;

    public static void main(String[] args) {
        SynchronizedRecursion synchronizedRecursion = new SynchronizedRecursion();
        synchronizedRecursion.method();
    }

    private synchronized void method() {
        System.out.println("这是menthod a = " + a);
        if (a == 0) {
            a++;
            method();
        }
    }

}
