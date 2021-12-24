package com.example.threaddemo;

import java.util.HashMap;
import java.util.Map;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
public class ThreadDemo implements Runnable{

    @Override
    public void run() { //回调方法
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程会被执行的代码");
    }
    public static void main(String[] args) {
        // CompletableFuture V  基于Callable/Future的优化
        //new Thread(new SmsSenderTask()).start(); //不需要等待这个程序的处理结果
        //System.out.println("Main方法的输出结果");



        int c = 4;

        HashMap<String,String> m = new HashMap<String,String>(4);
        m.put("111", "111");
        m.put("222", "222");
        m.put("333", "333");
        m.put("444", "444");
    }
}
