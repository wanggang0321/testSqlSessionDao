<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head>

<body>

	下面展示的是后台获取的国际化信息：<br/>
    ${money}<br/>
    ${date}<br/>
	
	下面展示的是视图中直接绑定的国际化信息：<br/>
    <spring:message code="money"/>:<br/>
    <spring:eval expression="contentModel.money"></spring:eval><br/>
    <spring:message code="date"/>:<br/>
    <spring:eval expression="contentModel.date"></spring:eval><br/>
    
</body>
</html>
