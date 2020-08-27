package com.idiot.pjt.db;

import java.sql.PreparedStatement;
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

}
