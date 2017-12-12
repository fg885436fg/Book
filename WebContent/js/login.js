var url = $("#user").attr("src");

$("#yourName").blur(function() {


	$.ajax({
		type : "POST",
		url : url+"/user/checkname.do",
		dataType : "text",
		data : {

			yourName : $("#yourName").val(),
		},
		success : function(data) {
			var i = data;
			
	
			
				if("用户名不存在"==i){
					
					$("#test3").remove();  
					$("#yourName").after("<div id='test3'class='alert alert-danger' role='alert'><span class='glyphicon glyphicon-exclamation-sign'></span>"+i+"</div>"); 
					
				} else  {
					$("#test3").remove(); 
					 
				}

		}

	});
	
	
	






});



$("#yourAnswer").blur(function() {
	
	getpassword();
	
	
});


$("#yourPassword").click(function() {
	
	getpassword();
	
	
});



function getpassword() {
	
	

	$.ajax({
		type : "POST",
		url : url+"/user/getpassword.do",
		dataType : "json",
		data : {

			yourName :    $("#yourName").val(),
			yourQuestion: $("#yourQuestion").val(),
			yourAnswer :  $("#yourAnswer").val()
		},
		beforeSend : function(){
		
			$("#yourPassword").attr("placeholder","请稍等，正在接收数据");
				
									}, 
		success : function(data) {
			$("#yourPassword").attr("placeholder","输入正确答案，再点我，这里就显示密码");
		    var user = eval(data);
	
			
		    if(user.uanswer=="答案与问题不匹配。"||user.uanswer=="用户名不存在，请检查。") {
		    	
		    	$("#test4").remove();  
		    	$("#yourAnswer").after("<div id='test4'class='alert alert-danger' role='alert'><span class='glyphicon glyphicon-exclamation-sign'></span>"+user.uanswer+"</div>"); 
		    	return null;
		    } 
		    
			$("#yourPassword").attr("placeholder",user.upwd);
		    
		    
		    

		}
	
		
		
		

	});
	
	
	
	
	
}



