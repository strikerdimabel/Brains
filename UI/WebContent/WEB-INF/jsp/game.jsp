<%@page import="model.teaser.TeaserType"%>
<%@page import="model.teaser.TeaserInfo"%>
<%@page import="model.teaser.SudokuTeaserCondition"%>
<%@page import="model.GameModel"%>
<%@page import="model.teaser.TeaserCondition"%>
<%@page import="java.util.Enumeration"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game</title>
<link rel="stylesheet" href="<c:url value='/resources/css/Site.css' />" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css' />" />
<script src="/resources/js/jquery-1.10.2.js"></script>
<script src="/resources/js/app.js"></script>
</head>
<body>
	<div class="content-wrapper">
		<div class="float-left">
			<p class="site-title">Do it!</p>
		</div>
		<div class="float-right">
			<a class="btn btn-info" href="registration">Registration</a>
		</div>
		<div class="float-right">
			<a class="btn btn-info" href="login">Login</a>
		</div>
		<div id="div-menu">
			<ul id="menu">
				<li><a class="choosed" href="../main">Home</a></li>
				<li><a href="../teasers">Teasers</a></li>
				<li><a href="../rating">Rating</a></li>
				<li><a href="../profile">Profile</a></li>
			</ul>
		</div>
		<div class="game">
		<%
			TeaserInfo teaserInfo = ((GameModel) request.getAttribute("game"))
					.getTeaserInfo();
			switch (teaserInfo.getTeaserType()) {

				case SUDOKU : {
		%>
		<table class="sudoku">
			<%
				SudokuTeaserCondition cnd = (SudokuTeaserCondition) ((GameModel) request
								.getAttribute("game")).getCnd();
						for (int i = 0; i < cnd.getSize(); i++) {
			%><tr class="">
				<%
					for (int j = 0; j < cnd.getSize(); ++j) {
				%>
				<td class="<%
						if (cnd.get(i, j) != 0) {
											out.print("cnd");
										}
					%>">
					<%
						if (cnd.get(i, j) != 0) {
											out.print(cnd.get(i, j));
										}
					%>
				</td>
				<%
					}
				%>
			</tr>
			<%
				}
			%>

		</table>
		<script type="text/javascript">
			drawSudoku();
		</script>

		<%
				break;}
				}
		%>
		</div>
	</div>
</body>
</html>
