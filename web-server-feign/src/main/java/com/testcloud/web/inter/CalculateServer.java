package com.testcloud.web.inter;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("calculate-server")
public interface CalculateServer {
	@GetMapping("calc/add")
	String add(@RequestParam(value="a") Integer a, @RequestParam(value="b") Integer b);
	
}
