package com.gupaoedu.mall.fallback;

import com.gupaoedu.mall.feignclient.IGoodsServiceFeignClient;
import org.springframework.stereotype.Component;

public class GoodsServiceFallback implements IGoodsServiceFeignClient {

    @Override
    public String getGoodsById(int id) {
        return "查询商品信息异常，Hystrix触发了降级保护机制";
    }
}
