<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 확인</title>
	</head>
	<body>
	
		<%
		
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
			
		if(id.equals("admin") && pw.equals("1111")){ //성공할 경우
		
			session.setAttribute("session_id", id);
			session.setAttribute("session_nicName", "유신스");
		
		%>
		<script>
		 alert("로그인 되었습니다."); 
		 location.href="../layout/main.jsp";
		</script>
		<%}else{ //실패할 경우%> 
			<script>
			alert("아이디 또는 패스워드가 일치하지 않습니다. 다시 로그인하세요.")
			location.href="login.jsp"; //history.back();-뒤로 돌아갔을때 썼던 아이디와 비밀번호가 적혀있다. 둘다 사용가능.
			</script>
		
		
		
		<% }%>
		
	</body>
</html>