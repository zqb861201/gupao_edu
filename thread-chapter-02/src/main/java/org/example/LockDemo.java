package org.example;


import org.openjdk.jol.info.ClassLayout;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
public class LockDemo {
    Object o=new Object();
    public static void main(String[] args) {
        LockDemo demo=new LockDemo();
        //加锁之前
        System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        System.out.println("加锁之后....");
        //如果有其他线程进入到下面的同步块，则先自旋
        //CAS() 保证数据操作的原子性.
        synchronized (demo) {//轻量级锁
            System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        }
    }
}
