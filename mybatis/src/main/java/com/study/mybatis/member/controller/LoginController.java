package com.study.mybatis.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.study.mybatis.member.sevice.MemberServiceImpl;
import com.study.mybatis.member.vo.Member;

public class LoginController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Member m = new Member(); //멤버 선언 -> 입력받는 객체
      //m이라는 멤버객체에 id, pwd 담아줌
      m.setUserId(request.getParameter("userId"));
      m.setUserPwd(request.getParameter("userPwd"));
      
      //loginuser 객체 생성
      // why? DB에 실제 들어있는 유저인지 모르니깐 !!
      Member loginUser = new MemberServiceImpl().loginMember(m);
      
      if(loginUser == null) { //로그인 실패
    	  request.setAttribute("errorMsg", "로그인 실패");
    	  request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
    	  //getRequestDispatcher : 즉 /a.jsp 로 들어온 요청을 /a.jsp 내에서 RequestDispatcher를 사용하여 b.jsp로 요청을 보낼 수 있습니다. 
    	  //또는 a.jsp에서 b.jsp로 처리를 요청하고 b.jsp에서 처리한 결과 내용을 a.jsp의 결과에 포함시킬 수 있습니다.
    	  //.forward(request, response) : 우리가 받은 값들을 저짝 페이지로 넘겨주는것
      }else { //로그인 성공
    	  request.getSession().setAttribute("loginUser", loginUser);
    	  //loginUser란 이름을 갖는 키에 세션에 저장된 데이터가 바로 나 loginUser닷!
    	  response.sendRedirect(request.getContextPath());
    	  //index.jsp로 돌아가서 다시 처음부터 실행
    	  //sendRedirect :  웹 서버가 웹 브라우저에게 다른 페이지로 이동하라고 응답하는 기능
    	/*  
    	 request.getContextPath()
    	 프로젝트 Path만 가져옵니다.
    	  request.getContextPath() 
    	  예)  http://localhost:8080/project/list.jsp
    	  [return]/project
    	   */
    	  System.out.println("request.getContextPath()"  + request.getContextPath());
    	  
      }
   }

}
/*
  setAttribute : 세션에 값 저장하기 위해서는 session 객체의 setAttribute 메소드를 사용
  getAttribute : 세션에 저장된 값을 얻기 위해서는 session 객체의 getAttribute 메소드를 사용

*/