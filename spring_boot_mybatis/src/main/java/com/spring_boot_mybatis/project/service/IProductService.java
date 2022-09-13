package com.spring_boot_mybatis.project.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot_mybatis.project.model.ProductVO;

public interface IProductService {
	//	규격 정하기 : 어떤 메소드는 반드시 포함할 것
	
	// 전체 상품 정보 조회
	public ArrayList<ProductVO> listAllProduct();		// 반환형 무엇인지 미리 정하기
	
	// 상품 정보 등록
	public void insertProduct(ProductVO prd);
	
	// 상품 정보 수정
	public void updateProduct(ProductVO prd);
	
	// 상품 정보 삭제
	public void deleteProduct(String prdNo);
	
	// 상세 상품 정보 조회 (1개의 상품만 조회)
	public ProductVO detailViewProduct(String prdNo);
	
	
	public String prdNoCheck(String prdNo);
	
	ArrayList<ProductVO> productSearch(HashMap<String, Object> map);	// 상품 검색
}
