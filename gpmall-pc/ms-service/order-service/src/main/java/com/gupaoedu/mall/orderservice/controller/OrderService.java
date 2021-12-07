package com.gupaoedu.mall.orderservice.controller;


import com.gupaoedu.mall.api.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@RestController
public class OrderService implements IOrderService {

    @PostMapping("/order")
    public String createOrder(@RequestParam String goodsInfo,@RequestParam String pomotionInfo){
        log.info("开始创建订单,请求参数,{},{}",goodsInfo,pomotionInfo);
        return "订单创建结果："+goodsInfo+","+pomotionInfo+"";
    }
}
