package org.example.count;

import java.util.concurrent.CountDownLatch;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2082233439
 * http://www.gupaoedu.com
 **/
public class CacheHealthChecker extends BaseHealthChecker{

    public CacheHealthChecker() {
        super("CacheHealthChecker");
    }

    @Override
    public void verifyService() throws Exception {
        System.out.println("Checking:"+this.getServiceName());
        try {
            Thread.sleep(1000);
            // 如果检查失败，throw RuntimeException()
            System.out.println(this.getServiceName()+" 健康状态正常");
        } catch (Exception e) {
            throw e;
        } finally {
            getCountDownLatch().countDown();
        }

    }
}
