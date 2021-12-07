package com.gupaoedu.mall.feignclient;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientLogConfiguration {
    /**
     * * NONE
     * * BASIC
     * * HEADDERS
     * * FULL
     * @return
     */
    @Bean
    Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }
}
