package com.idiot.pjt.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.idiot.pjt.Const;
import com.idiot.pjt.ViewResolver;
import com.idiot.pjt.db.BoardDAO;
import com.idiot.pjt.vo.BoardVO;

/**
 * Servlet implementation class list
 */
@WebServlet("/board/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션을 등록해준다.
		HttpSession hs = request.getSession();
		if(hs.getAttribute(Const.Login_user)==null) {
			response.sendRedirect("/login");
			return; 
		}
		List<BoardVO> list  = new ArrayList();
		list = BoardDAO.selBoardList();
		request.setAttribute("list", list);
		
		ViewResolver.foward("/board/boardList", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
