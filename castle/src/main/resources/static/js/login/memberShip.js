new Vue({
  el: '#memberShip',
  data() { 
  	return {
  		data : 1
  	}
  },
  created: function () {
  	
  },
  mounted: function () {
	console.log('mounted');
  },
  methods: {
	findAdress : function(){
		new daum.Postcode({
        oncomplete: function(data) {
        	console.log(data);
        }
    	}).open();
	}
  },
  computed: {
	  
  },
  watch: {
	  
  }
})