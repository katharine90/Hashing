<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/ad-member-style.css ">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member form</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Member form</h2>
		</div>
	</div>

	<div id="container">
		<h3>Update member</h3>

		<form action="MemberControllerServlet" method="GET">

			<input type="hidden" name="command" value="UPDATE" /> <input
				type="hidden" name="id" value="${THE_MEMBER.id}" />
			<table>
				<tbody>
					<tr>
						<td><label>first name:</label></td>
						<td><input type="text" name="name" value="${THE_MEMBER.name}" /></td>
					</tr>

					<tr>
						<td><label>last name:</label></td>
						<td><input type="text" name="lname"
							value="${THE_MEMBER.lName}" /></td>
					</tr>

					<tr>
						<td><label>adress:</label></td>
						<td><input type="text" name="adress"
							value="${THE_MEMBER.adress}" /></td>
					</tr>

					<tr>
						<td><label>city:</label></td>
						<td><input type="text" name="city" value="${THE_MEMBER.city}" /></td>
					</tr>

					<tr>
						<td>choose profession:</td>
						<td><select name="profession" value="${THE_MEMBER.profession}">
								<option>Administration</option>
								<option>Bygg</option>
								<option>Hotell/ restaurang</option>
								<option>Hälso och sjukvård</option>
								<option>IT</option>
								<option>Instalation/ drift</option>
								<option>Juridik</option>
								<option>Socialt arbete</option>
								<option>Säkerhets arbete</option>
								<option>Transport</option>
						</select></td>
					</tr>
					<tr>
						<td><label>username:</label></td>
						<td><input type="text" name="username"
							value="${THE_MEMBER.userName}" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>
			</table>
		</form>

		<div style="clear: both;"></div>

		<p>
			<a href="welcome.jsp">Go back</a>
		</p>
	</div>
</body>
</html>