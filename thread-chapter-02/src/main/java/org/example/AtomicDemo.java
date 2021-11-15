package org.example;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
public class AtomicDemo {

    int i=0;
    //排他锁、互斥锁
    public synchronized void incr(){
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicDemo ad=new AtomicDemo();
        Thread[] thread=new Thread[2];
        for (int i = 0; i <2 ; i++) {
            thread[i]=new Thread(()->{
                for(int k=0;k<10000;k++) {
                    ad.incr();
                }
            });
            thread[i].start();
        }
        thread[0].join();
        thread[1].join();
        System.out.println("Result:"+ad.i);
    }

}
