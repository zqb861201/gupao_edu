package com.gupaoedu.malll.gpmallportal.controller;

import com.gupaoedu.malll.gpmallportal.NacosConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    /*@Autowired
    NacosConfigProperties nacosConfigProperties;*/

   /* @GetMapping("/config")
    public String test(){
        String msg=String.format("配置类型：%s，profile:%s", nacosConfigProperties.getFormat(),nacosConfigProperties.getEnv());
        return msg;
    }*/
}
