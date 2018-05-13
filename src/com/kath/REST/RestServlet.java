package com.kath.REST;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/restServlet")
public class RestServlet extends HttpServlet{
	
	private RestProfessionDao restProfession;

	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, java.io.IOException {
		String profession = restProfession.getUserProfession();
		String URLPath = "http://localhost:8080/api/jobs/yrkesomrade=";
		response.sendRedirect(response.encodeRedirectURL(URLPath + profession));
	}

}
