package com.hzq.synchronized_demo;

/**
 * created by hezq on 2020/8/5
 * 同事发一个i++赋值的小面试问题
 */
public class AddTest {
    public static void main(String[] args) {
        int count = 0;
        int num = 0;
        for (int i = 0; i < 100; i++) {
            num = num + i;
            count = count++;
        }
        System.out.println("num * count = "+(num * count));
    }
}
