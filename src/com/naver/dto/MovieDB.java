package com.naver.dto;

import java.io.IOException;
import java.util.ArrayList;

import com.naver.dao.MemberDao;
import com.naver.dao.MemberDaoImpl;
import com.naver.dao.MovieDao;
import com.naver.dao.MovieDaoImpl;
import com.naver.dto.MovieDto;
import com.naver.util.NvMovie;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MovieDB")
public class MovieDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieDB() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				
				MovieDao dao = new MovieDaoImpl();
				ArrayList<MovieDto> list = NvMovie.Movie();
				for(MovieDto t : list) {
					dao.insert(t);
				}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
