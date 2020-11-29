package com.idiot.pjt.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.idiot.pjt.Const;
import com.idiot.pjt.MyUtils;
import com.idiot.pjt.db.BoardDAO;
import com.idiot.pjt.vo.BoardVO;
import com.idiot.pjt.vo.UserVO;

/**
 * Servlet implementation class BoardDelete
 */
@WebServlet("/board/delete")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		
		int i_board = MyUtils.parseInt("i_board", request);
		
		 
		
		System.out.println(i_board);
		
	 	BoardVO param = new BoardVO();
	 	param.setI_board(i_board);
	 	
	 	BoardDAO.delBoard(param);
	 	
	 	response.sendRedirect("/board/list");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	}

}
