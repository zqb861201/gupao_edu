package org.example;

import java.util.concurrent.*;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/

public class Test implements Callable<String> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Test callableDemo=new Test();
        FutureTask<String> futureTask=new FutureTask<>(callableDemo);
        Thread thread=new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
    @Override
    public String call() throws Exception {
        return "执行结果:SUCCESS";
    }
}
