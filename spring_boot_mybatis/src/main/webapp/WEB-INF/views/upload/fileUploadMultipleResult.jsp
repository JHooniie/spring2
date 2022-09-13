<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>여러 개의 파일 업로드 결과</title>
	</head>
	<body>
		<c:forEach var="name" items="${originalFileNameList }">
		${name } <br>
		</c:forEach> 
		<hr>
		파일을 업로드 하였습니다. <br>
		/Users/springWorkspace/upload 폴더에서 확인하세요.
	</body>
</html>