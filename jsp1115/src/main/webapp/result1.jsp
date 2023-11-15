<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>결과</title>
	</head>
	<body>
	
		<h1>아이디 : ${param.id}</h1>
		<h1>아이디 : ${id}</h1> <!-- 결과값 나오지 않음 param을 써야한다 -->
		<h1>두수를 더하기 : ${param.num1+param.num2}</h1> <!-- form에서 값이 넘어올때 String으로 넘어오는데 자동으로 int로 형변환되어 계산된다. -->
		<c:if test="${param.num3%2==0}"> <!-- 홀수찾기 %2==0 -->
			<h1>짝수입니다.</h1>
		</c:if>
		<c:if test="${param.num3%2!=0}"> <!-- c:if 일때는 else 없으니 if 두번쓰기 -->
			<h1>홀수입니다.</h1>
		</c:if>
		
	
	
	</body>
</html>