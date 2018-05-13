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
		<h3>Add new member</h3>

		<form action="MemberControllerServlet" method="GET">

			<input type="hidden" name="command" value="ADD" />

			<table>
				<tbody>
					<tr>
						<td><label>first name:</label></td>
						<td><input type="text" name="name" /></td>
					</tr>

					<tr>
						<td><label>last name:</label></td>
						<td><input type="text" name="lname" /></td>
					</tr>

					<tr>
						<td><label>adress:</label></td>
						<td><input type="text" name="adress" /></td>
					</tr>

					<tr>
						<td><label>city:</label></td>
						<td><input type="text" name="city" /></td>
					</tr>
					    <td><label>Choose your profession:</label></td>
						<td><select name="profession">
						<option>Administration</option>
						<option>Bygg</option>
						<option>Hotell/ restaurang</option>
						<option>Hälso och sjukvård </option>
						<option>IT</option>
						<option>Instalation/ drift</option>
						<option>Juridik</option>
						<option>Socialt arbete</option>
						<option>Säkerhets arbete</option>
						<option>Transport</option>
						</select></td>
					<tr>
					<tr>
						<td><label>choose username:</label></td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td><label>choose password:</label></td>
						<td><input type="password" name="password" /></td>
					</tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>
			</table>
		</form>

		<div style="clear: both;"></div>

		<p>
			<a href="index.jsp">Back to main page</a>
		</p>
	</div>
</body>
</html>