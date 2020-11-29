package com.idiot.pjt.user;

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
 * Servlet implementation class UserLikeSer
 */
@WebServlet("/UserLikeSer")
public class UserLikeSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO user = (UserVO) hs.getAttribute(Const.Login_user);

		
		String strI_board = request.getParameter("i_board");
		int i_board = Integer.parseInt(strI_board);	
		String strLike = request.getParameter("yn_like");
		int yn_like = Integer.parseInt(strLike);
		System.out.println(yn_like);
		String strI_user = request.getParameter("i_user");
		int i_user = Integer.parseInt(strI_user);
		
		BoardVO param = new BoardVO();
		param.setI_board(i_board);
		param.setI_user(user.getI_user());
		
		if(yn_like == 0) {
			BoardDAO.insLike(param);
		} else {
			BoardDAO.delLike(param);
		}
		
		response.sendRedirect("/board/detail?i_board=" + i_board + "&i_user=" + i_user);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
