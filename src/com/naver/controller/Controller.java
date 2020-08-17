package com.naver.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.naver.dao.MemberDao;
import com.naver.dao.MemberDaoImpl;
import com.naver.dto.MovieDto;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.nhn")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuffer url = request.getRequestURL();
//		System.out.println(url);
		String uri = request.getRequestURI();
		String [] arrUri = uri.split("/");
		uri = arrUri[2];
		
		String site = null;
//		System.out.println("내가 찾고 싶은 문자열: " + arrUri[2]);   // /loginbt/b.nhn
		if (uri.equals("main.nhn")) {
			site = "main.jsp";
		} else if (uri.equals("login.nhn")) {
			site = "login.jsp";
		} else if (uri.equals("loginok.nhn")) {
			site = "LoginServlet";
		} else if (uri.equals("logout.nhn")) {
			site = "logout.jsp";
		} else if (uri.equals("join.nhn")) {
			site = "join.jsp";
		} else if (uri.equals("joinok.nhn")) {
			site = "JoinServlet";
		} else if (uri.equals("emailck.nhn")) {
			site = "EmailCkServlet";
		} else if (uri.equals("search.nhn")) {
			site = "search.jsp";
		} else if (uri.equals("searchok.nhn")) {
			site = "SearchServlet";
		} else if (uri.equals("food.nhn")) {
			site = "Food.jsp";
		} else if (uri.equals("foodok.nhn")) {
			site = "FoodServlet";
		} else if (uri.equals("movie.nhn")) {
			site = "Movie.jsp";
		} else if (uri.equals("movieok.nhn")) {
			site = "MovieServlet";
		} else if (uri.equals("movier.nhn")) {
			site = "Movier.jsp";
		} else if (uri.equals("movierok.nhn")) {
			site = "MovierServlet";
		} else if (uri.equals("movier2.nhn")) {
			site = "MovierServlet2";
		} else if (uri.equals("hugi.nhn")) {
			site = "HugiprintServlet";
		} else if (uri.equals("hugidetail.nhn")) {
			site = "HugidetailServlet";
		} else if (uri.equals("hugiok.nhn")) {
			site = "HugiServlet";
		} else {
			site = "404.jsp";
			System.out.println("error");
		}
		RequestDispatcher dis = request.getRequestDispatcher(site);
		dis.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
