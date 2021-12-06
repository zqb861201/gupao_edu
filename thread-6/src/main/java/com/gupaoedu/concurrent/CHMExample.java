package com.gupaoedu.concurrent;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

public class CHMExample {
    private static ConcurrentHashMap<String,Integer> USER_ACESS_COUNT = new ConcurrentHashMap<String, Integer>();



    public static void main(String[] args) {
        int size = 10;
        CountDownLatch latchAbsent = new CountDownLatch(size);
        for(int i=1;i<=size;i++){
            final int j = i;
            new Thread(()->{
                //如果K不存在，则执行表达式
                int value = USER_ACESS_COUNT.computeIfAbsent("user1",k->{
                    System.out.println(Thread.currentThread().getName()+"--computeIfAbsent执行-->"+j);
                    return j;
                });
                System.out.println(Thread.currentThread().getName()+"-->"+value);
                latchAbsent.countDown();
            }).start();
        }
        try {
            latchAbsent.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("user1-->"+USER_ACESS_COUNT.get("user1"));



        CountDownLatch latchPresent = new CountDownLatch(size);
        USER_ACESS_COUNT.put("ddd",0);
        for(int i=1;i<=size;i++){
            new Thread(()->{
                //如果K存在，则执行表达式
                int value = USER_ACESS_COUNT.computeIfPresent("ddd",(k,v)->{
                    System.out.println(Thread.currentThread().getName()+"--computeIfPresent执行-->"+k);
                    return (v+1);
                });
                System.out.println(Thread.currentThread().getName()+"--->"+value);
                latchPresent.countDown();
            }).start();
        }
        try {
            latchPresent.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        USER_ACESS_COUNT.computeIfPresent("ccc",(k,v)->{
            System.out.println("computeIfPresent执行-->"+k);
            return (v+v);
        });
        System.out.println("ddd-->"+USER_ACESS_COUNT.get("ddd"));


        int bigsize = 1000;
        CountDownLatch latchCompute = new CountDownLatch(bigsize);
        for(int i=0;i<bigsize;i++){
            final int j = i%10;
            new Thread(()->{
                USER_ACESS_COUNT.compute("key-"+j,(k,v)->{
                    if(v==null){
                        return 1;
                    }else{
                        return v+1;
                    }
                });
                latchCompute.countDown();
            }).start();
        }
        try {
            latchCompute.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(USER_ACESS_COUNT);


        ConcurrentHashMap<Integer,Integer> chm = new ConcurrentHashMap<Integer, Integer>();
        Stream.of(1,2,2,2,1,5).forEach(v->{
            chm.merge(v,5,Integer::sum);
        });

        System.out.println(chm);
    }
}
