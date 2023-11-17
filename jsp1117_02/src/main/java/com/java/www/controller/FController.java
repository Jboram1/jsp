package com.java.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.service.BInsertService;
import com.java.www.service.BLisetService;
import com.java.www.service.BSelectOneService;
import com.java.www.service.MDoLoginservice;
import com.java.www.service.Service;

@WebServlet("*.do")
public class FController extends HttpServlet {
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		
		//파일이름
		String uri = request.getRequestURI();
		String cPath = request.getContextPath();
		String fileName = uri.substring(cPath.length());
		System.out.println("파일이름 :"+fileName);
		
		Service service = null;
		String url = null;
		switch(fileName) {
		case "/index.do":
			System.out.println("index.do: 확인");
			response.sendRedirect("index.jsp");
			break;
			
		case "/login.do":
			response.sendRedirect("login.jsp");
			break;
		case "/doLogin.do":
			service = new MDoLoginservice();
			service.execute(request, response);
			url="doLogin.jsp";
			break;
		case "/logout.do":
			response.sendRedirect("logout.jsp");
			break;
		case "/Blist.do": //1게시글 전체
			service = new BLisetService();
			service.execute(request, response);
			url="Blist.jsp";
			break;
		case "/Bview.do": //2게시글하나
			service = new BSelectOneService();
			service.execute(request, response);
			System.out.println("FController : Bview.jsp호출");
			url = "Bview.jsp";
			break;
		case "/Binsert.do": //3게시글쓰기화면
			response.sendRedirect("Binsert.jsp");
			break;
		case "/DoBinsert.do": //3게시글쓰기
			service = new BInsertService();
			service.execute(request, response);
			System.out.println("FController : doBInsert.jsp호출");
			url = "DoBinsert.jsp";
			break;
		
		
			
		}
		
		
		if(url!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
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
