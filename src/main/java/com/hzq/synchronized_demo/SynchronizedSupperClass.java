package com.hzq.synchronized_demo;

/**
 * created by hezq on 2019/12/10
 * 可重入测试 子类调用父类
 */
public class SynchronizedSupperClass {

    public synchronized void dosomething(){
        System.out.println("我是父类的方法1");
    }

}

class SynchronizedSonClass extends SynchronizedSupperClass{

    public synchronized void dosomething(){
        System.out.println("我是子类的方法");
        super.dosomething();
    }

    public static void main(String[] args) {
    	SynchronizedSonClass synchronizedSonClass = new SynchronizedSonClass();
    	synchronizedSonClass.dosomething();
    }

}
