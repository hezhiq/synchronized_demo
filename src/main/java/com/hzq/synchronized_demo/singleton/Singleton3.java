package com.hzq.synchronized_demo.singleton;

/**
 * created by hezq on 2020/8/31
 * 懒汉式（线程不安全）不可用
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3(){}

    public static Singleton3 getInstance(){
        if(instance == null){
            instance = new Singleton3();
        }
        return instance;
    }
}
