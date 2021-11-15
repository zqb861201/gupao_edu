package org.example;

import org.openjdk.jol.info.ClassLayout;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
public class HeightLockDemo {

    public static void main(String[] args) {
        HeightLockDemo demo=new HeightLockDemo();
        Thread t1=new Thread(()->{

            synchronized (demo){//如果当前是重量级锁.后面来的线程直接阻塞.
                //IO
                //wait()
                System.out.println("t1 locked");
                System.out.println(ClassLayout.parseInstance(demo).toPrintable());
            }
        });
        t1.start();
        synchronized (demo){
            System.out.println("main locked");
            System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        }

    }
}
