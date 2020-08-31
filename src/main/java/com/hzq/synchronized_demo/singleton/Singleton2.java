package com.hzq.synchronized_demo.singleton;

/**
 * created by hezq on 2020/8/31
 * 饿汉模式（静态代码块） 可用
 */
public class Singleton2 {
    private final static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    private Singleton2(){}

    public static Singleton2 getInstance(){
        return instance;
    }
}
