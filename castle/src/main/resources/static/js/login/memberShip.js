new Vue({
  el: '#memberShip',
  data() { 
  	return {
		checkId : '',
		memberPackage : {
			id : '',
			address : '', //주소
			zonecode : '', //우편번호
			buildingName : '' //빌딩이름
		},
  		addressPackage : {}
  	}
  },
  created: function () {
  	
  },
  mounted: function () {
	
  },
  computed: {
	  
  },
  watch: {
	addressPackage : {
		handler(newValue, oldValue) {
			console.log(newValue);
			console.log(oldValue);
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
	        }
    	}).open();
	},
	idCheck : function(){
		var param = {
			userId : this.memberPackage.id
		}
		commonAjax('POST', '/login/idCheck', param, this.idCheck_callBack);
	},
	idCheck_callBack : function(result){
		if(result){
			addClass('id', 'form-control is-valid');
			this.checkId = this.memberPackage.id;
		}else{
			addClass('id', 'form-control is-invalid');
		}
	}
  }
})