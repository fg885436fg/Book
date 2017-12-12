var url = $("#user").attr("src");

// 各类选择
$("#choose ul").on("click","li", function(e) {

			var li = $(e.target);

			if (li.index() == 0) {
				return
			} else if (li.hasClass("active")) {
				return
			} else {

				li.addClass("active").siblings("li.active").removeClass();
				// ajax
				$("#searchinput").val("");
				$("#curpage").val(1);
				ajaxfor();
			

			}

		});

		
function ajaxfor() {

	
	var url = $("#user").attr("src");
	
	if($("#searchinput").val() == "") {
		
		
	
		$.ajax({
			type : "POST",
			url : url+"/book/findbooks.do",
			dataType : 'json',
			data : {
				
				party : $('li').siblings(".active").eq(1).attr("id"),// party
				order : $('li').siblings(".active").eq(2).attr("id"),// order
				state : $('li').siblings(".active").eq(3).attr("id"),// state
				words : $('li').siblings(".active").eq(4).attr("id"),// words
				leibie : $('li').siblings(".active").eq(5).attr("id"),//传入类别至后台
				curpage :$("#curpage").val()// curpage
			},
			beforeSend : function(){
			$('#bookList').empty();
			$('#bookList').append("<p>数据加载中......</p>");	
				
				
									}, 
			success : function(data) { 
			$('#bookList').empty();			

			    var json = eval(data);

				$.each(json, function(index, item) {
							// 循环获取数据
							var Name = json[index].book_Name;
						    var $li =$('<li><a><img src="'+json[index].book_Url+'" alt="images/gay.png"/></a></li>');
							$li.append('<div><ul><li class="title"><span class="lily">' +json[index].book_State+							
									'</span>'  +'   <span class="lily">'+json[index].book_Party+'</span>'+
									'<a href="'+url+"/score/login.do?bookId="+json[index].bookId+'"class="title" target="_blank">'+json[index].book_Name+'</a>'+
'<select id="'+json[index].book_Adress+'" class="feedback" onchange="fankui(this.id,this.value)" >'+
'<option value="反馈点这里">反馈点这里</option>'+  
'<option value="此书是变百">此书是变百</option>' +
'<option value="此书是变嫁">此书是变嫁</option>' +
'<option value="此书非变文">此书非变文</option>' +
'<option value="此书取向不明">此书取向不明</option>'+
'<option value="此书未完结">此书未完结</option>'+
'<option value="此书已完结">此书已完结</option> </select>'+
									' <span class="lily"><a  class="'+json[index].book_Adress+'"name="addBook">收藏</a></span></li>' +
									'<li class="desc"><span title="'+json[index].book_Msg+'">'+json[index].book_Msg +
									'</span></li>' +
									' <li class="info">'+
'<span><i class="fa fa-edit"></i>'+json[index].book_Words +' 字</span>'+
'<span><i class="fa fa-clock-o"></i>'+json[index].book_Date+'</span>' +
'<span><i class="fa fa-address-card"></i>作者：'+json[index].book_Author+'</span>' +
'</li>' +
' <li class="tags"> <span><i class="fa fa-tags"></i>'+json[index].book_Tag+' </span> </li>'	+								

									'</ul></div>');
						
							$('#bookList').append($li);	
							$('#curpage').val(json[index].curPage);
							$('#count').text(json[index].count);
							
					});
				
				addbooks();

			},
			error : function() {
				console.log('error');
			}

		})
		
		
		
		
		
	} else {
		
		search();
		
	}
		
		
		
	
}







	function fankui(adress,value) {

 ajax("post",url+"/feedback/saveFeedback.do","url="+adress+"&text="+value);
    };	
		
		
    
    
    
    
    
    
$(".button").click(function() {
			
	ajaxfor();
			
		
	});
	
	
$("#add").click(function() {
			
		
			   var  text =  $("#text").val();// 所添加书的书名或者是地址
			 
			 
			   	$.ajax({
					type : "POST",
					url : url+"/book/addBook.do",
					dataType : 'text',
					data : {
						
						text :text,// party
					
					},
					beforeSend : function(){
		
						
						
											}, 
					success : function(data) { 
						
						alert(data);
					
					},
					error : function() {
						
						alert("添加成功");
					}

				})
	       
			       
			       
			 
	
			 
			 
		
	});



	
	
function firstPage() {
	// 首页
	$("#curpage").val(1);
	ajaxfor();
}

function nextPage(){
	// 下一页
var curpage = $("#curpage").val();

 	document.getElementById("curpage").value = ++curpage;
 	ajaxfor();

}
function endPage() {
	// 尾页
	$("#curpage").val("100000");
	ajaxfor();
}
		
function  previousPage() {
	// 上一页
	var curpage =  $("#curpage").val();
		if(curpage==1){
			
			ajaxfor();
		} else {
			 document.getElementById("curpage").value = --curpage;
			 ajaxfor();
		}
	
	

	
	
}

	// 开关遮罩层
$(".nav_r").on("click", function() {
			$(".mask-background").css("display", "block").css("opacity", "1");
		});
$(".close-mask").on("click", function() {
			$(".mask-background").css("opacity", "0").css("display", "none");
		});




// 搜索框js

$("#searchinput").keyup(function(event){
	
	  if(event.keyCode ==13){
		  search();
	  }
	});




$("#search").click(function(){

	
	search();
});

function search(){
	
	var url = $("#user").attr("src");
	$.ajax({
		type : "POST",
		url :  url+"/book/search.do",
		dataType : 'json',
		data : {
			
			word : $("#searchinput").val(),
			curpage :$("#curpage").val()// curpage
		},
		beforeSend : function(){
		$('#bookList').empty();
		$('#bookList').append("<p>数据加载中..........</p>");	
			
			
								}, 
		success : function(data) {
		$('#bookList').empty();			

		    var json = eval(data);
		    
		    
		    
			$.each(json, function(index, item) {
				
				      
						// 循环获取数据
						var Name = json[index].book_Name;
					    var $li =$('<li><a><img src="'+json[index].book_Url+'" alt="images/gay.png"/></a></li>');
						$li.append('<div><ul><li class="title"><span class="lily">' +json[index].book_State+							
								'</span>'  +'   <span class="lily">'+json[index].book_Party+'</span>'+
								'<a href="'+url+"/score/login.do?bookId="+json[index].bookId+'"class="title" target="_blank">'+json[index].book_Name+'</a>'+
'<select id="'+json[index].book_Adress+'" class="feedback" onchange="fankui(this.id,this.value)" >'+
'<option value="反馈点这里">反馈点这里</option>'+  
'<option value="此书是变百">此书是变百</option>' +
'<option value="此书是变嫁">此书是变嫁</option>' +
'<option value="此书非变文">此书非变文</option>' +
'<option value="此书取向不明">此书取向不明</option>'+
'<option value="此书未完结">此书未完结</option>'+
'<option value="此书已完结">此书已完结</option> </select>'+
								' <span class="lily"><a  class="'+json[index].book_Adress+'"name="addBook">收藏</a></span></li>' +
								'<li class="desc"><span title="'+json[index].book_Msg+'">'+json[index].book_Msg +
								'</span></li>' +
								' <li class="info">'+
'<span><i class="fa fa-edit"></i>'+json[index].book_Words +' 字</span>'+
'<span><i class="fa fa-clock-o"></i>'+json[index].book_Date+'</span>' +
'<span><i class="fa fa-address-card"></i>作者：'+json[index].book_Author+'</span>' +
'</li>' +
' <li class="tags"> <span><i class="fa fa-tags"></i>'+json[index].book_Tag+' </span> </li>'	+								

								'</ul></div>');
					
						$('#bookList').append($li);	
						$('#curpage').val(json[index].curPage);
						$('#count').text(json[index].count);
				});
			
			
			//给收藏按钮绑定事件
			addbooks();
		
			

		},
		error : function() {
			$('#bookList').empty();
			$('#bookList').append("<p>没找到呢</p>");	
		}

	})
	
	
	
	
	
} 





$("a[name='addBook']").click(function(e){

	var uid =$("#user").val();
	var uname=$("#user").attr("class");
	var party= $("#user").attr("name");
	var url = $("#user").attr("src");
	var cc="http://www.54tushu.com/book_library/bookshow/theId/33.html";
	if(uid==="") {
		alert('非用户无法收藏');
		return null;
	}
	
	if($(this).attr("class")==cc) {
		
		alert("此书仅用于展览使用，好吧，其实是爬取程序不支持此书所在网站，为防止BUG，所以我就不给你收藏咯。");
		return null;
	}
	
	

	$.ajax({
		type : "POST",
		url : url+"/bookshelves/add.do",
		dataType : 'text',
		data : {
			
			url : $(this).attr("class"),//
			uid     :uid
		},
		beforeSend : function(){
	
			
			
								}, 
		success : function(data) {

		    alert("收藏成功。");

			

		},
		error : function() {
			alert("遇到预期之外的错误。")
		}

	})

	
	

	
	
});


function addbooks() {
	
	//给收藏按钮绑定
	$("a[name='addBook']").click(function(e){

		var uid =$("#user").val();
		var uname=$("#user").attr("class");
		var party= $("#user").attr("name");
		var url = $("#user").attr("src");
		var cc="http://www.54tushu.com/book_library/bookshow/theId/33.html";
		if(uid==="") {
			alert('非用户无法收藏');
			return null;
		}
		
		if($(this).attr("class")==cc) {
			
			alert("此书仅用于展览使用，好吧，其实是爬取程序不支持此书所在网站，为防止BUG，所以我就不给你收藏咯。");
			return null;
		}
		
		

		$.ajax({
			type : "POST",
			url : url+"/bookshelves/add.do",
			dataType : 'text',
			data : {
				
				url : $(this).attr("class"),//
				id     :uid
			},
			beforeSend : function(){
		
				
				
									}, 
			success : function(data) {

			
			    alert("收藏成功。");

				

			},
			error : function() {
				alert("遇到预期之外的错误。")
			}

		})

		
		

		
		
	});
	
	
}







//检查用户是否登陆
$(function(){
	
	
	py();
	books();
	//绑定酷炫的ad翻页。
	 $("body").keydown(function(event){ 

		 //如果A键按下
		  if(event.keyCode ==65){
			  previousPage(); 
		  };
		//如果D键按下
		  if(event.keyCode ==68){
		 nextPage();

		  };
		 
		 
		  //如果左键按下
		  if(event.keyCode ==37 ){
			  previousPage(); 
		  };
		//如果右键按下
		  if(event.keyCode ==39){
			 nextPage();
			 
		  };
		 
		 
		 
	 });
	
	
	var url = $("#user").attr("src");
	var uid =$("#user").val();
	
	if(uid==="") {
		
		return null;
	} else {
		
		$("#login").empty();
		
		$("#login").append('<a href="'+url+'/views/test.jsp">用户空间</a>');
	
	}
	
	
});


function py() {
	
	var url = $("#user").attr("src");
	$.ajax({
		type : "POST",
		url :  url+"/book/search.do",
		dataType : 'json',
		data : {
			
			word : "克莉丝的炎之信仰",
			curpage :$("#curpage").val()// curpage
		},
		beforeSend : function(){
		$('#bookList').empty();
		$('#bookList').append("<p>数据加载中..........</p>");	
			
			
								}, 
		success : function(data) {
		$('#bookList').empty();			

		    var json = eval(data);
		    
		    
		    
			$.each(json, function(index, item) {
				
				      
						// 循环获取数据
						var Name = json[index].book_Name;
					    var $li =$('<li><a><img src="'+json[index].book_Url+'" alt="images/gay.png"/></a></li>');
					 
						$li.append('<div><ul><li class="title"><span class="lily">' +json[index].book_State+							
								'</span>'  +'   <span class="lily">'+json[index].book_Party+'</span>'+
								'<a href="'+url+"/score/login.do?bookId="+json[index].bookId+'"class="title" target="_blank">'+json[index].book_Name+'</a>'+
'<select id="'+json[index].book_Adress+'" class="feedback" onchange="fankui(this.id,this.value)" >'+
'<option value="反馈点这里">反馈点这里</option>'+  
'<option value="此书是变百">此书是变百</option>' +
'<option value="此书是变嫁">此书是变嫁</option>' +
'<option value="此书非变文">此书非变文</option>' +
'<option value="此书取向不明">此书取向不明</option>'+
'<option value="此书未完结">此书未完结</option>'+
'<option value="此书已完结">此书已完结</option> </select>'+
								' <span class="lily"><a   class="'+json[index].book_Adress+'"name="addBook">收藏</a></span></li>' +
								'<li class="desc"><span title="'+json[index].book_Msg+'">'+json[index].book_Msg +
								'</span></li>' +
								' <li class="info">'+
'<span><i class="fa fa-edit"></i>'+json[index].book_Words +' 字</span>'+
'<span><i class="fa fa-clock-o"></i>'+json[index].book_Date+'</span>' +
'<span><i class="fa fa-address-card"></i>作者：'+json[index].book_Author+'</span>' +
'</li>' +
' <li class="tags"> <span><i class="fa fa-tags"></i>'+json[index].book_Tag+' </span> </li>'	+								

								'</ul></div>');
						$('#bookList').append("<h4>默认作品列表：</h4>");	
						$('#bookList').append($li);	
						
						$('#curpage').val(json[index].curPage);
						$('#count').text(json[index].count);
				});
			
			
			//给收藏按钮绑定事件
			addbooks();

		},
		error : function() {
			$('#bookList').empty();
			$('#bookList').append("<p>没找到呢</p>");	
		}

	})
	
}
//查询书库中书本总数
function books(){
	var url = $("#user").attr("src");
	$.ajax({
		type : "POST",
		url :  url+"/book/booknum.do",
		dataType : 'text',
		data : {
		
		},success : function(data) {
			
			var i = data;
			$('#searchinput').attr('placeholder',"在"+i+"本变文中搜索");
			
		
			
		},
		error : function() {
			
		}
		
	
	
	});
	
	
	
	
};


