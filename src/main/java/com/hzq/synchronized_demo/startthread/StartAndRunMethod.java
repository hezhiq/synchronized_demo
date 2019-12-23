package com.hzq.synchronized_demo.startthread;

/**
 * created by hezq on 2019/12/20
 */
public class StartAndRunMethod {

    public static void main(String[] args) {
    	Runnable runable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
    	runable.run();

    	new Thread(runable).start();
    }

}
