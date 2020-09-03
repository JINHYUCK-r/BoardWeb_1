package com.idiot.pjt.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.idiot.pjt.Const;
import com.idiot.pjt.ViewResolver;
import com.idiot.pjt.db.UserDAO;
import com.idiot.pjt.vo.UserVO;


@WebServlet("/login")
public class LoginSer extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

	
	//출력용도로 많이 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		
		if(hs.getAttribute(Const.Login_user)!=null) {
			response.sendRedirect("/board/list");
			//return으로 jsp를 끝내주어야함.
			return;
		}
		
		ViewResolver.foward("/user/login", request, response);
		
	}

	//폼형식을 받아와서 데이터베이스 처리할때 많이 쓰
	//입력받은 아이디와비밀번호 정보를 가져와서UserVO 객에다가 값을 넘긴다.
	//UserDAO의 chkUser라를 함수를 만들어서 받아온 아이디와 비밀번호를 데이터베이스에서 비교한다.
	// 비교 결과의 값을 result로 받아서 각 결과에 맞게 조건을 뿌려준다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String user_id = request.getParameter("user_id");
			String user_pw = request.getParameter("user_pw");
			
			UserVO param = new UserVO();
			param.setUser_id(user_id);
			param.setUser_pw(user_pw);
			
			int result = UserDAO.chkUser(param);
			System.out.println(result);
			
			String err = "";
			
			HttpSession hs = request.getSession();
			
			if(result ==0) {
				//조건에 맞추어 문자열을 입력받아서 setAttribut에 담아 
				//로그인 폼의 $msg},${user_id}에 뿌려준다. EL식 
				err= "아이디가 존재하지 않습니다.";
				request.setAttribute("msg", err);
				ViewResolver.foward("/user/login", request, response);
				//위에 doGet에 같은것이 있기때문에 doGet(response,request)로 적어줘도 된다.
				
			}else if(result ==2) {
				err= "비밀번호가 틀렸습니다.";
				request.setAttribute("msg", err);
				request.setAttribute("user_id", user_id);
				ViewResolver.foward("/user/login", request, response);
			}else if(result ==1) {
				//로그인가능/ 게시판으로 이동 
				
				
				//hs.setAttribute("user", param);
				//이렇게 쓰면 오타가 생기거나 오류가 생길수 있기 때문에새롭게만들어 사용한다.
				hs.setAttribute(Const.Login_user, param);
				response.sendRedirect("/board/list");
			}
			
			
;	}

}
