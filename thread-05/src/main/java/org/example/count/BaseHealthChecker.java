package org.example.count;

import java.util.concurrent.CountDownLatch;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
public abstract class BaseHealthChecker implements Runnable{
    private CountDownLatch countDownLatch;

    private String serviceName; //服务名称

    private boolean serviceUp;

    public BaseHealthChecker(){

    }
    public BaseHealthChecker(String serviceName) {
        this.serviceName = serviceName;
    }
    public BaseHealthChecker(CountDownLatch countDownLatch,String serviceName) {
        this.countDownLatch = countDownLatch;
        this.serviceName = serviceName;
    }
    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    @Override
    public void run() {
        try {
            verifyService();
            serviceUp=true;
        }catch (Exception e){
            serviceUp=false;
        }finally {

        }
    }

    /**
     * 检查服务的健康情况
     */
    public abstract void verifyService() throws Exception;

    public String getServiceName() {
        return serviceName;
    }

    public boolean isServiceUp() {
        return serviceUp;
    }
}
