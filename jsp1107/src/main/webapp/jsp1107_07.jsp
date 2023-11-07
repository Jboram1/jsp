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
		<title>Insert title here</title>
	</head>
	<body>
	
	<%
		Connection conn2=null;
		Statement stmt2=null;
		ResultSet rs2=null;
		int bno=0;
		String btitle ="", bcontent="", bdate="", id="";
		int bgroup=0, bstep=0, bindent=0, bhit=0;
		String bfile="";
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ora_user","1111");
			stmt2 = conn2.createStatement();
			String query = "select * from board";
			rs2 = stmt2.executeQuery(query);
			
			while(rs2.next()){
				bno = rs2.getInt("bno");
				btitle = rs2.getString("btitle");
				bcontent = rs2.getString("bcontent");
				bdate = rs2.getDate("bdate")+"";
				id = rs2.getString("id");
				bgroup = rs2.getInt("bgroup");
				bstep = rs2.getInt("bstep");
				bindent = rs2.getInt("bindent");
				bhit = rs2.getInt("bhit");
				bfile = rs2.getString("bfile");
				out.println("번호 : "+bno+",제목: "+btitle+",내용 :"+bcontent+",날짜 :"+bdate+",아이디: "+id+",조회수:"
						+bhit+",파일 : "+bfile+"<br>");
			}
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs2!=null) rs2.close();
				if(conn2!=null) stmt2.close();
				if(stmt2!=null) conn2.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	%>
	
	</body>
</html>