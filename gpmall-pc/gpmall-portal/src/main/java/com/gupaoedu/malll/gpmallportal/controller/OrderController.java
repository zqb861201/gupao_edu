package com.gupaoedu.malll.gpmallportal.controller;


import com.gupaoedu.mall.api.IGoodsService;
import com.gupaoedu.mall.api.IOrderService;
import com.gupaoedu.mall.api.IPromotionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Value("${switch:false}")
    private boolean fallbackSwitch;

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private IPromotionService promotionService; //instance?  Proxy$

    @Autowired
    private IOrderService orderService;

    @GetMapping("/{id}")
    public String order(@PathVariable("id")int id){
        log.info("begin do order,{}",fallbackSwitch);
        if(!fallbackSwitch) {
            String goods = goodsService.getGoodsById(id); //
            String promotion = promotionService.getPromotionById();
            String result = orderService.createOrder(goods, promotion);
            return result;
        }else{
            return "服务降级";
        }
    }
}
