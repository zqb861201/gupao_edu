package com.gupaoedu.vip.pattern.singleton.test;

import com.gupaoedu.vip.pattern.singleton.register.ContainerSingleton;

/**
 * Created by Tom.
 */
public class ContainerSingletonTest {
    public static void main(String[] args) {
    	//简单测试
//        Object instance1 = ContainerSingleton.getInstance("com.gupaoedu.vip.pattern.singleton.test.Pojo");
//        Object instance2 = ContainerSingleton.getInstance("com.gupaoedu.vip.pattern.singleton.test.Pojo");
//        System.out.println(instance1 == instance2);
        
        //并发测试
    	for(int i=0;i<10;i++){
    		new Thread(()->{
    			Object instance1 = ContainerSingleton.getInstance("com.gupaoedu.vip.pattern.singleton.test.Pojo");
    			System.out.println(instance1);
    		}).start();
    	}
    }
}
