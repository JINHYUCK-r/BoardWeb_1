package com.idiot.pjt.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.idiot.pjt.vo.BoardVO;

// BoardDAO를 만들어서 sql문을 실행시켜VO에 값을 넣는다 
public class BoardDAO {
	
	public static List<BoardVO> selBoardList(){
		/* 초기버전. 기본적인 테이블 데이터를 가져옴 
		String sql = "select i_board, title, ctnt, hits, i_user, r_dt, m_dt"
					+ " from t_board";
		*/
		//테이블을 조인해서 이름을 가져온다.
		String sql = "select A.i_board, A.title, A.ctnt, A.hits, A.i_user,B.nm, A.r_dt, A.m_dt"
				+ " from t_board A"
				+ " inner join t_user B"
				+ " on A.i_user = B.i_user"
				+ " order by i_board desc";
		//최신순으로 정렬하기위하여 sql문사
				
		//역순으로 출력하여 최신글이 가장 위에 올라오도록 한다.
		
		List<BoardVO> list = new ArrayList();
		
		 JdbcTemplate.executeQuery(sql, new JdbcSelectInterface() {

			@Override
			public void prepared(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
			}

			@Override
			public int excuteQuery(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				while(rs.next()) {
					BoardVO param = new BoardVO();
					param.setI_board(rs.getInt("i_board"));
					param.setTitle(rs.getNString("title"));
					param.setCtnt(rs.getNString("ctnt"));
					param.setHits(rs.getInt("hits"));
					param.setI_user(rs.getInt("i_user"));
					//날짜는 getString타입으로 받아야
					param.setR_dt(rs.getString("r_dt"));
					param.setM_dt(rs.getString("m_dt"));
					param.setNm(rs.getNString("nm"));
					
					list.add(param);
				}
				return 0;
			}
			
		});
		 return list;
		
	}
	
	
	//데이터베이스에 입력받은 게시판 글을 넣는 메소
	public static void insBoard(BoardVO param) {
		String sql = "insert into t_board(title, ctnt,i_user) values(?,?,?)";
		
		JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {

			@Override
			public void update(PreparedStatement ps) throws SQLException {
				ps.setNString(1, param.getTitle());
				ps.setNString(2, param.getCtnt());
				ps.setInt(3, param.getI_user());
				
			}
			
		});
					
	}
	
	public static BoardVO selBoardDetail(BoardVO param) {
		
		String sql = "select A.i_board, A.title, B.nm, A.ctnt from t_board A"
				+ " inner join t_user B"
				+ " on A.i_user = B.i_user"
				+ " where i_board = ?";
		
		BoardVO vo = new BoardVO();
		
		 JdbcTemplate.executeQuery(sql, new JdbcSelectInterface() {

			@Override
			public void prepared(PreparedStatement ps) throws SQLException {
				ps.setInt(1, param.getI_board());
				
			}

			@Override
			public int excuteQuery(ResultSet rs) throws SQLException {
				
				if(rs.next()) {
					
				vo.setI_board(rs.getInt("i_board"));
				vo.setTitle(rs.getNString("title"));
				vo.setCtnt(rs.getNString("ctnt"));
				vo.setNm(rs.getNString("nm"));
				}
				
				return 0;
			}
			
			 
		 });
		
		
		return vo;
	}
	
	public static void delBoard(BoardVO param) {
		
		String sql = "delete from t_board where i_board = ?";
		
		JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {

			@Override
			public void update(PreparedStatement ps) throws SQLException {
				ps.setInt(1, param.getI_board());
				
			}
			
		});
		
	}

}
