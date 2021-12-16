package com.example.springbootthread11;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        CompletableFuture cf=CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+":cf异步执行一个任务");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //通过阻塞获取执行结果.
        System.out.println(Thread.currentThread().getName()+"得到cf的值："+cf.get());
        */


        CompletableFuture cf1= CompletableFuture.supplyAsync(
            //简易版本
            // ()->"Hello World"
            ()->{
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+":cf1异步执行一个任务");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Hello World";
            }
        );
        //通过阻塞获取执行结果.
        //System.out.println(Thread.currentThread().getName()+"得到cf1的值："+cf1.get());

        //不需要阻塞
        cf1.thenAccept(rs->{
            System.out.println(Thread.currentThread().getName()+"回调得到cf1的值："+rs);
        });
        //简易写法--java8方法引用
        //cf1.thenAccept(System.out::println);

        try {
            System.out.println(Thread.currentThread().getName()+"开始睡眠");
            //TimeUnit.SECONDS.sleep(6);
            System.out.println(Thread.currentThread().getName()+"睡眠结束");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //() 表示形参，
        /*
        CompletableFuture cf2= CompletableFuture.supplyAsync(()->"Hello World").thenAccept(xx->{
            System.out.println(xx);
        });
        */
        //继续做其他事情。
    }
}
