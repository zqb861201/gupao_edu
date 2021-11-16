package org.example;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo sd=new SynchronizedDemo();
        Thread t1=new Thread(sd);
        t1.start();
        sd.m2();
    }
    static class SynchronizedDemo implements Runnable{
        int b=0;
        @Override
        public void run() {
            try {
                m1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public synchronized void m1() throws InterruptedException {
            System.out.println("m1 start...");
            b=100;
            Thread.sleep(3000);
            System.out.println("b="+b);
        }
        public synchronized void m2() throws InterruptedException {
            System.out.println("m2 start...");
            Thread.sleep(1000);
            b=500;
        }
    }
}
