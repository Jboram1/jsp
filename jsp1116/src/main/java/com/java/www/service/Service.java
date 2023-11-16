package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	
	//FC에서 넘어와서 거처간다
	public void execute(HttpServletRequest request, HttpServletResponse response);

}
