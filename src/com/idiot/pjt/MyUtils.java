package com.idiot.pjt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.idiot.pjt.vo.UserVO;


//세션 받는 메소드 구현.
public class MyUtils {
	public static UserVO getLogtinUser(HttpServletRequest request) {
		HttpSession hs = request.getSession();
		UserVO vo = new UserVO();
		vo = (UserVO)hs.getAttribute(Const.Login_user);
		return vo;
	}
}
