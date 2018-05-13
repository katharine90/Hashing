<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="wrapper">
		<div id="header">
			<h2>List member:</h2>
		</div>
	</div>

	<div id="container">	
		<div id="content">
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Adress</th>
					<th>City</th>
					<th>Profession:</th>
					<th>Username</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="member" items="${LIST_MEMBERS}">
				
				<c:url var="tempLink" value="MemberControllerServlet"> 
				<c:param name="command" value="LOAD" />
				<c:param name="id" value="${member.id}" />
				</c:url>
				
				
					<tr>
						<td> ${member.name} </td>
						<td> ${member.lName} </td>
						<td> ${member.adress} </td>
						<td> ${member.city} </td>
						<td>${member.profession}</td>
						<td> ${member.userName}</td>

						<td> <a href="${tempLink}">Update</a> </td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>



</body>
</html>