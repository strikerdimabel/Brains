<%@page import="model.user.Role"%>
<%@page import="model.user.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Brains: login</title>
<link rel="stylesheet" href="<c:url value='/resources/css/Site.css' />" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css' />" />
</head>
<body>
	<div class="content-wrapper">
	<div class="my-header">
		<div class="float-left">
			<p class="site-title">Login</p>
		</div>
		<div class="float-right">
			<a class="btn btn-info" href="registration">Registration</a>
		</div>
		<%
			User luser = (User) request.getSession().getAttribute("user");
		%>
		<c:if test="${luser!=null}">
			<div class="float-right"><a class="btn btn-info" href="logout">Logout</a></div>
		</c:if>
		<c:if test="${luser!=null}">
			<div class="float-right">${luser.getLogin()}</div>
			<% if (luser.getRole().equals(Role.ADMIN)) { %>
			<div class="float-right">Administrator:</div>
			<% } %>
			<% if (luser.getRole().equals(Role.USER)) { %>
			<div class="float-right">User:</div>
			<% } %>
		</c:if>
	</div>
		<div id="div-menu">
			<ul id="menu">
				<li><a class="choosed" href="main">Home</a></li>
				<li><a href="teasers">Teasers</a></li>
				<li><a href="rating">Rating</a></li>
				<li><a href="profile">Profile</a></li>
			</ul>
		</div>
		<div id="page-content">
		<%
			User user = (User) request.getAttribute("user");
			if (user != null) {
				out.println("<div class='alert alert-info'>Login or password incorrect</div>");
			}
		%>
		<form id="login-form" method="POST" action="login">
			<table>
				<tr>
					<td align="right">Login</td>
					<td>
					
							<input class="form-control" type="text" name="login"
								value="<%if (user != null) {
				out.println(user.getLogin());
			}%>" />
					</td>
				</tr>
				<tr>
					<td align="right">Password</td>
					<td>
							<input class="form-control" type="password" name="password"
								value="<%if (user != null) {
				out.println(user.getPassword());
			}%>" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input class="btn btn-primary"
						type="submit" value="Login" /> <input class="btn btn-primary"
						type="reset" value="Reset" /></td>
				</tr>
			</table>
		</form>
	</div>
	</div>
</body>
</html>
