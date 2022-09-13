<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Index 페이지</title>
	</head>
	<body>
		<h3>MyBatis 사용</h3>
		
		<a href="<c:url value='/product/productAllList'/>">전체 상품 조회</a><br><br>
		<a href="<c:url value='/product/productNewForm'/>">상품 등록</a><br><br>
		
		<a href="<c:url value='/product/productSearchForm1'/>">상품 검색1</a><br><br>
		<a href="<c:url value='/product/productSearchForm2'/>">상품 검색2</a><br><br>
		<hr>
		<a href="<c:url value='/fileUploadForm'/>">파일 업로드</a><br><br>
		<a href="<c:url value='/fileDownloadList'/>">파일 다운로드</a><br><br>
	</body>
</html>