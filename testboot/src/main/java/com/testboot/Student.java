package com.testboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;



@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix="student")
public class Student {
	private String name;
	private String thing;
	
	public Student() {}
	
	public Student(String name, String thing) {
		this.name = name;
		this.thing = thing;
	}
	
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
