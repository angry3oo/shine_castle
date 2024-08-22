new Vue({
  el: '#memberShip',
  data() { 
  	return {
		id : '',
  		addressPackage : {},
  		address : '', //주소
  		zonecode : '', //우편번호
  		buildingName : '' //빌딩이름
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
			userId : this.id
		}
		commonAjax('POST', '/login/idCheck', param)
	}
  }
})