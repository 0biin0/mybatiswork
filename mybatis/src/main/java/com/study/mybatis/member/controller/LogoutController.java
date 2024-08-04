package com.study.mybatis.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath());
	}

}
/*
	 세션이 더 이상 사용되지 않는다면 세션 정보도 더 이상 필요하지 않는다.
	 이때 설정된 세션의 값들을 모두 사라지도록 하기 위해서는 세션 객체의 invalidate 함수를 사용
	 invalidate 함수는 세션을 없애고 세션에 속해있는 값들을 모두 없앤다.
*/