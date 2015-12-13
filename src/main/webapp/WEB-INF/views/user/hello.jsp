<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
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
	<h1>Hello ${user.nickname} this detail page</h1>
	<a href="<%=path%>/user/list">list page</a> <a href="<%=path%>/logout">logout</a>
	
	<table border="1" cellpadding="5px" cellspacing="1px">
		<thead align="center">
			<tr>
				<td>昵称</td>
				<td>性别</td>
				<td>年龄</td>
				<td>生日</td>
				<td>特征</td>
				<td>朋友</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody align="center">
			<tr>
				<td>${user.nickname}</td>
				<td>
					<c:if test="${user.gender==true}">boy</c:if>
				 	<c:if test="${user.gender==false}">girl</c:if>
				</td>
				<td>${user.age}</td>
				<td><fmt:formatDate value="${user.birthday}"
						pattern="yyyy-MM-dd" /></td>
				<td>${user.idiosyncrasy.name}</td>
				<td>
					<c:forEach items="${user.firends}" var="f">
						&nbsp;${f.nickname}&nbsp; 
					</c:forEach>
				</td>
				
				<td><a>查看</a> <shiro:hasAnyRoles name="admin,manager">
						<a>修改</a>
					</shiro:hasAnyRoles> <shiro:hasAnyRoles name="admin">
						<a>删除</a>
					</shiro:hasAnyRoles></td>
			</tr>
		</tbody>
	</table>
</body>
</html>