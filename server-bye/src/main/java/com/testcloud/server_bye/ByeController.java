package com.testcloud.server_bye;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByeController {
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("/dc")
	public String dcbye() {
		String services = "Services: " + discoveryClient.getServices();
		System.out.println(services);
		return "Bye! " + services;
	}
	
}
