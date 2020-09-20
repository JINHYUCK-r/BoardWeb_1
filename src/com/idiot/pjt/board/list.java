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
import com.idiot.pjt.MyUtils;
import com.idiot.pjt.ViewResolver;
import com.idiot.pjt.db.BoardDAO;
import com.idiot.pjt.vo.BoardVO;

/**
 * Servlet implementation class list
 */
@WebServlet("/board/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//get이 보내주는
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션을 등록해준다.
		HttpSession hs = request.getSession();
		if(hs.getAttribute(Const.Login_user)==null) {
			response.sendRedirect("/login");
			return; 
		}
		List<BoardVO> list  = new ArrayList();
		
		
		BoardVO param = new BoardVO();
		//페이징
		int recordCnt = 5; //한페이지에 보여줄 숫자 
		param.setRecordCnt(recordCnt);  // 파람값에 등록하여 boarddao에서 활용
		
		int page=MyUtils.parseInt("page", request);	//boardlist에서 넘어온 page
		page = page == 0 ? 1: page;
		
		int pagingCnt = BoardDAO.cntPage(param);
		
		request.setAttribute("pagingCnt", pagingCnt);
		
		int eIdx = page * recordCnt;
		int sIdx = eIdx - recordCnt;
		param.seteIdx(eIdx);	// 한페이지에서 보여주는 글의 끝번
		param.setsIdx(sIdx);	// 한페이지에서 보여주는 글의 끝번
		
		
		list = BoardDAO.selBoardList(param);
		
		
		
		
		request.setAttribute("list", list);
		
		ViewResolver.foward("/board/boardList", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
