package com.gupaoedu.mall.feignclient;

import com.gupaoedu.mall.api.IPromotionService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="marking-service")
public interface IPromotionServiceFeignClient extends IPromotionService {
}
