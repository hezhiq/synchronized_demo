package com.hzq.synchronized_demo.anonymousinnerclass;

/**
 * created by hezq on 2019/12/17
 */
public class Outer {

    private Inner inner = null;

    private int a = 5;
    static int b = 6;
    void add(int a, int b){
        System.out.println(a + b);
    }

    //成员内部类
    class Inner{
        private int c = 3;
        void innerAdd(){
            add(a,b);
        }
    }

    private Inner getInner(){
        if(inner == null){
            inner = new Inner();
        }
        return inner;
    }

    private Outer getPartInner(){
        //局部内部类
        class PartInner extends Outer{
            void print(){
                System.out.println("我是局部内部类");
            }
        }
        return new PartInner();
    }

    //静态内部类
    static class StaticInner{
        private int c = 3;
        void innerAdd(){
            System.out.println("我是静态内部类 c = "+c);
        }
    }

    public void test() {
        new Thread(){
            @Override
            public void run() {
                System.out.println(a);
                System.out.println(b);
            };
        }.start();
    }
    
    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
        inner.innerAdd();

        Inner inner1 = outer.getInner();
        inner1.innerAdd();

        outer.getPartInner();

        new StaticInner().innerAdd();

        //JDK1.8以前s必须是final，不然会编译不通过，1.8之后虽然不报错，但是编译的生产class文件的时候会把这个类型变成final传给内部类
        int s = 0;
        //内部类使用的变量不能变为final，不然编译不通过
//        s = s + 1;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是匿名内部类"+ s);
            }
        }).start();

        outer.test();
    }

}
