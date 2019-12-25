package com.hzq.synchronized_demo.stopthreads;

/**
 * created by hezq on 2019/12/25
 */
public class RightWayStopThreadInProd implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                System.out.println("run() 方法中的异常只能try/catch,不能throw");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
