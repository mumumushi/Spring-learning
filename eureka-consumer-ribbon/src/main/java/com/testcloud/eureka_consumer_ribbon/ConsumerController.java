package com.testcloud.eureka_consumer_ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/consumer")
	public String consumer() {
		//这个url会被ribbon拦截下来，自动进行负载均衡并添加上地址与端口
		return restTemplate.getForObject("http://eureka-client/dc", String.class);
	}
}
