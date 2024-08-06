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
		           <button type="submit" class="btn btn-secondary">중복확인</button>
		         </div>
            </div>
            <div class="col-12">
              <label for="passWord" class="form-label">비밀번호</label>
              <input type="text" class="form-control" id="passWord" placeholder="비밀번호 입력 (문자, 숫자, 특수문자 포함 8~20자)" value="" required>
            </div>

            <div class="col-sm-6">
              <label for="userName" class="form-label">이름</label>
              <input type="text" class="form-control" id="userName" placeholder="이름" value="">
            </div>
            
            <div class="col-sm-6">
              <label for="userbirth" class="form-label">생년월일</label>
              <input type="text" class="form-control" id="userbirth" placeholder="생년월일" value="">
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
              <input type="text" class="form-control" id="address" placeholder="1234 Main St" required>
              <div class="invalid-feedback">
                Please enter your shipping address.
              </div>
            </div>

            <div class="col-12">
              <label for="address2" class="form-label">Address 2 <span class="text-body-secondary">(Optional)</span></label>
              <input type="text" class="form-control" id="address2" placeholder="Apartment or suite">
            </div>

            <div class="col-md-5">
              <label for="country" class="form-label">Country</label>
              <select class="form-select" id="country" required>
                <option value="">Choose...</option>
                <option>United States</option>
              </select>
              <div class="invalid-feedback">
                Please select a valid country.
              </div>
            </div>

            <div class="col-md-4">
              <label for="state" class="form-label">State</label>
              <select class="form-select" id="state" required>
                <option value="">Choose...</option>
                <option>California</option>
              </select>
              <div class="invalid-feedback">
                Please provide a valid state.
              </div>
            </div>

            <div class="col-md-3">
              <label for="zip" class="form-label">Zip</label>
              <input type="text" class="form-control" id="zip" placeholder="" required>
              <div class="invalid-feedback">
                Zip code required.
              </div>
            </div>
          </div>

          <hr class="my-4">

          <div class="form-check">
            <input type="checkbox" class="form-check-input" id="same-address">
            <label class="form-check-label" for="same-address">Shipping address is the same as my billing address</label>
          </div>

          <div class="form-check">
            <input type="checkbox" class="form-check-input" id="save-info">
            <label class="form-check-label" for="save-info">Save this information for next time</label>
          </div>

          <hr class="my-4">

          <h4 class="mb-3">Payment</h4>

          <div class="my-3">
            <div class="form-check">
              <input id="credit" name="paymentMethod" type="radio" class="form-check-input" checked required>
              <label class="form-check-label" for="credit">Credit card</label>
            </div>
            <div class="form-check">
              <input id="debit" name="paymentMethod" type="radio" class="form-check-input" required>
              <label class="form-check-label" for="debit">Debit card</label>
            </div>
            <div class="form-check">
              <input id="paypal" name="paymentMethod" type="radio" class="form-check-input" required>
              <label class="form-check-label" for="paypal">PayPal</label>
            </div>
          </div>

          <div class="row gy-3">
            <div class="col-md-6">
              <label for="cc-name" class="form-label">Name on card</label>
              <input type="text" class="form-control" id="cc-name" placeholder="" required>
              <small class="text-body-secondary">Full name as displayed on card</small>
              <div class="invalid-feedback">
                Name on card is required
              </div>
            </div>

            <div class="col-md-6">
              <label for="cc-number" class="form-label">Credit card number</label>
              <input type="text" class="form-control" id="cc-number" placeholder="" required>
              <div class="invalid-feedback">
                Credit card number is required
              </div>
            </div>

            <div class="col-md-3">
              <label for="cc-expiration" class="form-label">Expiration</label>
              <input type="text" class="form-control" id="cc-expiration" placeholder="" required>
              <div class="invalid-feedback">
                Expiration date required
              </div>
            </div>

            <div class="col-md-3">
              <label for="cc-cvv" class="form-label">CVV</label>
              <input type="text" class="form-control" id="cc-cvv" placeholder="" required>
              <div class="invalid-feedback">
                Security code required
              </div>
            </div>
          </div>
          <hr class="my-4">
          <button class="w-100 btn btn-primary btn-lg" type="submit">Continue to checkout</button>
        </form>
      </div>
    </div>
 	</main>
 </div>