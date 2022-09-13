package com.spring_boot_mybatis.project.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class fileUploadController {
	
	// 파일 업로드 폼 열기 요청 처리
	@RequestMapping("/fileUploadForm")
	public String viewFileUploadForm() {
		return "upload/fileUploadForm";
	}
	
	// file upload
	@RequestMapping("/fileUpload")
	public String viewFileUpload(@RequestParam("uploadFile") MultipartFile file, Model model) throws IOException {
		
		// 1. 파일 저장 경로 설정 : 실제 서비스되는 위치 (프로젝트 외부에 저장)
		String uploadPath = "C:///springWorkSpace/upload/";
		
		// 2. 원본 파일 이름 설정
		String originalFileName = file.getOriginalFilename();
		
		// 3. 파일 이름이 중복되지 않도록 파일 이름 변경 : 서버에 저장할 이름
		// UUID 클래스 사용 : 랜덤 생성
		UUID uuid = UUID.randomUUID();
		String savedFileName = uuid.toString()+"_"+originalFileName;
		
		// 4. 파일 생성
		File newFile = new File(uploadPath + savedFileName);
		
		// 5. 서버로 전송
		file.transferTo(newFile);
		
		// Model 설정 : 뷰 페이지에서 원본 파일 이름 출력
		model.addAttribute("originalFileName", originalFileName);
		
		return "redirect:./mypage2";
	}
	
	// file upload MULTIPLE
	@RequestMapping("/fileUploadMultiple")
	public String viewFileUploadMultiple(@RequestParam("uploadFileMultiple") ArrayList<MultipartFile> files, Model model) throws IOException {
		
		// 1. 파일 저장 경로 설정 : 실제 서비스되는 위치 (프로젝트 외부에 저장)
		String uploadPath = "/Users/newp/workSpace/springWorkSpace/upload/";
		
		// 여러 개의 파일 이름 저장할 리스트
		ArrayList<String> originalFileNameList = new ArrayList<String>();
		
		// 2. 원본 파일 이름 가져오기
		for (MultipartFile file : files) {
			// 원본파일 이름
			String originalFileName = file.getOriginalFilename();
			// 오리지날 파일 이름을 리스트에 추가
			originalFileNameList.add(originalFileName);
			
			// 3. 파일 이름이 중복되지 않도록 파일 이름 변경 : 서버에 저장할 이름
			// UUID 클래스 사용 : 랜덤 생성
			UUID uuid = UUID.randomUUID();
			String savedFileName = uuid.toString()+"_"+originalFileName;
			
			// 4. 파일 생성
			File newFile = new File(uploadPath + savedFileName);
			
			// 5. 서버로 전송
			file.transferTo(newFile);
			
			// Model 설정 : 뷰 페이지에서 원본 파일 이름 출력
			model.addAttribute("originalFileNameList", originalFileNameList);
		}
		
		return "upload/fileUploadMultipleResult";
	}

	// file upload Origin
	@RequestMapping("/fileOriginNameUpload")
	public String viewFileOriginNameUpload(@RequestParam("uploadFileMultiple") ArrayList<MultipartFile> files, Model model) throws IOException {
		
		// 1. 파일 저장 경로 설정 : 실제 서비스되는 위치 (프로젝트 외부에 저장)
		String uploadPath = "/Users/newp/workSpace/springWorkSpace/upload/";
		
		// 여러 개의 파일 이름 저장할 리스트
		ArrayList<String> originalFileNameList = new ArrayList<String>();
		
		// 2. 원본 파일 이름 가져오기
		for (MultipartFile file : files) {
			// 원본파일 이름
			String originalFileName = file.getOriginalFilename();
			// 오리지날 파일 이름을 리스트에 추가
			originalFileNameList.add(originalFileName);
			
//			// 3. 파일 이름이 중복되지 않도록 파일 이름 변경 : 서버에 저장할 이름
//			// UUID 클래스 사용 : 랜덤 생성
//			UUID uuid = UUID.randomUUID();
//			String savedFileName = uuid.toString()+"_"+originalFileName;
			
			// 4. 파일 생성
			File newFile = new File(uploadPath + originalFileName);
			
			// 5. 서버로 전송
			file.transferTo(newFile);
			
			// Model 설정 : 뷰 페이지에서 원본 파일 이름 출력
			model.addAttribute("originalFileNameList", originalFileNameList);
		}
		
		return "upload/fileUploadMultipleResult";
	}
}
