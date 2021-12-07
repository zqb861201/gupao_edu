package com.gupaoedu.malll.gpmallportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;



@EnableCircuitBreaker
@EnableFeignClients(basePackages = "com.gupaoedu.mall.feignclient")
@SpringBootApplication
public class GpmallPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(GpmallPortalApplication.class, args);
    }

}
