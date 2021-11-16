package org.example;

public class LockDif {
    public static void main(String[] args) {
        LockDif dif = new LockDif();
        for(int i=0;i<2;i++){
            int j = i;
            new Thread(()->{
                if(j%2==0){
                    dif.m1();
                }else{
                    dif.m2();
                }
            },"dif_"+i).start();
        }
    }

    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+" m1 start...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m1 end...");
    }

    public synchronized void m2(){
        System.out.println(Thread.currentThread().getName()+" m2 start...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m2 end...");
    }
}
