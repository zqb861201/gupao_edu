package com.gupaoedu.malll.gpmallportal.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;

    //HystrixCommandProperties
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000"), //熔断窗口持续的时间
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50")
    },fallbackMethod = "fallback")
    @GetMapping("/hystrix/order/{num}")
    public String hystrix(@PathVariable("num")int num){
        if(num%2==0){
            return "正常访问";
        }
        return restTemplate.getForObject("http://localhost:9092/orders",String.class);
    }

    public String fallback(int num){
        return "触发了降级";
    }
}
