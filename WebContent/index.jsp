<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="loginServlet" method="POST">
        <fieldset style="width: 300px">
            <legend> Login to App </legend>
            <table>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username" required="required" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="userpass" required="required" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login" /></td>
                </tr>
            </table>
        </fieldset>
    </form>
			<input type="button" value="Become a member" 
				   onclick="window.location.href='add-member-form.jsp'; return false;"
				   class="add-student-button"/>
</body>
</html>