package com.gupaoedu.mall.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IOrderService {

    @PostMapping("/order")
    String createOrder(@RequestParam String goodsInfo, @RequestParam String pomotionInfo);
}
