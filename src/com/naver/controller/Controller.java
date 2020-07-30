package com.naver.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		StringBuffer url = request.getRequestURL();
		System.out.println(url);
		String uri = request.getRequestURI();
		String [] arrUri = uri.split("/");
		uri = arrUri[2];
//		for (int i=0; i< arrUri.length; i++) {
//			System.out.println(arrUri[i]);
//		}
		
		System.out.println("내가 찾고 싶은 문자열: " + arrUri[2]);   // /loginbt/b.nhn
		if (uri.equals("naver.nhn")) {
//			response.getWriter().println("naver");
			response.sendRedirect("https://www.naver.com/");
		} else if (uri.equals("kakao.nhn")) {
//			response.getWriter().println("kakao");
			response.sendRedirect("https://www.daum.net/");
		} else {
			response.getWriter().println("error page");
		}

		String addr = request.getRemoteAddr();
		System.out.println(addr);
		int port = request.getRemotePort();
		System.out.println(port);
//		String host = request
//		System.out.println(host);
		response.getWriter().println();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
