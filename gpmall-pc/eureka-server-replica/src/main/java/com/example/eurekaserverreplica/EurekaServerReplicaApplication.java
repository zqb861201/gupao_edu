package com.example.eurekaserverreplica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerReplicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerReplicaApplication.class, args);
    }

}
