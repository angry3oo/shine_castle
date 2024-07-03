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
function commonAjax(type, url, data){
	$.ajax({
		type: type,
		url : url,			 
		data: data,
		beforeSend: function (xhr) {
	      xhr.setRequestHeader(CSRF_TOKEN().header, CSRF_TOKEN().token);
	    }, 
	 	dataType: "json",
	 	success: function (data) { 
	 		 console.log('=========commonAjax==========');
			 console.log(data);
			 console.log('=========commonAjax==========');
		},
		error: function (e) {
			
		}
	 });
}

/**
 * common json ajax
 */
function commonJsonAjax(type, url, data){
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
			 console.log('=========commonJsonAjax==========');
			 console.log(data);
			 console.log('=========commonJsonAjax==========');
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
function setVueFile(contextPath, filePath){
	var vuePath = '/js/vue/';
	var script = $('<script>')
		.attr('src', contextPath+vuePath+filePath+'.js');
	$("head").append(script);
}

document.addEventListener("DOMContentLoaded", function() {
    var common = document.getElementById('common');
    setTitle(common.getAttribute('data-title'));
    setVueFile(common.getAttribute('data-context'), common.getAttribute('data-path'));
});