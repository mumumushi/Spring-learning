package com.testboot;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ModelAndView uploadException(MaxUploadSizeExceededException e, 
			HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("msg", "上传文件大小超出限制");
		mav.addObject("status", resp.getStatus());
		mav.setViewName("error");
		return mav;
	}
}
