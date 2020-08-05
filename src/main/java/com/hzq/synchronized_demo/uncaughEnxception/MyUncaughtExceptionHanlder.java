package com.hzq.synchronized_demo.uncaughEnxception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * created by hezq on 2020/8/5
 * 自己的线程异常捕获
 */
public class MyUncaughtExceptionHanlder implements Thread.UncaughtExceptionHandler{
    private String name;

    public MyUncaughtExceptionHanlder(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING,"线程异常，程序停止"+t.getName(),e);
        System.out.println(name + "捕获了异常" + t.getName()+"异常"+e);
    }
}
