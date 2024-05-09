<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/Common.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="CSRF_TOKEN" content="${csrfToken.token}"/>
	<meta name="CSRF_HEADER" content="${csrfToken.headerName}"/>
	<meta name="CSRF_PARAM_NAME" content="${csrfToken.parameterName}"/>
	
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%-- <input type="hidden" name="${csrfToken.parameterName}" value="${csrfToken.token}" /> --%>
	<tiles:insertAttribute name="header" />
	<div id="row" class="row" style="height: 70%; --bs-gutter-x: 0;">
		<nav class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse" style="width: 280px;">
			<tiles:insertAttribute name="leftbar" />
		</nav>
		<main class="col-md-9 ms-sm-auto col-lg-9 px-md-1" style="overflow: auto">
			<tiles:insertAttribute name="content" />
		</main>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>