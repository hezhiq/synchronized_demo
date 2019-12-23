package com.hzq.synchronized_demo.warnway;

import java.util.Timer;
import java.util.TimerTask;

/**
 * created by hezq on 2019/12/16
 */
public class TimerDome {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000,2000);
    }

}
