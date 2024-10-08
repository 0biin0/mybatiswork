package com.study.mybatis.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.study.mybatis.board.service.BoardServiceImpl;
import com.study.mybatis.board.vo.Board;
import com.study.mybatis.common.template.Pagenation;
import com.study.mybatis.common.vo.PageInfo;

public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int totalRecord = new BoardServiceImpl().selectTotalRecord();
		int nowPage = Integer.parseInt(request.getParameter("nowPage"));
		PageInfo pi = Pagenation.getPageInfo(totalRecord, nowPage, 10, 5);
		
		ArrayList<Board> list =  new BoardServiceImpl().selectList(pi);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
		}

}

/*
int totalRecord = 0;	// 전체 레코드 수(board테이블의 전체 행의 수)
int numPerPage = 10;	// 1page에 보여줄 레코드 수
int pagePerBlock = 5;	// 블록당 페이지 수 = [1][2][3][4][5] 
int nowPage = 1;		// 현재 해당하는 페이지

// 위의 4개를 가지고 계산		
int totalPage;	// 전체 페이지 : 레코드수 67개라면, totalPage=7  [1][2][3][4][5][6][7]
int startPage;	// 페이징바의 시작 수
int endPage;	// 페이징바의 끝수

//


*/