package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.naver.dao.MemberDao;
import com.naver.dao.MemberDaoImpl;
import com.naver.dao.MovieDao;
import com.naver.dao.MovieDaoImpl;
import com.naver.dto.MovieDto;
import com.naver.util.*;

@WebServlet("/MovierServlet2")
public class MovierServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovierServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// view 쪽에 정보를 출력 하면 끝!!
		
		request.setCharacterEncoding("utf-8");
		
		MovieDao dao  = new MovieDaoImpl();
		
		ArrayList<MovieDto> list = dao.mselect();
		
		request.setAttribute("movielist", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("Movier2.jsp");
		dis.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
