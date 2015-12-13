<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.apache.logging.log4j.Logger,org.apache.logging.log4j.LogManager" %>
<%	
	//设置返回码200，避免浏览器自带的错误页面
	response.setStatus(200);
	//记录日志
	Logger logger = LogManager.getLogger("500.jsp");
	logger.error(exception.getMessage(), exception);
%>

<!DOCTYPE html>
<html>
<head>
	<title>500 - 系统内部错误</title>
</head>

<body>
	<h2>500 - 系统发生内部错误.</h2>
</body>
</html>
