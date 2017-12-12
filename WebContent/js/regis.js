
var url = $("#user").attr("src");




$("#userName").blur(function() {

		
		
		$.ajax({
			type : "POST",
			url : url+"/user/check.do",
			dataType : "text",
			data : {

				uname : $("#userName").val(),
			},
			success : function(data) {
				var i = data;
				
		
				
					if("用户名已存在"==i){
						
						 $("#test3").remove();  
						 $("#userName").after("<div id='test3'class='alert alert-danger' role='alert'><span class='glyphicon glyphicon-exclamation-sign'></span>"+i+"</div>"); 
						 $("#submit").attr("disabled",true);  
					} else  {
						 $("#test3").remove(); 
						 
					}
					
					if("每位用户只能注册三个账号"==i){
						 $("#test4").remove();  
						 $("#userName").after("<div id='test4'class='alert alert-danger' role='alert'><span class='glyphicon glyphicon-exclamation-sign'></span>"+i+"</div>"); 			
					} else  {
						 $("#test4").remove(); 
						
					}
					
					
					
					

			}

		})

	});

	//检验蛋疼的合法性
$("#userPwd1").blur(function() {

	var pwd_01 = $("#userPwd1").val();
	var pwd_02 = $("#userPwd2").val();

	if (pwd_01 == pwd_02) {
		 $("#test2").remove();  

	} else {
		 $("#test2").remove();  
  $("#uanswer").after("<div id='test2'class='alert alert-danger' role='alert'><span class='glyphicon glyphicon-exclamation-sign'></span>两次输入的密码不同</div>"); 
	}

});
		
		
		$("#userPwd2").blur(function() {

			var pwd_01 = $("#userPwd1").val();
			var pwd_02 = $("#userPwd2").val();

			if (pwd_01 == pwd_02) {
				 $("#test2").remove();  

			} else {
				 $("#test2").remove();  
		  $("#uanswer").after("<div id='test2'class='alert alert-danger' role='alert'><span class='glyphicon glyphicon-exclamation-sign'></span>两次输入的密码不同</div>"); 
			}

		});
	//input的值随着select的选择变化而变化

	$("#select").bind("change", function() {

		var selet = $("#select").val();
		$("#input").val(selet);

	});
	//验证合法性
	$("input").on("keyup",function(){
		
		var pwd_01 = $("#userPwd1").val();
		var pwd_02 = $("#userPwd2").val();
		if($("#uquestion").val()=="" || $("#uanswer").val() =="" 
		 || $("#userPwd1").val() =="" ||$("#userPwd2").val() ==""  
		 ||$("#userName").val() ==""||pwd_01 != pwd_02 ) {
			
			$("#submit").attr("disabled",true); 
		} else {
			

    		$("#submit").attr("disabled",false); 
		}
		
		
		
	 
    

		
		
		
		
		
		
		
		
		
		
	});
	
	