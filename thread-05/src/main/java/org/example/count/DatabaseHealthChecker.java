package org.example.count;

import java.util.concurrent.CountDownLatch;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
public class DatabaseHealthChecker extends BaseHealthChecker{

    public DatabaseHealthChecker() {
        super("DatabaseHealthChecker");
    }

    @Override
    public void verifyService() throws Exception {
        System.out.println("Checking:"+this.getServiceName());
        try {
            Thread.sleep(2000);
            System.out.println(this.getServiceName()+" 健康状态正常");
        } catch (Exception e) {
            throw e;
        }finally {
            getCountDownLatch().countDown();
        }
    }

}
