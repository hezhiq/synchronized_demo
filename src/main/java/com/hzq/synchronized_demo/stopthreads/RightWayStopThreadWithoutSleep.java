package com.hzq.synchronized_demo.stopthreads;

/**
 * created by hezq on 2019/12/20
 */
public class RightWayStopThreadWithoutSleep implements Runnable {
    @Override
    public void run() {
        int num = 0;
        while (!Thread.interrupted() && num <= Integer.MAX_VALUE / 2){
            if(num % 10000 == 0){
                System.out.println(num + "是10000的倍数");
            }
            num++;
        }
        System.out.println("任务运行结束了");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(2000L);
        thread.interrupt();
    }
}
