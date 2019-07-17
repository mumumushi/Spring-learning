package com.testcloud.eureka_consumer_feign;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class App {
    public static void main( String[] args ) {
        new SpringApplicationBuilder(App.class).web(true).run(args);
    }
}	
