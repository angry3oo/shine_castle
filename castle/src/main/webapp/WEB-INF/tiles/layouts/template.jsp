<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/Common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="leftbar">
		<tiles:insertAttribute name="leftbar" />
		<div class="header">
			<tiles:insertAttribute name="header" />	
		</div>
	</div>
	<div>
		<tiles:insertAttribute name="container" />
	</div>
	<div class="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>