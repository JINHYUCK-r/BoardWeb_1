package com.idiot.pjt.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.idiot.pjt.Const;
import com.idiot.pjt.MyUtils;
import com.idiot.pjt.ViewResolver;
import com.idiot.pjt.db.BoardCmtDAO;
import com.idiot.pjt.db.BoardDAO;
import com.idiot.pjt.vo.BoardCmtVO;
import com.idiot.pjt.vo.BoardVO;
import com.idiot.pjt.vo.UserVO;

/**
 * Servlet implementation class BoardDetail
 */
@WebServlet("/board/detail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession hs = request.getSession();
		UserVO user = (UserVO) hs.getAttribute(Const.Login_user);
		
		//String int형으로 변형하는 함수 
		int i_board = MyUtils.parseInt("i_board", request);
		int i_user = user.getI_user();
		
		BoardVO param = new BoardVO();
		param.setI_board(i_board);
		param.setI_user(i_user);
		
		
		BoardVO vo = new BoardVO();
		vo = BoardDAO.selBoardDetail(param);
		
		List<BoardCmtVO> list = BoardCmtDAO.selBoardCmtlist(param);
		request.setAttribute("list", list);
		
		request.setAttribute("vo", vo);
		
		
		ViewResolver.foward("/board/detail", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
