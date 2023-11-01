package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/S01")
public class S1101_01 extends HttpServlet {
	
       
  
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");//post는 꼭한글처리(한글이깨지지않게 맨위로 올려준다.먼저실행
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender"); //남자, 여자 (value값이 넘어온다.
		String address = request.getParameter("address"); //서울, 부산.. (value값이 넘어온다.
		
		//선택이 여러개일때는 배열로 가져온다. getParamenterValues
		String[] hobbys = request.getParameterValues("hobby"); //배열로가져옴.게임,골프,요리..
		String hobby="";
		for(int i=0;i<hobbys.length;i++) {
			if(i==0) hobby = hobbys[i];
			else hobby += "," +hobbys[i];
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter(); //웹에 페이지를 찍어주고 글자도 가능
		
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title>form데이터 결과</title>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<h3>아이디 : "+ id +"</h3>");
		writer.print("<h3>패스워드 : "+ pw +"</h3>");
		writer.print("<h3>성별 : "+ gender +"</h3>");
		writer.print("<h3>취미 배열 : "+ Arrays.toString(hobbys) +"</h3>");
		writer.print("<h3>취미 : "+ hobby +"</h3>");
		writer.print("<h3>주소 : "+ address +"</h3>");
		writer.print("</body>");
		writer.print("</html>");
		
		writer.close(); //이걸 안 하면 아무일도 일어나지 않는다.
		
		
		
		
	}//
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}

}
