package org.example;

import org.openjdk.jol.info.ClassLayout;
/**
 * 偏向锁状态分析
 */
public class BiasedLockDemo {
    public static void main(String[] args) {
        //虚拟机启动时对偏向锁有延时
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BiasedLockDemo demo = new BiasedLockDemo();
        synchronized (demo){
            System.out.println("偏向锁");
            System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        }
    }
}
