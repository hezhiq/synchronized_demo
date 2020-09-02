package com.hzq.synchronized_demo.deadlock;

/**
 * created by hezq on 2020/9/1
 * 银行转账例子
 */
public class TransferMoney implements Runnable {
    int flag;
    static Money a = new Money(500);
    static Money b = new Money(500);

    public static void main(String[] args) throws InterruptedException {
        TransferMoney d1 = new TransferMoney();
        TransferMoney d2 = new TransferMoney();
        d1.flag = 1;
        d2.flag = 0;
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("a的余额："+a.amount);
        System.out.println("b的余额："+b.amount);
    }

    @Override
    public void run() {

        if (flag == 1){
            transferMoney(a,b,600);
        }
        if (flag == 0){
            transferMoney(b,a,200);
        }
    }

    static void transferMoney(Money from,Money to,int amount){
        synchronized (from){
            //打开注释就会死锁
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (to){
                if(from.amount - amount < 0){
                    System.out.println("余额不足");
                }else {
                    from.amount -= amount;
                    to.amount += amount;
                    System.out.println("转账成功：" + amount);
                }
            }
        }
    }

    static class Money{
        int amount;

        public Money(int amount) {
            this.amount = amount;
        }
    }
}
