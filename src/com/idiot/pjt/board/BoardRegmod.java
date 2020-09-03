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
import com.idiot.pjt.vo.UserVO;

/**
 * Servlet implementation class BoardRegmod
 */
//글작성하는
@WebServlet("/board/regmod")
public class BoardRegmod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	ViewResolver.foward("/board/regmod", request, response);
	

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		UserVO vo = new UserVO();
		vo = MyUtils.getLogtinUser(request);
		int i_user = vo.getI_user();
		
		BoardVO param = new BoardVO();
		param.setTitle(title);
		param.setCtnt(ctnt);
		param.setI_user(i_user);
		
		BoardDAO.insBoard(param);
		response.sendRedirect("/board/list");
		
	}

}
