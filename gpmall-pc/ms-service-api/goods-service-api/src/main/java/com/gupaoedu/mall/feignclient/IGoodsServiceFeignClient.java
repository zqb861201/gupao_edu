package com.gupaoedu.mall.feignclient;

import com.gupaoedu.mall.api.IGoodsService;
import com.gupaoedu.mall.fallback.GoodsServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;

//http://ip:port/uri


@FeignClient(name = "goods-service",configuration = FeignClientLogConfiguration.class,fallback = GoodsServiceFallback.class)
public interface IGoodsServiceFeignClient extends IGoodsService {

}
