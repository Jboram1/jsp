package com.java.www.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;

public class BListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao bdao = new BoardDao();
		//게시글 전체가져오기
		ArrayList<BoardDto> list = bdao.bListSelectAll();
		
		System.out.println("BListService :"+list.get(0).getBno());
		//request에 담기 //여기 list에 있는건 bList로 간다
		request.setAttribute("list",list); //"list"-변수선언,list-데이터값
	}

}
