/**
 * CSRF_TOKEN setting
 */
function CSRF_TOKEN(){
	return {
		token : $("meta[name='CSRF_TOKEN']").attr("content"),
		header : $("meta[name='CSRF_HEADER']").attr("content"),
		param : $("meta[name='CSRF_PARAM_NAME']").attr("content") 
	}
}

/**
 * common ajax
 */
function commonAjax(type, url, data, callBack){
	var that = this;
	$.ajax({
		type: type,
		url : url,			 
		data: JSON.stringify(data),
		contentType: 'application/json; charset=utf-8',
		beforeSend: function (xhr) {
	      xhr.setRequestHeader(CSRF_TOKEN().header, CSRF_TOKEN().token);
	    }, 
	 	dataType: "json",
	 	success: function (data) { 
	 		 console.log('=========commonAjax==========');
			 console.log(data);
			 console.log('=========commonAjax==========');
			 if(!that.isEmpty(callBack)){
				 callBack(data);
			 }
		},
		error: function (e) {
			
		}
	 });
}

/**
 * Form Submit
 */
function formSubmit(that) {
	var form;
	try{
		form = $('#'+that).closest('form')[0];
	}catch(e){
		form = that.closest('form');
	}
	$(form).append($('<input/>', {type: 'hidden', name: CSRF_TOKEN().param, value: CSRF_TOKEN().token }));
	$(form).submit();
}

/**
 * set Title
 */
function setTitle(title){
	document.title = title;
}

/**
 * set VueFile
 */
function setVueFile(filePath){
	var script = $('<script>')
		.attr('src', filePath);
	$("head").append(script);
}

/**
 * vueFile Check
 */
function fileCheck(url){
	var jsPath = '/js/'+url+'.js';
	fetch(jsPath, { method: 'HEAD' })
		.then(response => {
		    if (response.ok) {
		        this.setVueFile(jsPath);
		    }else{
				console.log('No Search Js File');
			} 
		})
}

/**
 * element class add
 */
function addClass(id, csName){
	var el = document.getElementById(id);
	el.className = csName;
}

/**
 * str null check
 */
function isStrEmpty(str){
	if(str != null && str.trim() != "" && str != undefined){
		return false;
	}
	return true;
}

/**
 * null check
 */
function isEmpty(e){
	if(e != null && e != undefined && e != 'undefined'){
		return false;
	}
	return true;
}

/**
 * vue vm foucs
 */
function vmFoucs(vm){
	vm.focus();
}

document.addEventListener("DOMContentLoaded", function() {
    var common = document.getElementById('common');
    if(common != null){
	    setTitle(common.getAttribute('data-title'));
	    fileCheck(common.getAttribute('data-path'));
	}
});