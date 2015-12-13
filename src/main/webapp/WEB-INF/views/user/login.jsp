<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="<%=path%>/static/default.css">
<title>SSM Demo</title>
</head>
<body>
	<h1>This SSM demo login page</h1>
	<form action="login" method="post">
		<table border="1" cellpadding="5px" cellspacing="0px">
			<tr>
				<td>账号：<input type="text" name="username" tabindex="1" /></td>
			</tr>
			<tr>
				<td>密码：<input type="password" name="password" maxLength="20" tabindex="2"></td>
			</tr>
			<tr>
				<td><input type="submit" tabindex="4" value="登录" /></td>
			</tr>
			<tr></tr>
		</table>
	</form>
</body>
</html>