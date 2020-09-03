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
		String sql = "select i_board, title, ctnt, hits, i_user, r_dt, m_dt"
					+ " from t_board";
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
					
					list.add(param);
				}
				return 0;
			}
			
		});
		 return list;
		
	}

}
