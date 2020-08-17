package com.naver.dao;

import java.util.ArrayList;

import com.naver.dto.MovieDto;

public interface MovieDao {

	// 영화 데이터 넣기
	public void insert(MovieDto dto);
	//영화 데이터 들고오기
	public ArrayList<MovieDto> mselect();
	
}
