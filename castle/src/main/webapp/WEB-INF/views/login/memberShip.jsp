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
		           <input type="text" class="form-control" id = "id" placeholder="아이디 입력 (6~20자)" v-model="memberPackage.id">
		           <button type="button" class="btn btn-warning" @click="idCheck">중복확인</button>
		           		<div class="valid-feedback">
							사용가능한 ID 입니다.
						</div>
		                <div class="invalid-feedback">
					        이미 존재하는 ID 입니다.
					    </div>
		         </div>
            </div>
            <div class="col-12">
              <label for="passWord" class="form-label">비밀번호</label>
              <input type="text" class="form-control" placeholder="비밀번호 입력 (문자, 숫자, 특수문자 포함 8~20자)" v-model="memberPackage.passWord" required>
            </div>
            
            <div class="col-12">
              <label for="passWord" class="form-label">비밀번호 확인</label>
              <input type="text" class="form-control" placeholder="비밀번호를 다시 입력해주세요." v-model="memberPackage.passWordCheck">
            </div>

            <div class="col-sm-4">
              <label for="userName" class="form-label">이름</label>
              <input type="text" class="form-control" placeholder="이름" v-model="memberPackage.userName">
            </div>
            
            <div class="col-sm-2">
              <label for="sex" class="form-label">성별</label>
              <select class="form-select">
                <option value="">남</option>
                <option>여</option>
              </select>
            </div>
            
            <div class="col-sm-6">
              <label for="phoneNum" class="form-label">휴대폰 번호</label>
		         <div class="input-group">
		           <input type="text" class="form-control" placeholder="휴대폰 번호" v-model="memberPackage.phoneNumber">
		         </div>
            </div>
            
            <div class="col-9">
              <label for="username" class="form-label">이메일</label>
              <div class="input-group has-validation">
              	<input type="email" class="form-control" placeholder="이메일" v-model="memberPackage.email">
                <span class="input-group-text">@</span>
                <input type="text" class="form-control" placeholder="직접입력" v-model="memberPackage.doMain">
                <button type="submit" class="btn btn-secondary" @click="certificationCall">인증번호 요청</button>
              <div></div>
              </div>
            </div>
            
            <div class="col-sm-3">
              <label for="doMain" class="form-label">도메인</label>
              <select class="form-select">
                <option value="">선택</option>
                <option>naver.com</option>
                <option>gmail.com</option>
              </select>
            </div>
            
            <div class="col-sm-5">
              <label for="phoneNum" class="form-label">이메일 인증번호</label>
              <div class="input-group">
              	<input type="text" class="form-control" id="phoneNum" placeholder="인증번호">
              	<button type="button" class="btn btn-sm btn-dark">인증확인</button>
              </div>
            </div>
            
             <div class="col-sm-7">
              	<label for="userbirth" class="form-label">생년월일</label>
              	<div class="row">
	              	<div class="col-sm-4">
	              		<select class="form-select" v-model="date.selectorYear">
							<option v-for="year in date.year" :value="year">
						    	{{ year }} 년
						    </option>
						</select>
	              	</div>
	              	<div class="col-sm-4">
	              		<select class="form-select" @change="birthDayDate" v-model="date.selectorMonth">
							<option v-for="month in date.month" :value="month">
						    	{{ month }} 월
						    </option>
						</select>
	              	</div>
	              	<div class="col-sm-4">
	              		<select class="form-select" v-model="date.selectorDay">
							<option v-for="day in date.day" :value="day">
						    	{{ day }} 일
						    </option>
						</select>
	              	</div>
              	</div>
            </div>

            <div class="col-12">
              <label for="address" class="form-label">주소</label>
              <button type="button" class="btn btn-outline-info btn-sm addrClass" @click="findAdress">주소찾기</button>
              <input type="text" class="form-control" placeholder="도로명 주소" v-model="memberPackage.address">
            </div>

			<div class="col-sm-6">
              <label for="userbirth" class="form-label">우편번호</label>
              <input type="text" class="form-control" placeholder="우편번호" v-model="memberPackage.zonecode">
            </div>

			<div class="col-sm-6">
              <label for="userbirth" class="form-label">나머지 주소</label>
              <input type="text" class="form-control" placeholder="동, 호수, 호" v-model="memberPackage.roomNumber">
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