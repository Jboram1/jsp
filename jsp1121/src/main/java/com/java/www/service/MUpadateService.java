package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.MemberDao;
import com.java.www.dto.MemberDto;

public class MUpadateService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("session_id");

		
		//dao접근 - select
		MemberDao mdao = new MemberDao();
		MemberDto mdto = mdao.selectOne(id);
		
		//request 추가
		request.setAttribute("mdto", mdto);
		
	}

}
