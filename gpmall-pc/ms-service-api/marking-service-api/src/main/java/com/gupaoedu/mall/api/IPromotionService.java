package com.gupaoedu.mall.api;

import org.springframework.web.bind.annotation.GetMapping;

public interface IPromotionService {

    @GetMapping("/promotion")
    String getPromotionById();
}
