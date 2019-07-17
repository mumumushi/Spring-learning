package com.testboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;



@Component
@ConfigurationProperties(prefix="student")
@EnableConfigurationProperties
public class Student {
	private String name;
	private String thing;
	
	public String getName() {
		return name;
	}
	
	public String getThing() {
		return thing;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setThing(String thing) {
		this.thing = thing;
	}
	
}
