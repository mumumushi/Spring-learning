package com.testcloud.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class WebServerFeignApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(WebServerFeignApplication.class).web(true).run(args);
	}
}
