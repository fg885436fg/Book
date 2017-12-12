/**
 * 
 * @param method  请求方式
 * @param url   地址 不带任何参数
 * @param params  参数   可以传null   键=值&键=值...
 * @param handle200   成功之后执行的函数，形参变量是responseText的值
 * @param asyn   同步异步  不传默认异步
 * @param handle404   没找到页面所执行的函数
 * @param handle500  服务器报错所执行的函数
 * @param loading   接收数据过程中所执行的函数
 */
function ajax(method,url,params,handle200,asyn,handle404,handle500,loading){
			if("get"!=method&&"post"!=method){
				method="get";
			}
			//给地址拼接防缓存的东西
			url=url+"?"+new Date().getTime();
			if(params&&"get"==method){
				url=url+"&"+params;
			}
			//获取请求对象
			var request;
			if(window.XMLHttpRequest){
				request=new XMLHttpRequest();
			}else if(window.ActiveXObject){
				//Msxml2.XMLHTTP  IE解析器的版本号   固定写法
				request=new ActiveXObject("Msxml2.XMLHTTP");
			}
			//访问服务器       
			//open(method,url,asyn)  第三个参数是同步或异步   true异步  false为同步   默认异步
			if(typeof asyn=="boolean"){
				request.open(method,url,asyn);
			}else{
				request.open(method,url);
			}
			
			
			
			//监听响应的状态，响应的状态每改变一次就会调用重写的函数
			request.onreadystatechange=function(){
				//获取响应的状态
				var state=request.readyState;
				
				   if(state==4){
					   
						document.getElementById("bookTab").deleteRow(3);
					   
					   
					var status=request.status;
					if(status==200){
						
						var data=request.responseText;
						if(typeof handle200=="function"){
							
							handle200(data);
						}
					}else if(status==404){
						if(typeof handle404=="function"){
							alert(404);
							handle404();
						}
					}else if(status==500){
						if(typeof handle500=="function"){
							alert(500);
							handle500();
						}
					}
				}else if(state==2){
					//数据接收中执行的代码
					var newTr=bookTab.insertRow(3);
					newTr.align="center";
			
					newTr.innerHTML="<th colspan='8' align='center'>数据接收中........</th>";
				
					
				}
			}
			//传输参数   没有参数的时候 不能省略  并且里面要写null
			if(method=="post"){
				request.setRequestHeader("content-type", "application/x-www-form-urlencoded");
				request.send(params);			
			}else{
				request.send(null);			
			}
		}