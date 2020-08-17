package com.naver.dao;

import java.util.ArrayList;

import com.naver.dto.HugiDto;
import com.naver.dto.HugiPrintDto;
import com.naver.dto.MemberDto;
import com.naver.dto.MovieDto;

public interface MemberDao {

	// 데이터 넣고 
	public void insert(MemberDto dto);

	// ID로 검색하고
	public boolean select(String email);
	
	// 전체 데이터 가져오기
	public ArrayList<MemberDto> select();
	
	// Email 과 PW를 검색
	public MemberDto select(String email, String pw);
	
//	// 점수 정보 업데이트
//	public void update(MemberDto dto);
}