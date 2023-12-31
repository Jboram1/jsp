package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.MemberDao;
import com.java.www.dto.MemberDto;

public class DoMInsertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby ="";
		for(int i=0;i<hobbys.length;i++) {
			if(i==0) hobby = hobbys[i];
			else hobby += ","+hobbys[i];
		}
		MemberDto mdto = new MemberDto(id, pw, name, phone, gender, hobby);
		
		//dao접근
		MemberDao mdao = new MemberDao();
		int result = mdao.doMInsert(mdto);
		
		
		//request추가
		request.setAttribute("result", result);
		
	}

}
