package com.hzq.synchronized_demo.stopthreads.volatileDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * created by hezq on 2020/1/7
 * 演示用volatile的局限：part1 不可行
 */
public class WrongWayVolaliteCantStop {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);
        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);
        Comsumer comsumer = new Comsumer(storage);
        while (comsumer.needMoreNums()){
            System.out.println(comsumer.stotage.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据");
        producer.canceled = true;
        System.out.println(producer.canceled);

    }
}

class Producer implements Runnable{
    public volatile boolean canceled = false;
    BlockingQueue stotage;

    public Producer(BlockingQueue stotage) {
        this.stotage = stotage;
    }

    @Override
    public void run() {
        int num = 0;

        try {
            while (num <= 100000){
                if(num % 100 == 0 && !canceled){
                    stotage.put(num);
                    System.out.println(num+"是100的倍数");
                }
                num++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者结束生产");
        }
    }
}

class Comsumer{
    BlockingQueue stotage;
    public Comsumer(BlockingQueue stotage){
        this.stotage = stotage;
    }

    public boolean needMoreNums(){
        if(Math.random() < 0.95){
            return true;
        }else {
            return false;
        }
    }
}
