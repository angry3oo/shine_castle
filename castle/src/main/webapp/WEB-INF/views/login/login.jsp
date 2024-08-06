<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<body class="text-center login">
<div class="container" id="container">
  <div class="content">
	<div class="login_wrap">
		<ul class="panel_wrap">
			<li class="panel_item" style="display: block;">
				<form action="/login/auth" method="POST">
					<div class="panel_inner" role="tabpanel" aria-controls="loinid">
						<svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
						  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
						  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8m8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1"/>
						</svg>
						  <path fill-rule="evenodd"
								d="M8 0c-.69 0-1.843.265-2.928.56-1.11.3-2.229.655-2.887.87a1.54 1.54 0 0 0-1.044 1.262c-.596 4.477.787 7.795 2.465 9.99a11.8 11.8 0 0 0 2.517 2.453c.386.273.744.482 1.048.625.28.132.581.24.829.24s.548-.108.829-.24a7 7 0 0 0 1.048-.625 11.8 11.8 0 0 0 2.517-2.453c1.678-2.195 3.061-5.513 2.465-9.99a1.54 1.54 0 0 0-1.044-1.263 63 63 0 0 0-2.887-.87C9.843.266 8.69 0 8 0m0 5a1.5 1.5 0 0 1 .5 2.915l.385 1.99a.5.5 0 0 1-.491.595h-.788a.5.5 0 0 1-.49-.595l.384-1.99A1.5 1.5 0 0 1 8 5" /></svg>
						<h1 class="h3 mb-3 fw-normal">Login</h1>
						<div class="login_form">
							<div class="login_box">
								<div class="form-floating">
									<input type="email" class="form-control" id="floatingInput"
										name="userId" placeholder="name@example.com"> <label
										for="floatingInput">아이디</label>
								</div>
								<div class="form-floating">
									<input type="password" class="form-control"
										id="floatingPassword" name="passWord" placeholder="Password">
									<label for="floatingPassword">비밀번호</label>
								</div>
							</div>
						</div>
						<div class="input-group" style="margin-top: 20px;">
							<input type="text" class="form-control" placeholder="OTP">
							<button type="submit" class="btn btn-secondary">OTP 전송</button>
						</div>
						<div class="login_keep_wrap">
							<div class="keep_check" style="float: right;">
								<input type="checkbox" id="keep" name="nvlong"
									class="input_keep" value="off"> <label for="keep"
									class="keep_text">로그인 상태 유지</label>
							</div>
						</div>
						<div class="btn_login_wrap">
							<button type="submit" class="btn_login btn-primary btn btn-lg"
								onclick="formSubmit(this)">
								<span class="btn_text">로그인</span>
							</button>
						</div>
						<ul class="find_wrap">
							<li><a target="_blank" href="" class="find_text">비밀번호
									찾기</a></li>
							<li><a target="_blank" href="" class="find_text">아이디
									찾기</a></li>
							<li><a href="/login/memberShip"
								class="find_text">회원가입</a></li>
						</ul>
					</div>
				</form>
			</li>
		</ul>
	</div>
</div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-right">
        <h1>Hello, Friend!</h1>
        <p>Enter your personal details and start journey with us</p>
      </div>
    </div>
  </div>
</div>
</body>