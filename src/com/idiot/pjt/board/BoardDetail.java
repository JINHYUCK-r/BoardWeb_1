package com.idiot.pjt.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.idiot.pjt.MyUtils;
import com.idiot.pjt.ViewResolver;
import com.idiot.pjt.db.BoardDAO;
import com.idiot.pjt.vo.BoardVO;

/**
 * Servlet implementation class BoardDetail
 */
@WebServlet("/board/detail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int i_board = MyUtils.parseInt("i_board", request);
		
		BoardVO param = new BoardVO();
		param.setI_board(i_board);
		
		
		BoardVO vo = new BoardVO();
		vo = BoardDAO.selBoardDetail(param);
		
		request.setAttribute("vo", vo);
		
		
		ViewResolver.foward("/board/detail", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
