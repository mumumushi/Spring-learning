package com.testcloud.eureka_consumer_feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-client")
public interface DcClient {
	@GetMapping("dc")
	String dc(@RequestParam(value="name") String name, @RequestParam(value="b") String b, @RequestParam(value="c") String c);
	
}
