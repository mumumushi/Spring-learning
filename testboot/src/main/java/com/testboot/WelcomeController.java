package com.testboot;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class WelcomeController {
	
	
    @GetMapping("/")
    public String welcome(HttpServletRequest request, HttpServletResponse response) {
    	log.info("ha--------");
    	return "welcome to spring boot! \n"
    			+ request.getMethod() + " "
    			+ request.getRequestURL() + "?"
    			+ request.getQueryString();

//    	response.setHeader("content-type", "text/html;charset=utf-8");
//    	try {
//    		PrintWriter out = response.getWriter();
//    		out.write("RemoteAddr: " + request.getRemoteAddr());
//    		out.write("<br>");
//    		out.write("RemoteHost: " + request.getRemoteHost());
//    		out.write("<br>");
//    		out.write("RemotePort: " + request.getRemotePort());
//    		out.write("<br>");
//    		out.write("QueryString: " + request.getQueryString());
//    		out.write("<br>");
//    	} catch (IOException e) {
//    		e.printStackTrace();
//    	}
//    	return null;
    
    }
}
