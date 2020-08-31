package com.idiot.pjt.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.idiot.pjt.vo.UserVO;

public class UserDAO {
	public static int insUser(UserVO param) {
		String sql = " insert into t_user"
				+ " (user_id,user_pw,nm,email) "
				+ " value(?,?,?,?)";
		// 인터페이스를 객체화 한게 아니고 implements 한거다
				// 익명클래스 활용 - 따로 클래스를 만들지 않아도 된다
		//콜백함수 : 함수를 파라미터로 받는다.
				return JdbcTemplate.executeUpdate(sql, new JdbcUpdateInterface() {
					
					@Override
					public void update(PreparedStatement ps) throws SQLException {				
						ps.setNString(1, param.getUser_id());
						ps.setNString(2, param.getUser_pw());
						ps.setNString(3, param.getNm());
						ps.setNString(4, param.getEmail());
					}
				});
		
		}
	//데이터베이스의 아이디와 비밀번호를 확인하기 위한 함수 . loginSer에서 사용 
	public static int chkUser(UserVO param) {
		//sql문으로 아이디의 존재여부와 비밀번호를 가져온다. i_user는 나중에 세션에 활용 
		String sql = "select user_id, user_pw, i_user"
					+ " from t_user"
					+ " where user_id=?";
		
		return JdbcTemplate.executeQuery(sql, new JdbcSelectInterface() {
			//JdbcSelectInterface() 인테페이스 구체화하
			@Override
			//sql문에 값 집어넣
			public void prepared(PreparedStatement ps) throws SQLException {
				ps.setNString(1, param.getUser_id());
				
				
			}
			int result =0;
			//sql문의 결과를 가져온다.
			@Override
			public int excuteQuery(ResultSet rs) throws SQLException {
				if(rs.next()) { //rs에 값이 있으면 실행한다.
					String db_user_id = rs.getNString("user_id");
					String db_user_pw = rs.getNString("user_pw");
					int i_user = rs.getInt("i_user");
					
					//아이디와 비밀번호 각 조건에 맞게 result 값을 배출한다.
					if(db_user_id.equals(param.getUser_id())){
						if(db_user_pw.equals(param.getUser_pw())){
							param.setI_user(i_user);
							result = 1;
						}else {
							result = 2;
							
						}
					}
					
				}
				//각 조건의 맞는 result값을 배출 
				return result;
			}});
		
	}
				
	}


