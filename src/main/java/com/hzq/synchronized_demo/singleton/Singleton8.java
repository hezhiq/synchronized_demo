package com.hzq.synchronized_demo.singleton;

/**
 * created by hezq on 2020/8/31
 * 枚举（生产最佳使用方式，推荐使用）
 */
public enum Singleton8 {
    instance;

    public void whatever(){
        System.out.println("Singleton8.whatever");
    }

}

class userEnumSingletion{
    public static void main(String[] args) {
        Singleton8.instance.whatever();
    }
}
