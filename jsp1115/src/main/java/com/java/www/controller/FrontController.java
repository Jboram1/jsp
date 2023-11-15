package com.java.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.service.BoardService;
import com.java.www.service.DoLoginMemberService;
import com.java.www.service.MemberService;
import com.java.www.service.listBoardService;


@WebServlet("*.do")
public class FrontController extends HttpServlet {

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		String url = null;
	
		//파일이름 알아내기
		String uri = request.getRequestURI();
		System.out.println("uri : "+uri);
		String conPath = request.getContextPath();
		System.out.println("context path : "+conPath);
		
		String fileName = uri.substring(conPath.length()); //+1하면 파일이름앞에 /슬래시도 빠진다.(단,슬래시 빼면(fileName.equals("/doLogin.do"))여기에서도 슬래시 빼줘야 오류안남
		System.out.println("파일이름 : "+fileName);
		
		//이동주소
		if(fileName.equals("/index.do")) {
			System.out.println("메인페이지로 이동");
			response.sendRedirect("index.jsp");
		}else if(fileName.equals("/login.do")) {
			System.out.println("로그인페이지로 이동");
			response.sendRedirect("login.jsp");//이전사용법//request,response 리셋되서 보내짐
		}else if(fileName.equals("/doLogin.do")) {
			System.out.println("로그인여부 페이지 이동");
			//객체선언후 참조변수명.메소드명 - 부모의 참조변수로 자손의 객체:다형성
			//유지보수를 위해
			MemberService memberService = new DoLoginMemberService();
			memberService.execute(request, response);
			url = "doLogin.jsp";
			
		}else if(fileName.equals("/write.do")) {
			System.out.println("회원가입페이지 이동");
			response.sendRedirect("mwrite.jsp");
		}else if(fileName.equals("/list.do")) {
			System.out.println("게시판페이지 이동");
			//service연결
			BoardService boardService = new listBoardService();
			boardService.execute(request, response);
			
			
			url="list.jsp";
			//db정보필요 -dispatcher
		}else if(fileName.equals("/logout.do")) {
			System.out.println("로그아웃페이지 이동");
			response.sendRedirect("logout.jsp");
		}else if(fileName.equals("/update.do")) {
			System.out.println("회원정보수정페이지 이동");
			//db정보필요 -dispatcher
			
		}
		
		
		
		//url이동
		if(url!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		}

		
		
		
	}
	
	
	
	
	//---
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}

}
