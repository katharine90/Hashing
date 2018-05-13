package com.kath.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/JSP-Servlet-Members")
	private DataSource dataSource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		Connection con = null;
		Statement stat = null;
		ResultSet result = null;
		String sql = "SELECT * FROM member";
		try {
			con = dataSource.getConnection();
			stat = con.createStatement();
			result = stat.executeQuery(sql);
			
			while (result.next()) {
				String name = result.getString("name");
				out.println(name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
