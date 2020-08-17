package com.naver.dao;

import java.util.ArrayList;

import com.naver.dto.HugiDto;
import com.naver.dto.HugiPrintDto;

public interface HugiDao {
	//게시판 데이터 넣기
	public void insert(HugiDto dto);
	//게시판 데이터 들고오기
	public ArrayList<HugiPrintDto> hselect();
	
	public HugiPrintDto select(String num);
}
