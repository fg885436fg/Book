
var url = $("#user").attr("src");

function firstPage() {
	// 首页
	$("#curpage").text(1);
	getbooks();
}

function nextPage(){
	// 下一页
var curpage = $("#curpage").text();

$("#curpage").text(++curpage);
 	
getbooks();
}
function endPage() {
	// 尾页
	$("#curpage").text("100000");
	getbooks();
}
		
function  previousPage() {
	// 上一页
	var curpage =  $("#curpage").text();
		if(curpage==1){
			
			getbooks();
		} else {
			$("#curpage").text(--curpage);
			getbooks();
		}
	
	

	
	
}


window.onload = function () { 
	
	getbooks();
	
	
}



function getbooks() {
	
	var url = $("#user").attr("src");
	var uid =$("#user").val();
	var curpage = $("#curpage").text();
	$.ajax({
		type : "POST",
		
		url :  url+"/bookshelves/findall.do",
		dataType : 'json',
		data : {
			curpage:curpage,
			id     :uid
		},
		beforeSend : function(){
	
			
			
								}, 
		success : function(data) {

			
			$('#table').empty();			

		    var json = eval(data);
			$.each(json, function(index, item) {
				// 循环获取数据
			
				$('#table').append(
						'<tr><th>'+
						'<a href="'+json[index].book_Adress+'" target="_blank">'+json[index].book_Name+'</a>'
						+'</th>'
						+'<th>'+json[index].book_Date	
						+'</th>'
						+'<th>'
						+json[index].book_State+
						'</th>'
						+'<th>'
						+json[index].book_Party
						+'</th>'
						+'<th>'
						+'  <button class="btn  btn-primary btn-xs"  id="'+json[index].book_Adress+'" name="delect" >删除</button>'	
						+'</th>'
					+'</tr>'
	
				
				
				);		
				
				$("#curpage").text(json[index].curPage);
				$("#count").text("总"+json[index].count+"页");
		});
			
		 
			
			delectButton();
			
			
			
		},
		error : function() {
			alert("遇到预期之外的错误。")
		}

	})
	
	
	
}



function delectButton() {
	
	
	
	
	
	
	
	
	
	
	
$("button[name='delect']").click(function() {
			
	var bookurl = $(this).attr("id");
	var uid =$("#user").val();
	
	$.ajax({
		type : "POST",
		
		url : url+"/bookshelves/delect.do"  ,
		dataType : 'text',
		data : {
			url :bookurl,
			id  :uid
			
		} ,
		beforeSend : function(){
			
			
			
		}, 
		success : function(data) {
	
			getbooks();
	
        }
	})
	
	
		
	
	
	});


}

