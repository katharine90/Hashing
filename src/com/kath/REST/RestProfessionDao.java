package com.kath.REST;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kath.login.LoginServlet;
import com.kath.model.Member;

public class RestProfessionDao {
	
	private static LoginServlet loginServlet;
	private static String profession;

	public static String getUserProfession() {
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://localhost/jobsearch";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, userName, password);

			pst = conn.prepareStatement("select profession from member where username='" + loginServlet.getLoggedinUser() + "'");
			//pst = conn.prepareStatement("select profession from member where username='alice'");
			rs = pst.executeQuery();
			
			if (rs.next()) {
			profession = rs.getString("profession");
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
			
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return profession;
	}
	
	public static void main(String[] args) {
		getUserProfession();
		System.out.println(getProfession());
		
	}

	public static String getProfession() {
		return profession;
	}

	public static void setProfession(String profession) {
		RestProfessionDao.profession = profession;
	}
		
}
