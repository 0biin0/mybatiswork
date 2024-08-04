package com.study.mybatis.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.study.mybatis.member.sevice.MemberServiceImpl;
import com.study.mybatis.member.vo.Member;


public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/*
		  Member m = new Member(); 
		  m.setUserId(request.getParameter("userId"));
		  m.setUserId(request.getParameter("userPwd"));
		  m.setUserId(request.getParameter("userName"));
		  m.setUserId(request.getParameter("email"));
		  m.setUserId(request.getParameter("birthday"));
		  m.setUserId(request.getParameter("gender"));
		  m.setUserId(request.getParameter("phone"));
		  m.setUserId(request.getParameter("address"));
		  m.setUserId(request.getParameter("enrollDate"));
		  m.setUserId(request.getParameter("modifyDate"));
		  m.setUserId(request.getParameter("status"));
		   => 이렇게 해줘도 된다
		 */
		Member m = new Member(
				request.getParameter("userId"),
				// getParameter("요청 매개변수이름이며 해당 매개변수의 값이 저장될 변수")
				// form이 제출되면 서버로 HTTP POST요청이 전송되며, 서버 측에서는 request.getParameter()메서드를 사용하여 "username"및 "password"매개변수의 값을 가져올 수 있다
				request.getParameter("userPwd"),
				request.getParameter("userName"),
				request.getParameter("email"),
				request.getParameter("birthday"),
				request.getParameter("gender"),
				request.getParameter("phone"),
				request.getParameter("address")
				);
		int result = new MemberServiceImpl().insertMember(m);
		
		if(result>0) {
			response.sendRedirect(request.getContextPath());
		}else {
			//request.getRequestDispatcher("WEB-INF/views/member/memberEnrollForm.jsp").forward(request, response);
			request.setAttribute("errorMsg", "회원가입 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
