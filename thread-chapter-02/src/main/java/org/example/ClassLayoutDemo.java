package org.example;

import org.openjdk.jol.info.ClassLayout;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
public class ClassLayoutDemo {
//    Object o=new Object();
    public static void main(String[] args) {
        //构建了一个对象实例
        ClassLayoutDemo classLayoutDemo=new ClassLayoutDemo();
        //假设A线程进入到同步代码. 偏向A线程,
        //存在多个线程来抢占锁， 线程B来抢占锁. 轻量级锁()
        System.out.println(ClassLayout.parseInstance(ClassLayoutDemo.class).toPrintable());
    }
}
