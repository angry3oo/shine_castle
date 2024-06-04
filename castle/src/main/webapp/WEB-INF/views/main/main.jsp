<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div>
	<h3>Vue js 예제</h3><br>
	<input type="button" value = "이동" onclick="click">
	<a href="/vue" > 전송</a>
</div>
<script type="text/javascript">
	function click(){
		console.log(1)
		debugger;
		location.href = "/vue";
	}
	
</script>
