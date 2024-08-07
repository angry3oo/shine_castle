<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container" style="max-width: 960px;" id="memberShip">
  <main class="memberShip">
    <div class="py-5 text-center">
      <h2>회원가입</h2>
    </div>
    <div class="row g-1">
      <div class="col-md-7 col-lg-8 rowMemberShip">
        <h4 class="mb-3">사용자 정보</h4>
        <form class="needs-validation" novalidate>
          <div class="row g-3">
          	<div class="col-12">
              <label for="id" class="form-label">아이디</label>
		         <div class="input-group">
		           <input type="text" class="form-control" placeholder="아이디 입력 (6~20자)">
		           <button type="submit" class="btn btn-warning">중복확인</button>
		         </div>
            </div>
            <div class="col-12">
              <label for="passWord" class="form-label">비밀번호</label>
              <input type="text" class="form-control" id="passWord" placeholder="비밀번호 입력 (문자, 숫자, 특수문자 포함 8~20자)" value="" required>
            </div>
            
            <div class="col-12">
              <label for="passWord" class="form-label">비밀번호 확인</label>
              <input type="text" class="form-control" id="passWord" placeholder="비밀번호를 다시 입력해주세요.">
            </div>

            <div class="col-sm-4">
              <label for="userName" class="form-label">이름</label>
              <input type="text" class="form-control" id="userName" placeholder="이름" value="">
            </div>
            
            <div class="col-sm-4">
              <label for="userbirth" class="form-label">생년월일</label>
              <input type="text" class="form-control" id="userbirth" placeholder="생년월일" value="">
            </div>
            
            <div class="col-sm-4">
              <label for="sex" class="form-label">성별</label>
              <select class="form-select">
                <option value="">남</option>
                <option>여</option>
              </select>
            </div>

            <div class="col-8">
              <label for="username" class="form-label">이메일</label>
              <div class="input-group has-validation">
              	<input type="email" class="form-control" id="email" placeholder="이메일">
                <span class="input-group-text">@</span>
                <input type="text" class="form-control" id="doMain" placeholder="직접입력">
              <div></div>
              </div>
            </div>
            <div class="col-sm-4">
              <label for="doMain" class="form-label">도메인</label>
              <select class="form-select">
                <option value="">선택</option>
                <option>naver.com</option>
                <option>gmail.com</option>
              </select>
            </div>

            <div class="col-12">
              <label for="address" class="form-label">주소</label>
              <button type="button" class="btn btn-outline-info btn-sm addrClass" @click="findAdress">주소찾기</button>
              <input type="text" class="form-control" id="address" placeholder="도로명 주소" required>
            </div>

			<div class="col-sm-6">
              <label for="userbirth" class="form-label">나머지 주소</label>
              <input type="text" class="form-control" placeholder="동, 호수, 호">
            </div>
            
            <div class="col-sm-6">
              <label for="userbirth" class="form-label">우편번호</label>
              <input type="text" class="form-control" placeholder="우편번호">
            </div>
			
			<div class="col-sm-8">
              <label for="phoneNum" class="form-label">휴대폰 번호</label>
		         <div class="input-group">
		           <input type="text" class="form-control" placeholder="휴대폰 번호">
		           <button type="submit" class="btn btn-secondary">인증번호 요청</button>
		         </div>
            </div>
			
            <div class="col-sm-4">
              <label for="phoneNum" class="form-label">인증번호</label>
              <div class="input-group">
              	<input type="text" class="form-control" id="phoneNum" placeholder="인증번호">
              	<button type="button" class="btn btn-sm btn-dark">인증확인</button>
              </div>
            </div>
          </div>
          
          <hr class="my-4">
          <button class="btn btn-primary btn-lg btnLeft40" type="submit">가입하기</button>
          <a class="btn btn-primary btn-dark btn-lg btnRight40" type="submit" href="/login">돌아가기</a>
        </form>
      </div>
    </div>
 	</main>
 </div>