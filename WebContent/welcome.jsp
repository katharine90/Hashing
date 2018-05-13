<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body>

<body>
    <h3>Login successful!!!</h3>
    <h4>Hello,  <%=session.getAttribute("name")%></h4>
    <br><br><br>
    
    			<c:url var="listLink" value="MemberControllerServlet"> 
				<c:param name="command" value="LIST" />
				<c:param name="id" value="${member.id}" />
				</c:url>
				
				<c:url var="deleteLink" value="MemberControllerServlet"> 
				<c:param name="command" value="DELETE" />
				</c:url>
				
				 <a href="restServlet">Find me a job</a>
				 <a href="${listLink}">Update profile info</a>
				 <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete?'))) return false ">Delete profile</a>
				 <a href="logoutServlet">Log out</a>
				 
    
</body>

</body>
</html>