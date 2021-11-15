package org.example;

import java.util.concurrent.SynchronousQueue;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
public class SynchronizedDemo {

    //修饰实例方法
    public synchronized void m1(){
        while(true){

        }
    }
    Object lock=new Object(); //在内存中会分配一个地址来存储
    public void m2(){
        //代码块
        synchronized (lock){ //当前对象

        }
    }
    public static void main(String[] args) {
        //synchronized的加锁范围
        // 加锁一定会带来性能开销,
        SynchronizedDemo sd=new SynchronizedDemo();
        SynchronizedDemo sd2=new SynchronizedDemo();
        new Thread(()->{
            sd.m2();
        }).start();
        new Thread(()->sd2.m2()).start();
    }
    public synchronized static void m3(){

    }
}
