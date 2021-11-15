package org.example;

import org.openjdk.jol.info.ClassLayout;

/**
 * 无锁状态分析
 */
public class NoLockDemo {
    public static void main(String[] args) {
        NoLockDemo demo = new NoLockDemo();
        System.out.println("befor hash");
        //没有计算HASHCODE之前的对象头
        System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        //JVM 计算的hashcode
        System.out.println("jvm------------0x"+Integer.toHexString(demo.hashCode()));
        //当计算完hashcode之后，我们可以查看对象头的信息变化
        System.out.println("after hash");
        System.out.println(ClassLayout.parseInstance(demo).toPrintable());
    }
}
