package com.hzq.synchronized_demo.singleton;

/**
 * created by hezq on 2020/8/31
 * 饿汉模式（静态常量） 可用
 */
public class Singleton1 {
    private final static Singleton1 instance = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance(){
        return instance;
    }
}
