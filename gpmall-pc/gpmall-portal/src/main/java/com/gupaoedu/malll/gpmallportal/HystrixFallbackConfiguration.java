package com.gupaoedu.malll.gpmallportal;

import com.gupaoedu.mall.fallback.GoodsServiceFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixFallbackConfiguration {

    @Bean
    public GoodsServiceFallback goodsServiceFallback(){
        return new GoodsServiceFallback();
    }
}
