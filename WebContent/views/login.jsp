<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script type="text/javascript" src="http://tajs.qq.com/stats?sId=63412972" charset="UTF-8"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
 <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"> 

  <link href="../css/ie10-viewport-bug-workaround.css" rel="stylesheet">
  <link href="../theme/signin.css" rel="stylesheet">
  <script src="../js/ie-emulation-modes-warning.js"></script>
 
</head>
<body>
  	<input  id="user" src="${pageContext.request.contextPath}" value="${user.uid}"  hidden="hidden" class="${user.uname}"  name="${user.party}" />
   <form class="form-signin" action="<%= basePath%>/user/login.do" method="post">
        <h3 class="form-signin-heading">登陆</h3>
        <h4 class="form-signin-heading">${msg}</h4>
        <label for="name" class="sr-only">Text</label>
        <input type="text" id="inputUsername" name="username" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword"  name="userpassword"class="form-control" placeholder="密码" required>
        <button class="btn btn-lg btn-primary" type="submit">登陆</button>
        <button class="btn btn-lg btn-primary" id="regis"  data-toggle="modal" data-target=".bs-example-modal-lg"type="button">注册</button>
        <button class="btn btn-lg btn-primary"  data-toggle="modal" data-target=".getPassword"type="button" >找回密码</button>
      </form> 
      
      
      
      <!-- 模态框——注册 -->

   <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-lg" role="document">
   <div class="modal-content">
  

	<form class="form-signin" action="<%= basePath%>/user/regis.do" method="post">
        <h3 class="form-signin-heading">注册</h3>
        
        <label for="name" class="sr-only">Text</label>
        <input type="text" name="uname"  class="form-control" maxlength="15" placeholder="键入用户名(十五字以内)" id="userName" />
        <label for="inputPassword" class="sr-only">Password</label> 
        <input type="password"  id="userPwd1" maxlength="15" name="upwd" class="form-control" placeholder="键入密码(十五字以内)" required>
        <label for="inputPassword" class="sr-only">Password</label> 
        <input type="password"  id="userPwd2"  maxlength="10" name=user.upwd class="form-control" placeholder="键入重复密码" required>
        
        <label for="text" class="sr-only">Text</label> 
        <input type="text"  type="hidden"   class="form-control" value="通吃派" readonly id="input" name="party">
        
        <label for="name">选择你的偏好(鼠标悬停于选项上显示解释)</label>
		<select class="form-control" name="party1" id="select">
			<option value="通吃派" title="只要是变文我都看！通吃啦！">通吃派</option>
			<option value="百合党" title="不是变百文我都不看！嫁人退散啦！">百合党</option>
			<option value="嫁人派" title="不是变嫁文我都不看！变百退散啦！">嫁人派</option>
			<option value="正剧党" title="不是正儿八经的文我都不看！萌文退散啦！">正剧党</option>
		</select> 
		<label for="name" class="sr-only">Text</label>
        <input type="text"name="uquestion" maxlength="20" class="form-control"  placeholder="设置账号找回问题,如：我妈贵姓？" id="uquestion" />
        <input type="text"name="uanswer"    maxlength="20"    class="form-control"  placeholder="设置问题答案,例如：我妈姓赵 "      id="uanswer" />
       
        <button class="btn btn-lg btn-primary" id="submit" disabled="disabled" type="submit">注册</button>          
   </form> 
    </div>
  </div>
</div>
      
        <!-- 模态框——找回密码-->
      <div class="modal fade getPassword" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-lg" role="document">
   <div class="modal-content">
  
  	<input  id="user" src="${pageContext.request.contextPath}" value="${user.uid}"  hidden="hidden" class="${user.uname}"  name="${user.party}" />
	<form class="form-signin" action="<%= basePath%>/user/getpasswor.do" method="post">
       <h3 class="form-signin-heading">密码找回</h3>
      <label for="name" class="sr-only">Text</label>
      <input type="text" name="yourName"  class="form-control" maxlength="15" placeholder="键入用户名(十五字以内)" id="yourName" />
      <br>
      <label for="name" class="sr-only">Text</label>
      <input type="text" name="yourQuestion"  class="form-control" maxlength="15" placeholder="问题" id="yourQuestion" />
       <br>
      <label for="name" class="sr-only">Text</label>
      <input type="text" name="yourAnswer"  class="form-control" maxlength="15" placeholder="键入答案" id="yourAnswer" />
       <br>
      <label for="name" class="sr-only">Text</label>
      
	  <br>
	  <input type="text" name="uname"  class="form-control" maxlength="15" placeholder="输入正确答案，再点我，这就显示密码。" id="yourPassword" />      
   </form> 
    </div>
  </div>
</div>
      
      
      
</body>
<script  src="../js/jquery-1.11.3.min.js"></script> 
<script src="../js/login.js"></script>
<script src="../js/regis.js"></script>
 <script src="../js/bootstrap.js" ></script>
</html>