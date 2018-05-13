package com.kath.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	public static String loggedinUser;

	private static boolean checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword)) {
			System.out.println("The password matches.");
			return true;
		} else {
			System.out.println("The password does not match.");
			return false;
		}
	}

	private String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session session = request.getSession(); get login attempts for brut orce
		// attacks

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("username");
		String p = request.getParameter("userpass");
		String hashedP = hashPassword(p);

		if (checkPass(p, hashedP)) {
			System.out.println("SUCCESS!!");

			// HttpSession session = request.getSession(false);
			// if (session != null)
			// session.setAttribute("name", n);

			if (LoginDao.validate(n, p)) {
				loggedinUser = n;

				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("name", n);

				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			} else {
				out.print("<p style=\"color:red\"> Sorry username or password error</p>");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}

			out.close();
			
		} else {
			out.print("<p style=\"color:red\"> Sorry username or password error</p>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
	}

	public static String getLoggedinUser() {
		return loggedinUser;
	}

	public static void setLoggedinUser(String loggedinUser) {
		LoginServlet.loggedinUser = loggedinUser;

	}

}
