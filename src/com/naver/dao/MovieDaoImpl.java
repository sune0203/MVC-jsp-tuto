package com.naver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.naver.db.DB;
import com.naver.dto.MovieDto;

public class MovieDaoImpl implements MovieDao{

	// 영화 관련 ===================================================
	
		public void insert(MovieDto dto) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DB.conn(); 
//				String sql = "INSERT INTO movie_tb(title,act,dir,img) \r\n" + 
//						"SELECT '반도','배우','감독','http://'  FROM DUAL WHERE NOT EXISTS \r\n" + 
//						"(SELECT title,act,dir,img FROM movie_tb WHERE title = '새로운영화');";
				
				StringBuffer sql = new StringBuffer();
				sql.append("INSERT INTO movie_tb(title ,act ,dir ,img)");
				sql.append("SELECT ?, ?, ?, ?  FROM DUAL WHERE NOT EXISTS");
				sql.append("(SELECT title,act,dir,img FROM movie_tb WHERE title = ?) ");
				
				pstmt = conn.prepareStatement(sql.toString());
				
				pstmt.setString(1, dto.getTitle());
				pstmt.setString(2, dto.getAct());
				pstmt.setString(3, dto.getDir());
				pstmt.setString(4, dto.getImg());
				pstmt.setString(5, dto.getTitle());
				
				int count = pstmt.executeUpdate();
				if (count == 0) {
					System.out.println("데이터 입력 실패");
				} else {
					System.out.println("데이터 입력 성공");
				}

			} catch (Exception e) {
				System.out.println("에러: " + e);
			} finally {
				try {
					if (conn != null && !conn.isClosed()) {
						conn.close();
					}
					if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		public ArrayList<MovieDto> mselect() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			// 전달 변수(dto 담을 그릇)
			ArrayList<MovieDto> list = new ArrayList<MovieDto>();
			try {
				conn = DB.conn();
				String sql = "SELECT * FROM movie_tb";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					MovieDto dto = new MovieDto();
					dto.setTitle(rs.getString("title"));
					dto.setAct(rs.getString("Act"));
					dto.setDir(rs.getString("dir"));
					dto.setImg(rs.getString("img"));
					dto.setNum(rs.getInt("num"));
					list.add(dto);
				}

			} catch (Exception e) {
				System.out.println("에러: " + e);
			} finally {
				try {
					if( rs != null && !rs.isClosed()){
	                    rs.close();
	                }
					if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
					if (conn != null && !conn.isClosed()) {
						conn.close();
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return list;
			
		}
		
}
