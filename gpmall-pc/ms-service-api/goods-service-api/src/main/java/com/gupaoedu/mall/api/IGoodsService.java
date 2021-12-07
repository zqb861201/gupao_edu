package com.gupaoedu.mall.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface IGoodsService {

    @GetMapping("/goods")
    String getGoodsById(@RequestParam int id);
}
