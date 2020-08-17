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
import com.naver.dao.*;
import com.naver.dto.HugiPrintDto;
import com.naver.dto.MovieDto;
import com.naver.util.*;

@WebServlet("/HugiprintServlet")
public class HugiprintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HugiprintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// view 쪽에 정보를 출력 하면 끝!!
		
		request.setCharacterEncoding("utf-8");
		
		HugiDao dao  = new HugiDaoImpl();
		
		ArrayList<HugiPrintDto> list = dao.hselect();
		
//		for(HugiPrintDto d : list) {
//			System.out.println(d.getContent());
//			System.out.println(d.getNo());
//			System.out.println(d.getGrade());
//			System.out.println(d.getM_name());
//			System.out.println(d.getName());
//			System.out.println(d.getTitle());
//		}
		
		request.setAttribute("hugilist", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("hugi.jsp");
		dis.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
