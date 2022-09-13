package com.spring_boot_mybatis.project.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownloadController {
	
	// 파일 다운로드 리스트 출력
	@RequestMapping("/fileDownloadList")
	public ModelAndView fileDownloadList(ModelAndView mv) {
		File path = new File("/Users/newp/workSpace/springWorkSpace/upload");
		String[] fileList = path.list();
		
		mv.addObject("fileList", fileList);
		mv.setViewName("upload/fileDownloadListView");
		
		return mv;
	}
	
	// 파일 다운로드
	@RequestMapping("/fileDownload/{file}")
	public void fileDownload(@PathVariable String file, HttpServletResponse response) throws IOException {	// response 객체 필요
		File f = new File("/Users/newp/workSpace/springWorkSpace/upload/",file);
		
		String encodedFileName = new String(file.getBytes("UTF-8"),"ISO-8859-1");
		
		// 파일 다운로드 설정
		response.setContentType("application/download");
		response.setContentLength((int)f.length());
		response.setHeader("Content-Disposition", "attatchment;filename=\""+encodedFileName+"\"");
		// 다운로드 시 저장되는 이름은 Response Header의 Content-Disposition에 명시해야 함.
		
		// response 객체를 통해 서버로부터 파일 다운로드 받음
		OutputStream os = response.getOutputStream();
		
		// 파일 입력 객체 생성
		FileInputStream fis = new FileInputStream(f);
		FileCopyUtils.copy(fis, os);
	}
}
