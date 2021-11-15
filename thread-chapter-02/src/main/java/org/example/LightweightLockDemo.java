package org.example;

import org.openjdk.jol.info.ClassLayout;

/**
 * 轻量级锁
 */
public class LightweightLockDemo {
    public static void main(String[] args) {
        LightweightLockDemo demo = new LightweightLockDemo();
        System.out.println("befre lock");
        System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        synchronized (demo){
            System.out.println("lock ing");
            System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        }
        System.out.println("after lock");
        System.out.println(ClassLayout.parseInstance(demo).toPrintable());

    }
}
