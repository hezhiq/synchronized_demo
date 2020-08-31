package com.hzq.synchronized_demo.singleton;

/**
 * created by hezq on 2020/8/31
 * 懒汉式（双重检查）可用，推荐面试使用
 */
public class Singleton6 {

    //为什么要用volatile：1、新建对象实际上有3个步骤，2、重排序会带来NPE，3、防止重排序
    private volatile static Singleton6 instance;

    private Singleton6(){}

    public static Singleton6 getInstance(){
        if(instance == null){ //俩个线程同时走到这行，就都会进入下面代码块
            synchronized(Singleton6.class){
                if (instance == null){
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
