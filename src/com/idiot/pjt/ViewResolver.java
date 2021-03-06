package com.idiot.pjt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver extends HttpServlet {

	public static void foward(String fileNm, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = String.format("/jsp/%s.jsp", fileNm);
		request.getRequestDispatcher(jsp).forward(request, response);
	}
}
