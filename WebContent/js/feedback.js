
var url = $("#user").attr("src");


$(function(){
	//验证合法性
	var name = $("#user").attr("class");
	if(name!="fg885436fg") {
		
		location.href = url+"/views/table.jsp";
		
	}
	
	
	//获取所有的反馈
	findAll();
})



function findAll() {
	
	$.ajax({
		type : "POST",
		url : url+"/feedback/findAlltFeedback.do",
		dataType : 'json',
		data : {
			
	
		},
		beforeSend : function(){
		$('#list').empty();
		$('#list').append("<p>数据加载中......</p>");	
			
			
								}, 
		success : function(data) { 
		$('#list').empty();			

		    var json = eval(data);

			$.each(json, function(index, item) {
						// 循环获取数据
						
					    var $tr =$('<tr class="error">'+
					    		'<td>'+json[index].id +'</td>' +
					    		'<td>'+json[index].bookname +'</td>'+
					    		'<td><a href="'+json[index].book_url +'" target="_blank">'+json[index].book_url +'</a></td>'+
					    		'<td>'+json[index].text +'</td>'+
					    		'<td>'+json[index].date +'</td>'+
					    		'<td>'+json[index].ip +'</td>'+
					    		'<td>'+
					    		' <button name="update" class="btn btn-primary btn-small" id="'+json[index].book_url +'" data-toggle="modal" type="button" data-target="#myModal">'+
					    		'修改 </button>'+
					    		'</td>'+
					    		'<td>'+
					    		'<button name="delect" id="'+json[index].id +'" class="btn btn-danger btn-small" type="button">'+
					    		'删除</button>'+
					    		'</td>'+
					    		'</tr>');
					
					 
						$('#list').append($tr);	
						
						
				});
			
			addButton();

		},
		error : function() {
			console.log('error');
		}

	})
	
	
	}




function addButton() {
	//给按钮绑定事件
	
	$("button[name='update']").click(function(e){

		bookUrl=$(e.target).attr("id");

		$.ajax({
			type : "POST",
			url : url+"/book/findOneBook.do",
			dataType : 'json',
			data : {
		
				url     :bookUrl
			},
			beforeSend : function(){
		
		
									}, 
			success : function(data) {

			
				$("#bookName").val(data.book_Name);
				$("#partySelect").val(data.book_Party);
				$("#bookUrl").val(data.book_Adress);
				$("#stateSelect").val(data.book_State);
				
			    

				

			},
			error : function() {
				alert("遇到预期之外的错误。")
			}

		})

		
		

		
		
	});
	
	
	
	
	$("button[name='delect']").click(function(e){

		id=$(e.target).attr("id");

		$.ajax({
			type : "POST",
			url : url+"/feedback/delectFeedback.do",
			dataType : 'text',
			data : {
		
				id    :id
			},
			beforeSend : function(){
		
					
				
									}, 
			success : function(data) {

				findAll();

			},
			error : function() {
				alert("遇到预期之外的错误。")
			}

		})

		
		

		
		
	});
	
	
	
	$("button[name='updateBook']").click(function(e){




		$.ajax({
			type : "POST",
			url : url+"/book/updateBook.do",
			dataType : 'text',
			data : {
		
				
			},
			beforeSend : function(){
		
						
				
									}, 
			success : function(date) {

			
				alert(date);
			    

				

			},
			error : function() {
				
			}

		})

		
		

		
		
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

