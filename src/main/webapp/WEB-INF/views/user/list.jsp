<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<h1>This is list page</h1>
	<a href="<%=path%>/user/hello">user page</a> <a href="<%=path%>/logout">logout</a>
	<table border="1" cellpadding="5px" cellspacing="1px" >
		<thead align="center">
			<tr>
				<td>序号</td>
				<td>名字</td>
				<td>性别</td>
				<td>年龄</td>
				<td>生日</td>
				<td>特性</td>
				<td>朋友</td>
			</tr>
		</thead>
		<tbody  align="center">
			<c:forEach items="${page.list}" var="user" varStatus="stat">
			<tr>
				<td>${ (page.pageNum-1) * page.pageSize + stat.index+1}</td>
				<td>${user.nickname}</td>
				<td><c:if test="${user.gender==true}">boy</c:if><c:if test="${user.gender==false}">girl</c:if></td>
				<td>${user.age}</td>
				<td><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/> </td>
				<td>${user.idiosyncrasy.name}</td>
				<td>
					<c:forEach items="${user.firends}" var="f">
						&nbsp;${f.nickname}&nbsp; 
					</c:forEach>
				</td>
			</tr>
			</c:forEach>
		</tbody>
		<tfoot>
              <tr>
                <td colspan="7">
                  <div>
                  	<c:if test="${page.pageNum>1}">
                  		<span><a href="<%=path%>/user/list?pageNo=${page.pageNum-1}">上一页</a></span>
                  	</c:if>
                  	<span>${page.pageNum}</span>
                  	<c:if test="${page.pageNum<page.pages}">
                  		<span><a href="<%=path%>/user/list?pageNo=${page.pageNum+1}">下一页</a></span>
                  	</c:if> 
                  </div>
                </td>
              </tr>
            </tfoot>
	</table>
</body>
</html>