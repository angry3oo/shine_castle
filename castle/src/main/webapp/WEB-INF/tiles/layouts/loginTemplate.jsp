<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/common.jsp"%>
<!DOCTYPE html>
<html>
	<tiles:insertAttribute name="head" />
	<body>
		<div id="common" 
			data-title="${title}" 
			data-path="<tiles:getAsString name = "filePath"/>">
		</div>
		<tiles:insertAttribute name="body" />
	</body>
</html>