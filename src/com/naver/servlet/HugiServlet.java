package com.naver.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.naver.dao.MemberDao;
import com.naver.dao.*;
import com.naver.dto.HugiDto;
import com.naver.dto.MemberDto;

@WebServlet("/HugiServlet")
public class HugiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HugiServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		int m_name =Integer.parseInt(request.getParameter("mv_num"));
//		int name = Integer.parseInt(request.getParameter("mb_num"));
//		int grade = Integer.parseInt(request.getParameter("grade"));
		int m_name = Integer.parseInt(request.getParameter("mv_num"));
		int name = Integer.parseInt(request.getParameter("mb_num"));
		String title = request.getParameter("h_tit");
		String content = request.getParameter("hugi");
		int grade = Integer.parseInt(request.getParameter("grade"));
		System.out.println(m_name);
		System.out.println(name);
		System.out.println(title);
		System.out.println(content);
		System.out.println(grade);
		
		HugiDto dto = new HugiDto();
		dto.setM_name(m_name);
		dto.setName(name);
		dto.setGrade(grade);
		dto.setContent(content);
		dto.setTitle(title);
		
		HugiDao dao = new HugiDaoImpl();
		
		dao.insert(dto);
		
		//AJAX 에서 받을 메세지
		response.getWriter().append("ok");
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
