package com.hzq.synchronized_demo.stopthreads;

/**
 * created by hezq on 2019/12/25
 */
public class RightWayStopThreadInProd implements Runnable{
    @Override
    public void run() {
        while (true){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("程序中断");
                break;
            }
            System.out.println("go");
            throwInMethod();
        }
    }

    private void throwInMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
