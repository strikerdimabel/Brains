<%@page import="model.user.Role"%>
<%@page import="model.user.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Brains</title>
<link rel="stylesheet" href="<c:url value='/resources/css/Site.css' />" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css' />" />
</head>
<body>
	<div class="content-wrapper">
	<div class="my-header">
		<div class="float-left">
			<p class="site-title">Hi! Let's break your brain!</p>
		</div>
		<div class="float-right">
			<a class="btn btn-info" href="registration">Registration</a>
		</div>
		<%
			User user = (User) request.getSession().getAttribute("user");
		%>
		<c:if test="${user==null}">
			<div class="float-right">
				<a class="btn btn-info" href="login">Login</a>
			</div>
		</c:if>
		<c:if test="${user!=null}">
			<div class="float-right"><a class="btn btn-info" href="logout">Logout</a></div>
		</c:if>
		<c:if test="${user!=null}">
			<div class="float-right">${user.getLogin()}</div>
			<% if (user.getRole().equals(Role.ADMIN)) { %>
			<div class="float-right">Administrator:</div>
			<% } %>
			<% if (user.getRole().equals(Role.USER)) { %>
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
		<h3>
		Here you can solve next types of teasers:
		</h3>
		<div id="teaser-types">
		<ul>
		<li>Sudoku</li>
		<li>Snail</li>
		<li>Magic square</li>
		<li>Japan crossword</li>
		<li>Ship battle</li>
		</ul>
		</div>
		</div>
	</div>
</body>
</html>