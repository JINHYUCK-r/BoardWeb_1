package com.idiot.pjt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dbcon {
	public static Connection getCon() throws Exception {
		String url = "jdbc:mysql://localhost:3306/jspdb?serverTimezone=UTC";
		String username = "root";
		String password = "1234";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		// static이 붙은 메소드 객체화가 안 돼있음. 스태틱이 안 붙은 멤버필드를 안쓸때 쓰임
		// DriverManager 대문자로 시작 -> 클래스명이다! 대문자로 시작하는거 싹  다!
		// 역할 : DB 연결. Connection객체를 리턴해줌!
		System.out.println("접속 성공");
		return con;
	}
	//select
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs != null) { try{ rs.close(); } catch(Exception e) {} }
		if(ps != null) { try{ ps.close(); } catch(Exception e) {} }
		if(con != null) { try{ con.close(); } catch(Exception e) {} }
	}
	//update delete용 그래서 rs가 없
	public static void close(Connection con, PreparedStatement ps) {
		close(con, ps, null);
	}

}
