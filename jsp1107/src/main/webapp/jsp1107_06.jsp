<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>db연결</title>
	</head>
	<body>
	<%
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		int stuNum=0;
		String name="";
		int grade=0;
		String email="",phone="",gender="",address="";
				
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ora_user","1111");
			stmt = conn.createStatement();
			String query = "select * from stuinfo";
			rs = stmt.executeQuery(query); //100개가 넘어온다
			
			while(rs.next()){ //rs에 데이터가 있으면
				stuNum = rs.getInt("stunum"); //stuNum이라는 컬럼명으로 가져온다.
				name = rs.getString("name");
				grade = rs.getInt("grade");
				email = rs.getString("email");
				phone = rs.getString("phone");
				gender = rs.getString("gender");
				address = rs.getString("address");
				out.println("학변 : "+stuNum+",이름 : "+name+",학년 : "+grade+",이메일 : "+email+",전화번호 : "+phone+", 성별 : "+gender+",주소 : "+address+"<br>");
				
				
				
			}
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null) rs.close();
				if(conn!=null) stmt.close();
				if(stmt!=null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	%>
	
	</body>
</html>