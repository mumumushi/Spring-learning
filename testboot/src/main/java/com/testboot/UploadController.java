package com.testboot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class UploadController { 
	private Logger logger = LoggerFactory.getLogger("UploadController.class");
	
	@GetMapping("/upload")
	public ModelAndView upload() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("upload");
		return mav;
	}
	
	@PostMapping("/upload")
	public String upload(MultipartFile uploadFile, HttpServletRequest reg) {
		logger.info("输出2-----------");
		String realPath = 
				reg.getSession().getServletContext().getRealPath("/uploadFile/");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd");
		String format = sdf.format(new Date());	
		File folder = new File(realPath + format);
		
		if (!folder.isDirectory()) {
			folder.mkdirs();
		}
		
		String oldName = uploadFile.getOriginalFilename();
		String newName = UUID.randomUUID().toString()
				+ oldName.substring(oldName.lastIndexOf("."), oldName.length());
		
		try {
			uploadFile.transferTo(new File(folder, newName));
			String filePath = reg.getScheme() + "://" + reg.getServerName() + ":"
					+ reg.getServerPort() + "/uploadFile/" + format + newName;
			return filePath +  "\n上传成功";
		} catch(IOException e) {
			e.printStackTrace();
		}
		return "上传失败";
	}
}
