package org.example;

import org.openjdk.jol.info.ClassLayout;

/**
 * 重量级锁
 */
public class HeavyweightLockDemo {
    public static void main(String[] args) {
        HeavyweightLockDemo demo = new HeavyweightLockDemo();
        System.out.println("befre lock");
        System.out.println(ClassLayout.parseInstance(demo).toPrintable());//无锁

        Thread t1= new Thread(){
            public void run() {
                synchronized (demo){
                    try {
                        Thread.sleep(5000);
                        System.out.println("t1 release");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("t1 lock ing");
        //轻量锁
        System.out.println(ClassLayout.parseInstance(demo).toPrintable());

        synchronized (demo){
            System.out.println("t1 main lock");
            //重量锁
            System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        }

        System.gc();
        System.out.println("after gc()");
        //无锁---gc
        System.out.println(ClassLayout.parseInstance(demo).toPrintable());

    }
}
