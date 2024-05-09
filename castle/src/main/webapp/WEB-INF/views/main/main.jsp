<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Enumeration" %>


<h2>home</h2><br>
<h2>Main</h2>
<h2>Main</h2>
<h2>Main</h2>

<h2>Main</h2>



<h2>Main</h2>

<h2>Main</h2>
<h2>Main</h2>

<h2>Main</h2>

<h2>Main</h2>

<h2>Main</h2>

<h2>Main</h2>
<h2>Main</h2>
<h2>Main</h2>

<h2>Main</h2>

<h2>SSEEE</h2>
<form action="/test" id="test" method="post">
	<input type="text" name="input"><br>
	<input type="button" onclick="formSubmit('test')" value="TEST">
</form>
<%
Enumeration names = session.getAttributeNames();
	while(names.hasMoreElements()){
		String name = names.nextElement().toString();
		String value = session.getAttribute(name).toString();
		out.println(name + " <br> " + value + "<br>");
	}
	%>
<script type="text/javascript">

	window.onload = function() {
		var token = $("meta[name='CSRF_TOKEN']").attr("content");
		var header = $("meta[name='CSRF_HEADER']").attr("content");
		var header = $("meta[name='CSRF_PARAM_NAME']").attr("content");
		var input = $("input[name='csrfToken']").val();
		console.log(token);
		console.log(header);
		console.log(input);
		console.log(CSRF_TOKEN().token);
		
		
		
	}
</script>
