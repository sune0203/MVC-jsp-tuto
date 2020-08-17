package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.naver.dto.MovieDto;
import com.naver.util.*;

@WebServlet("/MovierServlet")
public class MovierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// view 쪽에 정보를 출력 하면 끝!!
		ArrayList<MovieDto> list = NvMovie.MovieSel();
		Gson gson = new Gson();
		String jsonData = gson.toJson(list);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonData);
		
		
//		PrintWriter out = response.getWriter();
//		out.println(jsonData);
	
		//moviedto를 json 형태로 변환 시키는 작업을 해야 한다.
		
		//Gson 라이브러리를  활용 하면 쉽게 변환 시킬 수 있다.
		
		//변환된 문자열을 아래에서 뿌린다.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
