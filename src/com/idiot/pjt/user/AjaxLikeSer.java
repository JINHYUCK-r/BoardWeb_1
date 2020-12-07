package com.idiot.pjt.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.idiot.pjt.Const;
import com.idiot.pjt.db.BoardDAO;
import com.idiot.pjt.vo.BoardVO;
import com.idiot.pjt.vo.UserVO;

/**
 * Servlet implementation class AjaxLikeSer
 */
@WebServlet("/AjaxLikeSer")
public class AjaxLikeSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Ajax에서 넘어온 데이터 처리 
		HttpSession hs = request.getSession();
		UserVO user = (UserVO) hs.getAttribute(Const.Login_user);


		String strI_board = request.getParameter("i_board");		
		int i_board = Integer.parseInt(strI_board);	
		
		String strLike = request.getParameter("yn_like");
		int yn_like = Integer.parseInt(strLike);
	
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
	
		
		BoardVO vo = BoardDAO.selBoardDetail(param);
		
		//Gson을 활용하요 json데이터로 정송해서 res로 사
		Gson gson = new Gson();
		
		String json = gson.toJson(vo);
		
		//System.out.println("json : " + json);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(json);
		
		//response.sendRedirect("/board/detail?i_board=" + i_board + "&i_user=" + i_user);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


}
