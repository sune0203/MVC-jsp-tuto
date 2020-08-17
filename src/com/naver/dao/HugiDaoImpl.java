package com.naver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.naver.db.DB;
import com.naver.dto.HugiDto;
import com.naver.dto.HugiPrintDto;

public class HugiDaoImpl implements HugiDao {

	// 후기 관련 ========================================================
	
		@Override
		public void insert(HugiDto dto) {

			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DB.conn(); 
				String sql = "INSERT INTO hugi (m_name ,u_name, grade,title, content) VALUES (?, ?, ? ,? , ?)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, dto.getM_name());
				pstmt.setInt(2, dto.getName());
				pstmt.setFloat(3, dto.getGrade());
				pstmt.setString(4, dto.getTitle());
				pstmt.setString(5, dto.getContent());
				
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
		
		@Override
		public ArrayList<HugiPrintDto> hselect() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			// 전달 변수(dto 담을 그릇)
			ArrayList<HugiPrintDto> list = new ArrayList<HugiPrintDto>();
			try {
				conn = DB.conn();
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT h.no, m.title, h.title, h.grade,h.content,");
				sql.append("(SELECT name FROM user_tb WHERE num = h.u_name) AS name	");
				sql.append("FROM movie_tb m join hugi h on m.num = h.m_name	");
				pstmt = conn.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					HugiPrintDto dto = new HugiPrintDto();
					dto.setNo(rs.getInt("h.no"));
					dto.setM_name(rs.getString("m.title"));
					dto.setTitle(rs.getString("h.title"));
					dto.setGrade(rs.getInt("h.grade"));
					dto.setName(rs.getString("name"));
					dto.setContent(rs.getString("h.content"));
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
		
		public HugiPrintDto select(String num) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			// 전달 변수(dto 담을 그릇)
			HugiPrintDto dto = new HugiPrintDto();
			try {
				conn = DB.conn();
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT h.no, m.title, h.title, h.grade,h.content,");
				sql.append("(SELECT name FROM user_tb WHERE num = h.u_name) AS name	");
				sql.append("FROM movie_tb m join hugi h on m.num = h.m_name	WHERE h.no=? ");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, num);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					dto.setNo(rs.getInt("h.no"));
					dto.setM_name(rs.getString("m.title"));
					dto.setTitle(rs.getString("h.title"));
					dto.setGrade(rs.getInt("h.grade"));
					dto.setName(rs.getString("name"));	
					dto.setContent(rs.getString("h.content"));	
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
			return dto;
		}
		
		
		
		
		
}
