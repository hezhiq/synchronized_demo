package com.hzq.synchronized_demo.anonymousinnerclass;

/**
 * created by hezq on 2019/12/17
 */
public class Test {

    public static void main(String[] args)  {
        new Test().test(1);
    }

    public void test(int b) {
        int a = 10;
        new Thread(){
            @Override
            public void run() {
                System.out.println(a);
                System.out.println(b);
            };
        }.start();
    }

}
