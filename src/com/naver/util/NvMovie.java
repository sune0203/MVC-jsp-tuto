package com.naver.util;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.naver.dao.MemberDao;
import com.naver.dao.MemberDaoImpl;
import com.naver.dao.MovieDao;
import com.naver.dao.MovieDaoImpl;
import com.naver.dto.MovieDto;
import com.google.gson.Gson;
public class NvMovie {
	
	public static ArrayList<MovieDto> MovieSel(){
		
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		
		MovieDao dao = new MovieDaoImpl();
		
		list = dao.mselect();
		
		for (int i=0; i<list.size(); i++) {

			MovieDto dto = list.get(i);
			System.out.println(dto.getTitle());		
			System.out.println(dto.getAct());
			System.out.println(dto.getDir());
			System.out.println(dto.getImg());
		}
		return list;
	}
		
	
	
	public static ArrayList<MovieDto> Movie() throws IOException {
		//dto를 전달 하는 리스트
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
//		MovieDto dto = new MovieDto();
//		Gson gson = new Gson();
		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";

		// GET 요청을 보내고 Document 객체를 변수 doc에 저장하기
		Document doc = Jsoup.connect(url).get();

		System.out.println("Title : 네이버 영화 크롤링한거");

		// CSS 선택자를 사용해 링크 추출하기
	
		//#old_content > table > tbody > tr:nth-child(2) > td.title > div > a
		
//		Elements img = doc.select("#content > div.article > div.mv_info_area > div.poster > a");
		//#content > div.article > div.mv_info_area > div.poster > a
		
		
			Elements menus = doc.select("div.tit3 a");
			
		// 반복문 적용하기
		for (Element menu : menus) {

			// 링크의 "title" 속성 값 추출하기
			String title = menu.attr("title").trim();

			// 링크의 URL 추출하기 (절대경로)
			String nextUrl = menu.absUrl("href");

			// log
			System.out.println(String.format("%s\n\t%s", title, nextUrl));

			// 링크 대상 페이지에 접근하기
			Document nextDoc = Jsoup.connect(nextUrl).get();

			// 상세 내용 추출하기
			String content = nextDoc.select("div.poster > a >img").attr("src");
			System.out.println(content);
			
			String dir =nextDoc.select("dl.step1 > dd > a").text();
			
			String act =nextDoc.select("dl.step2 > dd > a").text();
			
			System.out.println(dir);
			System.out.println(act);
			MovieDto dto = new MovieDto();
			dto.setAct(act);
			dto.setDir(dir);
			dto.setImg(content);
			dto.setLink(nextUrl);
			dto.setTitle(title);
			list.add(dto);
//			MemberDaoImpl dao = new MemberDaoImpl();
//			dao.insert(dto);
			
//		// "<title>.html"이라는 이름으로 저장하기
//		Files.write(Paths.get(title + ".html"), content.getBytes("UTF-8"));
		}

	
		return list;
}
	
	
	

}
