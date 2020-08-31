package com.idiot.pjt.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.idiot.pjt.ViewResolver;
import com.idiot.pjt.db.UserDAO;
import com.idiot.pjt.vo.UserVO;


@WebServlet("/join")
public class JoinSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//새로운 클래스를 만들어서 메소드를 사용. 스트링값에 주소를 넣는다
		ViewResolver.foward("user/join", request, response);
		/* 원래는 값을 전달할때 이렇게 쓰지만 계속쓰기 귀찮으므로 메소드를 만들어 사용한다.
		String jsp = "/jps/user/join.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		*/		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		//String encrypt_pw = MyUtils.encrypetString(user_pw);
		String nm = request.getParameter("nm");
		String email = request.getParameter("email");
		
		UserVO param = new UserVO();
		param.setUser_id(user_id);
		param.setUser_pw(user_pw);
		param.setNm(nm);
		param.setEmail(email);
		
		int result = UserDAO.insUser(param);
		
		if(result ==1) {
			response.sendRedirect("/login");
		}else {
			String err = "중복된 아이디입니다.";
			request.setAttribute("err", err);
			ViewResolver.foward("user/join", request, response);
		}
		
		
	}

}
