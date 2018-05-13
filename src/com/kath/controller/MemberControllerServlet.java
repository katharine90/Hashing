package com.kath.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import com.kath.DbUtil.MemberDBUtil;
import com.kath.login.LoginDao;
import com.kath.model.Account;
import com.kath.model.Member;


@WebServlet("/MemberControllerServlet")
public class MemberControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberDBUtil dbUtil;
	public static String UserInlogged;
	
	@Resource(name="jdbc/JSP-Servlet-Members")
	private DataSource dataSource;
	
	@Override   // This method is called by the server when the servlet is first loaded
	public void init() throws ServletException {
		super.init();
		// create dbutil connection pool
		try {
			dbUtil = new MemberDBUtil(dataSource);
		} catch (Exception e) {
		throw new ServletException(e);
		}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		try {
			
			if (command == null) {
				command = "LIST";
			}
			switch (command) {
			case "LIST":
				listAllMembers(request, response);
				break;
			case "ADD":
				addMember(request, response);
				break;			
			case "LOAD":
				loadMember(request, response);
				break;						
			case "UPDATE":
				updateMember(request, response);
				break;	
			case "DELETE":
				deleteMember(request, response);
				break;
			default:
				listAllMembers(request, response);
				break;
			}		
			
		} catch (Exception e) {
		}

	}
	
	private void deleteMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		dbUtil.deleteMember();
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

	private void updateMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String lname = request.getParameter("lname");
		String adress = request.getParameter("adress");
		String city = request.getParameter("city");
		String username = request.getParameter("username");
		String profession = request.getParameter("profession");
		
		Member member = new Member(id, name, lname, adress, city, username, profession);
		dbUtil.updateMember(member);
		listAllMembers(request, response);
		
	}

	private void loadMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("id");
		Member member = dbUtil.getMemberId(memberId);
		
		request.setAttribute("THE_MEMBER", member);
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-member-form.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	private void addMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String lname = request.getParameter("lname");
		String adress = request.getParameter("adress");
		String city = request.getParameter("city");
		String profession = request.getParameter("profession");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Member member = new Member(name, lname, adress, city, username, profession);
		Account account = new Account(username, hashPassword(password));
		dbUtil.addMember(member, account);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}


	private void listAllMembers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> membersList = 	dbUtil.getMembers();	
		request.setAttribute("LIST_MEMBERS", membersList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-members.jsp");
		dispatcher.forward(request, response);
	}

}
