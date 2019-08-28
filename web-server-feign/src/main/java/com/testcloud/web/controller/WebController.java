package com.testcloud.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testcloud.web.inter.CalculateServer;

@RestController
public class WebController {
	@Autowired
	CalculateServer calculateServer;
	
	@GetMapping("/add")
	public String add(@RequestParam Integer a, @RequestParam Integer b) {
		return calculateServer.add(a, b);
	}

}
