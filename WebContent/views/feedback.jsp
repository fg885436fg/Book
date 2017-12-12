<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<!-- <script type="text/javascript" src="http://tajs.qq.com/stats?sId=63412972" charset="UTF-8"></script>  -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<%--   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css"/> --%>
<title>反馈处理页面</title>
</head>
<body>
<input  id="user" src="${pageContext.request.contextPath}" value="${user.uid}"  hidden="hidden" class="${user.uname}"  name="${user.party}" />
<div class="container">
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li>
					<a href="<%= basePath%>/views/table.jsp">主页</a> <span class="divider">/</span>
				</li>
				<li>
					<a href="#">反馈管理</a> <span class="divider">/</span>
				</li>
			</ul>
		</div>
	</div>
	<div class="row">
		<div class="span3">
		</div>
		<div class="span6">
			<h3 class="text-center">
				书籍信息反馈处理
			</h3>
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							书名
						</th>
						<th>
							地址
						</th>
						<th>
							反馈内容
						</th>
						<th>
							反馈日期
						</th>
						<th>
							反馈人
						</th>
						<th>
							修改
						</th>
						<th>
							删除
						</th>
					</tr>
				</thead>
				<tbody id="list">
					<tr class="error">
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Approved
						</td>
						<td>
							Approved
						</td>
						<td>
							Approved
						</td>
						<td>
							<button class="btn btn-success btn-small" type="button">修改</button>
						</td>
						<td>
							<button class="btn btn-danger btn-small" type="button">删除</button>
						</td>
					</tr>
					<tr class="success">
						<td>
							2
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Approved
						</td>
						<td>
							Approved
						</td>
						<td>
							Approved
						</td>
						<td>
							<button name="update" class="btn btn-primary btn-small" data-toggle="modal" type="button" data-target="#myModal">修改
                            </button>
						</td>
						<td>
							<button name="delect" class="btn btn-danger btn-small" type="button">删除</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
			<button name="updateBook" class="btn btn-danger btn-small" type="button">更新按钮</button>
		<div class="span3">
		</div>
	</div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					更改页面
				</h4>
			</div>
			<div class="modal-body">
	<form action="<%= basePath%>/feedback/update.do" role="form">
	  <div class="form-group">
	  <label for="name">书名：</label><br>
	  <input type="text"  name="bookName" class="form-control" placeholder="书名" id="bookName" readonly>

	  <label for="name">阵营</label>
		<select name="partySelect" class="form-control" id="partySelect">
			<option value="不明" >不明</option>
			<option value="百合" >百合</option>
			<option value="嫁人" >嫁人</option>
		</select>
		
	
		
	 </div>
	 <div class="form-group">
	 	 <label for="name">状态</label>
		 <select name="stateSelect"  class="form-control" id="stateSelect">
		 <option value="连载" >连载</option>
		<option value="太监" >太监</option>
		<option value="完结" >完结</option>
		</select>
	   <label for="name">书籍地址：</label><br>
	  <input name="bookUrl" type="text" class="form-control" placeholder="地址" id="bookUrl" readonly>
	  <label for="name">变文与否</label>
		<select name="delectBook" class="form-control" id="delectBook">
			<option value="变文" >变文</option>
			<option value="非变文" >非变文</option>
			
		</select>
	  <div class="form-group">

	  </div>
	 <button type="submit" class="btn btn-default">提交</button>
</form>
				
		</div>
		
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../js/feedback.js"></script>

</html>