package com.hzq.synchronized_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 可重入粒度测试
 * created by hezq on 2019/12/10
 */
@SpringBootApplication
public class SynchronizedDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SynchronizedDemoApplication.class, args);
    }

}
