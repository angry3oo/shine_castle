<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/common/Common.jsp"%>
<!DOCTYPE html>
<html>
	<tiles:insertAttribute name="head" />
	<body class="text-center login">
		<main class="form-signin">
			<form action="/login/auth" method="POST">
				<svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-shield-lock-fill" viewBox="0 0 16 16">
				  <path fill-rule="evenodd" d="M8 0c-.69 0-1.843.265-2.928.56-1.11.3-2.229.655-2.887.87a1.54 1.54 0 0 0-1.044 1.262c-.596 4.477.787 7.795 2.465 9.99a11.8 11.8 0 0 0 2.517 2.453c.386.273.744.482 1.048.625.28.132.581.24.829.24s.548-.108.829-.24a7 7 0 0 0 1.048-.625 11.8 11.8 0 0 0 2.517-2.453c1.678-2.195 3.061-5.513 2.465-9.99a1.54 1.54 0 0 0-1.044-1.263 63 63 0 0 0-2.887-.87C9.843.266 8.69 0 8 0m0 5a1.5 1.5 0 0 1 .5 2.915l.385 1.99a.5.5 0 0 1-.491.595h-.788a.5.5 0 0 1-.49-.595l.384-1.99A1.5 1.5 0 0 1 8 5"/>
				</svg>
				<h1 class="h3 mb-3 fw-normal">Login</h1>
				<div class="form-floating">
					<input type="email" class="form-control" id="floatingInput" name="userId" placeholder="name@example.com">
					<label for="floatingInput">아이디</label>
				</div>
				<div class="form-floating">
					<input type="password" class="form-control" id="floatingPassword" name="passWord" placeholder="Password">
					<label for="floatingPassword">비밀번호</label>
				</div>
				<div class="checkbox mb-3">
					<label>
						<input type="checkbox" value="remember-me"> 아이디 저장
					</label>
				</div>
				<button class="w-100 btn btn-lg btn-primary" type="submit" onclick="formSubmit(this)">로그인</button>
				<p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>
			</form>
		</main>
	</body>
</html>