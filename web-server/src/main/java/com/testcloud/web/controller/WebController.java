package com.testcloud.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {
	@Autowired
	LoadBalancerClient loadBalancerClient;
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/add")
	public String add(@RequestParam Integer a, @RequestParam Integer b) {
		ServiceInstance serviceInstance = loadBalancerClient.choose("calculate-server");
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() 
						+ "/calc/add?a={a}&b={b}";
		System.out.println(url);
		return restTemplate.getForObject(url, String.class, a, b);
	}
}
