package com.hzq.synchronized_demo.jmm;

/**
 * created by hezq on 2020/8/31
 * 演示可见性带来的问题
 */
public class FieldVisibility {
    int a = 1;
    volatile int b = 2;

    public static void main(String[] args) {
        while (true){
            FieldVisibility fieldVisibility = new FieldVisibility();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    fieldVisibility.change();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    fieldVisibility.print();
                }
            }).start();
        }

    }

    private void print() {
        System.out.println("b=" + b + ";a=" + a);
    }

    private void change() {
        a = 3;
        b = a;
    }
}
