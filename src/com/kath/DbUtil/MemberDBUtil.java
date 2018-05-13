package com.kath.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.kath.login.LoginServlet;
import com.kath.model.Account;
import com.kath.model.Member;

public class MemberDBUtil {

	private Connection connection;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet result;
	private DataSource dataSource;
    private LoginServlet loginServlet;

	public MemberDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Member editProfie() {
		Member member = null;
		String sql = "SELECT * FROM member WHERE username='alice'";
		try {
			connection = dataSource.getConnection();
			stat = connection.createStatement();
			result = stat.executeQuery(sql);
			
			result = pstat.executeQuery();
			if (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String lname = result.getString("lname");
				String adress = result.getString("adress");
				String city = result.getString("city");
				String userName = result.getString("username");
				String profession = result.getString("profession");
				
				member = new Member(id, name, lname, adress, city, userName, profession);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(connection, pstat, result);
		return member;
		
	}

	public List<Member> getMembers() {
		List<Member> members = new ArrayList<>();
		String sql = "SELECT * FROM member WHERE username='" + loginServlet.getLoggedinUser() + "'";

		try {
			connection = dataSource.getConnection();
			stat = connection.createStatement();
			result = stat.executeQuery(sql);

			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String lname = result.getString("lname");
				String adress = result.getString("adress");
				String city = result.getString("city");
				String username = result.getString("username");
				String profession = result.getString("profession");

				Member member = new Member(id, name, lname, adress, city, username, profession);
				members.add(member);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		close(connection, stat, result);
		return members;
	}

	public void addMember(Member member, Account account) {
		String sql = "INSERT INTO member (name, lname, adress, city, username, profession) VALUES(?, ?, ?, ?, ?, ?)";

		try {
			connection = dataSource.getConnection();
			pstat = connection.prepareStatement(sql);
			
			pstat.setString(1, member.getName());
			pstat.setString(2, member.getlName());
			pstat.setString(3, member.getAdress());
			pstat.setString(4, member.getCity());
			pstat.setString(5, member.getUserName());
			pstat.setString(6, member.getProfession());
			pstat.execute();			
			
			createAccount(account);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		close(connection, pstat, null);

	}
	
	public void createAccount(Account account) throws SQLException {
		String accountSql = "INSERT INTO account (username, password) VALUES(?, ?)";
		pstat = connection.prepareStatement(accountSql);
		
		pstat.setString(1, account.getUsername());
		pstat.setString(2, account.getPassword());
		
		pstat.execute();
		close(connection, pstat, null);		
	}
	
	public Member getMemberId(String memberId) {
		Member member = null;
		int id;		
		id = Integer.parseInt(memberId);
		String sql = "SELECT * FROM member WHERE id=?";
		try {
			connection = dataSource.getConnection();
			pstat = connection.prepareStatement(sql);
			pstat.setInt(1, id);
			
			result = pstat.executeQuery();
			if (result.next()) {
				String name = result.getString("name");
				String lname = result.getString("lname");
				String adress = result.getString("adress");
				String city = result.getString("city");
				String username = result.getString("username");
				String profession = result.getString("profession");
				
				member = new Member(id, name, lname, adress, city, username, profession);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(connection, pstat, result);
		return member;
	}
	

	private void close(Connection connection, Statement stat, ResultSet result) {
		try {
			if (result != null) {
				result.close();
			}
			if (stat != null) {
				stat.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateMember(Member member) {
		String sql ="UPDATE member SET name=?, lname=?, adress=?, city=?, username=? profession=? WHERE id=?";
		
		try {
			connection = dataSource.getConnection();
			pstat = connection.prepareStatement(sql);
			
			pstat.setString(1, member.getName());
			pstat.setString(2, member.getlName());
			pstat.setString(3, member.getAdress());
			pstat.setString(4, member.getCity());
			pstat.setString(5, member.getUserName());
			pstat.setString(6, member.getProfession());
			pstat.setInt(6, member.getId());
			
			pstat.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(connection, pstat, null);
	}

//	public void deleteMember(String id) {
//		String sql = "DELETE FROM member WHERE id=?";
//        int memberid = Integer.parseInt(id);
//        
//        try {
//			connection = dataSource.getConnection();
//			pstat = connection.prepareStatement(sql);
//			pstat.setInt(1, memberid);
//			
//			pstat.execute();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//        
//        close(connection, pstat, null);
//	}
	
	public void deleteMember() {
		String sql = "DELETE FROM member WHERE username='" + loginServlet.getLoggedinUser() + "'";
       
        try {
			connection = dataSource.getConnection();
			stat = connection.createStatement();
			stat.executeUpdate(sql); 

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        close(connection, pstat, null);
	}
}
