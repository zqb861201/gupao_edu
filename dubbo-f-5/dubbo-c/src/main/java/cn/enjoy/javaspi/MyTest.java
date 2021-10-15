package cn.enjoy.javaspi;

import java.util.Iterator;
import java.util.Scanner;
import java.util.ServiceLoader;

/**
 * @Classname MyTest
 * @Description TODO
 * @Author 无涯
 * Date 2021/10/13 20:38
 * Version 1.0
 */
public class MyTest {

    //不同的入参，对应调用的逻辑是不一样的
    public static void main(String[] args) {
        //这个是我们业务的核心代码，核心代码会根据外部的参数决定要掉哪一个实例的路径
        //可以去读配置文件 properties配置，去决定调用哪个实例
        //jdk api  加载配置文件配置实例
        ServiceLoader<GLog> all = ServiceLoader.load(GLog.class);


        Scanner scanner = null;
        try{
            scanner = new Scanner(System.in);
            String s = null;
            do{
                s = scanner.nextLine();

                Iterator<GLog> iterator = all.iterator();
                while (iterator.hasNext()) {
                    GLog next = iterator.next();
                    //这个实例是不是我们需要掉的
                    // 策略模式  当前实例是不是跟入参匹配
                    if(next.support(s)) {
                        next.debug();
                    }
                }

            }while (s==null||!s.equals("close"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            scanner.close();
        }
    }
}
