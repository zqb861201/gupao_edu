package com.gupaoedu.malll.gpmallportal;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
//@RefreshScope
//@Configuration
public class NacosConfigProperties {

    @Value("${config.format: default-format}")
    private String format;

    @Value("${current.env: default-env}")
    private String env;

}
