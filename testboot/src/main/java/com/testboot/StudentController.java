package com.testboot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	private Logger logger = LoggerFactory.getLogger("StudentController.class");
	
	@Autowired
	Student student;
	
	/*@GetMapping("/student")
	public ModelAndView student() {
		ModelAndView mav = new ModelAndView();
		mav.addObject(student);
		mav.setViewName("student");
		return mav;
	}
	*/
	@GetMapping("/student")
	public Student getStudent() {
		logger.info("输出1---------------");
		return student;
	}
	
	
	
}
