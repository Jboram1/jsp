package com.java.www;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/S01")
public class S1102_01 extends HttpServlet {
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		//text, password, radio, select
		String name = request.getParameter("name"); //1개의 데이터
		//checkbox
		String[] hobbys = request.getParameterValues("hobby"); // 여러개의 데이터
		//db타입 - varchar2(String), number(int,double), date(date, timestamp)
		String hobby ="";
		for(int i=0;i<hobbys.length;i++) {
			if(i==0) hobby = hobbys[i];
			else hobby += ","+ hobbys[i];
		}
		
		System.out.println("hobby 1개 출력" + hobby);
		System.out.println("hobbys 배열 출력" + Arrays.toString(hobbys));
		System.out.println("이름 : "+name);
		
		//getPrameterNames 출력방법
		Enumeration enum1 = request.getParameterNames(); //id,pw,name,hobby
		while(enum1.hasMoreElements()) {
			String ename = (String)enum1.nextElement();
			String[] evalue = request.getParameterValues(ename);
			System.out.println("input name명 : "+ename);
			System.out.println("input value : "+Arrays.toString(evalue));
			
			
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}

}