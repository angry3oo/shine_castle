new Vue({
  el: '#memberShip',
  data() { 
  	return {
		checkId : '',
		date : {
			year : [],
			month : [],
			day : [],
			selectorYear : new Date().getFullYear(),
			selectorMonth : new Date().getMonth()+1,
			selectorDay : new Date().getDate()
		},
		memberPackage : {
			id : '',
			passWord : '',
			passWordCheck : '',
			userName : '',
			birth : '',
			email : '',
			doMain : '',
			phoneNumber : '',
			address : '', //주소
			zonecode : '', //우편번호
			buildingName : '', //빌딩이름
			roomNumber : '' //호수
		},
  		addressPackage : {}
  	}
  },
  created: function () {
	
  },
  mounted: function () {
	this.birthDate();
  },
  computed: {
	  
  },
  watch: {
	addressPackage : {
		handler(newValue, oldValue) {
			
	    },
	    deep: true
	  }
  },
  methods: {
	findAdress : function(){
		var that = this;
		new daum.Postcode({
	        oncomplete: function(data) {
	        	that.addressPackage = data;
	        	that.memberPackage.address = data.address;
	        	that.memberPackage.zonecode = data.zonecode;
	        	that.memberPackage.buildingName = data.buildingName;
	        }
    	}).open();
	},
	idCheck : function(){
		//아이디 벨리데이션
		var param = {
			userId : this.memberPackage.id
		}
		commonAjax('POST', '/login/idCheck', param, this.idCheck_callBack);
	},
	idCheck_callBack : function(result){
		if(result === 0){
			addClass('id', 'form-control is-valid');
			this.checkId = this.memberPackage.id;
		}else{
			addClass('id', 'form-control is-invalid');
		}
	},
	birthDate : function(){
		this.birthYearDate();
		this.birthMonthDate();
		this.birthDayDate();
	},
	birthYearDate : function(){
		var date = new Date();
		var todayYear = date.getFullYear();
		for(var i = 1950; i < todayYear+1; i++){
			this.date.year.push(i);
		}
	},
	birthMonthDate : function(){
		for(var i = 1; i < 13; i++){
			this.date.month.push(i);
		}
	},
	birthDayDate : function(){
		this.date.day = [];
		var thatMonthDay = new Date(this.date.selectorYear, this.date.selectorMonth, 0).getDate();
		for(var i = 1; i < thatMonthDay; i++){
			this.date.day.push(i);
		}
		if(thatMonthDay < this.date.selectorDay){
			this.date.selectorDay = 1;
		}
	},
	certificationCall : function(){
		if(isStrEmpty(this.memberPackage.email)){
			alert("이메일을 입력해주세요.");
			vmFoucs(this.$refs.email);
		}else if(isStrEmpty(this.memberPackage.doMain)){
			alert("도메인을 입력해주세요.");
			vmFoucs(this.$refs.doMain);
		}else{
			var param = {
				toEmail : this.memberPackage.email,
				toDoMain : this.memberPackage.doMain
			}
			commonAjax('POST', '/login/emailCheck', param, this.emailCheck_callBack);
		}
		

	},
	emailCheck_callBack : function(){
	
	}
  }
})