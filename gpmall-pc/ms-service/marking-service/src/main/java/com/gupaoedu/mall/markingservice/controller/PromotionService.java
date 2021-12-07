package com.gupaoedu.mall.markingservice.controller;

import com.gupaoedu.mall.api.IPromotionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromotionService implements IPromotionService {

    @GetMapping("/promotion")
    public String getPromotionById(){
        return "查询到指定商品的促销信息";
    }
}
