package com.hzq.synchronized_demo.joinPackage;

/**
 * created by hezq on 2020/8/2
 * 先join，在同通过Thread.getState()查看线程状态
 * 通过debuggre看线程的join前后的状态
 */
public class JoinThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("主线程的状态："+mainThread.getState());
                    System.out.println("thread-0子线程运行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        System.out.println("等待子线程运行完毕");
        thread.join();
        System.out.println("子线程运行完毕");

    }
}
