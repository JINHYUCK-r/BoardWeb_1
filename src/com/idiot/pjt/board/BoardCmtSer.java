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
import com.idiot.pjt.db.BoardCmtDAO;
import com.idiot.pjt.vo.BoardCmtVO;
import com.idiot.pjt.vo.UserVO;

/**
 * Servlet implementation class BoardCmtSer
 */
@WebServlet("/board/cmt")
public class BoardCmtSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs = request.getSession();
		UserVO user = (UserVO) hs.getAttribute(Const.Login_user);

		
		String strI_cmt = null;
		try {
			
		strI_cmt = request.getParameter("i_cmt");
		
		}catch(Exception e) {
			int i_cmt = 0;
		}
		
		int i_cmt = Integer.parseInt(strI_cmt);
		String cmt = request.getParameter("cmt");
		String strI_board = request.getParameter("i_board");
		int i_board = Integer.parseInt(strI_board);
		
   
    	BoardCmtVO param = new BoardCmtVO();
    	param.setI_cmt(i_cmt);
    	param.setI_user(user.getI_user());
    	
    	System.out.println(i_cmt);
    	System.out.println(user.getI_user());
    	
    	int result = BoardCmtDAO.delCmt(param);
    	response.sendRedirect("/board/detail?i_board=" + i_board  + "&i_user=" + user.getI_user());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strI_cmt = null;
		try {
			
		strI_cmt = request.getParameter("i_cmt");
		
		}catch(Exception e) {
			int i_cmt = 0;
		}
		
		int i_cmt = Integer.parseInt(strI_cmt);
		String cmt = request.getParameter("cmt");
		String strI_board = request.getParameter("i_board");
		int i_board = Integer.parseInt(strI_board);
		System.out.println(i_board);
		String strI_user = request.getParameter("i_user");
		int i_user = MyUtils.parseInt(strI_user, request);
		
		UserVO loginUser = MyUtils.getLogtinUser(request);
		
		BoardCmtVO param = new BoardCmtVO();
		param.setI_board(i_board);
		param.setI_user(loginUser.getI_user());
		param.setCmt(cmt);
		
		switch(strI_cmt) {
		case "0" : //등록
			//System.out.println(param.getI_board());
			//System.out.println(param.getI_user());
			//System.out.println(param.getCmt());
			BoardCmtDAO.insCmt(param);
			break;
		default: //수정
			param.setI_cmt(i_cmt);
			BoardCmtDAO.updCmt(param);
			break;
		}
		
		response.sendRedirect("/board/detail?i_board="+i_board+"&i_user="+i_user);
		
	}

}
