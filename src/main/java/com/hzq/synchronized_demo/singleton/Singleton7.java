package com.hzq.synchronized_demo.singleton;

/**
 * created by hezq on 2020/8/31
 * 静态内部类（可用）
 */
public class Singleton7 {

    private Singleton7(){}

    private static class SingletonInstance{
        private final static Singleton7 instance = new Singleton7();
    }

    public static Singleton7 getInstance(){

        return SingletonInstance.instance;
    }
}
