new Vue({
  el: '#c',
  data() { 
  	return {
  		data : 1
  	}
  },
  created: function () {
  	console.log('created');
  	console.log(window);
  },
  mounted: function () {
	console.log('mounted');
  },
  methods: {
   
  },
  computed: {
	  
  },
  watch: {
	  
  }
})