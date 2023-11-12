package com.t0ng.webteenviewerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WebteenViewerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebteenViewerServiceApplication.class, args);
    }

}
