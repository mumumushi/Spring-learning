package com.testcloud.config_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RefreshScope
@RestController
@Slf4j
public class StudentController {
	
//	//愚蠢的注入方式。。
//	@Value("${student.name}")
//	private String name;
//	@Value("${student.score}")
//	private float score;
//	@Value("${student.age}")
//	private int age;
	
	//聪明的注入方式，就是要写多一个类，写多很多settergetter，所以这里使用了lombok的@Data注解hhh
	@Autowired
	Student student;
	
	@RequestMapping("/")
	public String view() {
		log.info("haha???????");
		return student.toString();
	}
}
