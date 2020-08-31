package com.hzq.synchronized_demo.singleton;

/**
 * created by hezq on 2020/8/31
 * 懒汉式（线程不安全,同步代码块）不可用
 */
public class Singleton5 {
    private static Singleton5 instance;

    private Singleton5(){}

    public static Singleton5 getInstance(){
        if(instance == null){ //俩个线程同时走到这行，就都会进入下面代码块，从而创建俩个实例
            synchronized(Singleton5.class){
                instance = new Singleton5();
            }
        }
        return instance;
    }
}
