<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/Common.jsp"%>
<!DOCTYPE html>
<html>
<tiles:insertAttribute name="head" />
<body class="text-center login">
	<main class="form-signin">
		<form action="/login/auth" method="POST">
			<img class="mb-4" src="/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
			<h1 class="h3 mb-3 fw-normal">Please sign in</h1>
			<div class="form-floating">
				<input type="email" class="form-control" id="floatingInput" name="username" placeholder="name@example.com">
				<label for="floatingInput">Email address</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password">
				<label for="floatingPassword">Password</label>
			</div>
			<div class="checkbox mb-3">
				<label>
					<input type="checkbox" value="remember-me"> Remember me
				</label>
			</div>
			<button class="w-100 btn btn-lg btn-primary" type="submit" onclick="formSubmit(this)">Sign in</button>
			<p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>
		</form>
	</main>
</body>
</html>