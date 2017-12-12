<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script type="text/javascript" src="http://tajs.qq.com/stats?sId=63412972" charset="UTF-8"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户空间</title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<input  id="user" src="${pageContext.request.contextPath}" value="${user.uid}" hidden="hidden"  class="${user.uname}"  name="${user.party}" />


<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<ul class="breadcrumb">
				<li>
					 <a href="${pageContext.request.contextPath}/views/table.jsp">首页</a>
				</li>

				<li class="active">
					书架
				</li>
			</ul>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-1 column">
			 <a class="btn" id="modal-432524" role="button" href="#modal-container-432524" data-toggle="modal">帮助</a>
			
			<div class="modal fade" id="modal-container-432524" role="dialog" aria-hidden="true" aria-labelledby="myModalLabel">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button class="close" aria-hidden="true" type="button" data-dismiss="modal">×</button>
							<h4 class="modal-title" id="myModalLabel">
								本网站使用指南
							</h4>
						</div>
						<div class="modal-body">
							在首页索引界面，把鼠标放置在介绍上，会浮现介绍全文。<br>
							书架的排序功能没有开发。<s>好麻烦呀，就不开发了。</s>
							因此排序是受用户收藏的先后而决定的。
						</div>
						<div class="modal-footer">
							 <button class="btn btn-default" type="button" data-dismiss="modal">关闭</button> 
						</div>
					</div>
					
				</div>
				
			</div>
			
		</div>
		<div class="col-md-10 column">
			<h3 class="text-center">
				用户书架
			</h3>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>
							书名
						</th>
						<th>
							更新时间
						</th>
						<th>
							状态
						</th>
						<th>
							偏向
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody id="table">
					
					
					
					
					
					
					
				</tbody>
			</table>
			<div class="text-center">
			<ul class="pagination">
				<li>
					 <a href="#" onclick="firstPage();">首页</a>
				</li>
				<li>
					  <a href="#" onclick="previousPage();">上一页</a>
				</li>
				<li><span id="curpage">1</span></li>
				<li><span id="count">总1页</span></li>
				<li>
					<a href="#" onclick="nextPage();">下一页</a>
				</li>
				<li>
					<a a href="#" onclick="endPage();">尾页</a>
				</li>

			</ul>
			</div>
		</div>
		<div class="col-md-1 column">
		</div>
	</div>
</div>
</body>
<script  src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script> 
<script  src="${pageContext.request.contextPath}/js/bootstrap.js" ></script>
<script  src="${pageContext.request.contextPath}/js/space.js" ></script>

</html>