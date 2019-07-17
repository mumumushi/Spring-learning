package com.testboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class, webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AppTestRestTemplate {
	
	@Autowired
	TestRestTemplate restTemplate;
	//hehe是TestRestTemplate，不是我们平时使用的RestTemplate注意
	
	@Test
	public void welcomeControllerTest() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("/?a={0}&b={1}&c={2}",
				String.class, 23, "haha", 2333);
		System.out.println("\n" + responseEntity.getBody() + "\n");
	}
}
