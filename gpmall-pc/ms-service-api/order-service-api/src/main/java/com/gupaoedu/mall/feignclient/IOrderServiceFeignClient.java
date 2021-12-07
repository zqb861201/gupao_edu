package com.gupaoedu.mall.feignclient;

import com.gupaoedu.mall.api.IOrderService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="order-service")
public interface IOrderServiceFeignClient extends IOrderService {

}
