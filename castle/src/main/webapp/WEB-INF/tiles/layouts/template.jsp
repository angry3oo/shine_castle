<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/Common.jsp"%>
<!DOCTYPE html>
<html>
	<tiles:insertAttribute name="head" />
	<body>
		<div id="common" 
			data-title="<tiles:getAsString name = "title"/>" 
			data-path="<tiles:getAsString name = "filePath"/>"
			data-context="${pageContext.request.contextPath}">
		</div>
		<%-- <input type="hidden" name="${csrfToken.parameterName}" value="${csrfToken.token}" /> --%>
		<tiles:insertAttribute name="header" />
		<div id="row" class="row" style="height: 70%; --bs-gutter-x: 0;">
			<nav class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse" style="width: 280px;">
				<tiles:insertAttribute name="leftbar" />
			</nav>
			<main class="col-md-9 ms-sm-auto col-lg-9 px-md-1" style="overflow: auto">
				<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-2 pb-2 mb-3 border-bottom">
					<h1 class="h2">소제목</h1>
				</div>
				<tiles:insertAttribute name="content" />
			</main>
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
</html>