package com.testcloud.config_client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix="student")
@Data
public class Student {
	//@Data之后就可以自动生成settergetter和toString了
	private String name;
	private float score;
	private int age;	
}