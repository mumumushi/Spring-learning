package com.testcloud.eureka_consumer_feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
	@Autowired
	DcClient dcClient;
	
	@GetMapping("/consumer")
	public String dc() {
		return dcClient.dc("Bill", "this is bbbbb", "this is ccccccccccccccc");
	}

}
