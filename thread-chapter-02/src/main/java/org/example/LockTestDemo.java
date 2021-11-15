package org.example;

import org.openjdk.jol.info.ClassLayout;

public class LockTestDemo {
    public static void main(String[] args) {
        LockTestDemo demo = new LockTestDemo();
        System.out.println("加锁之前");
        System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //直接是重量级锁
        /*
        for(int i=0;i<2;i++){
            new Thread(()->{
                try{
                    synchronized (demo){
                        String status = ClassLayout.parseInstance(demo).toPrintable();
                        System.out.println(Thread.currentThread().getName()+"-->"+status);
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName()+" end...");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            },"demo_"+i).start();
        }
        */

        //轻量级锁升级为重量级锁

        for(int i=0;i<2;i++){
            new Thread(()->{
                try{
                    synchronized (demo){
                        String status = ClassLayout.parseInstance(demo).toPrintable();
                        System.out.println(Thread.currentThread().getName()+"-->"+status);
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName()+" end...");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            },"demo_"+i).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
