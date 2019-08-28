package com.testcloud.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class WebController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/add")
	public String add(@RequestParam Integer a, @RequestParam Integer b) {
		//这个url会被ribbon拦截下来，自动进行负载均衡并添加上地址与端口
		return restTemplate.getForObject("http://calculate-server/calc/add?a={a}&b={b}", String.class, a, b);
	}
}
