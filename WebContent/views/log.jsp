<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script type="text/javascript" src="http://tajs.qq.com/stats?sId=63412972" charset="UTF-8"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新日志</title>
 <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/iconlogo-36.png">
  <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<ul class="breadcrumb">
				<li>
					<a href="${pageContext.request.contextPath}/views/table.jsp">主页</a> <span class="divider">/</span>
				</li>
				<li class="active">
					<a href="#">更新日志</a> <span class="divider">/</span>
				</li>
			
			</ul>
			<h3 class="text-center">
				这是简要的操作提示
			</h3>
			<p class="text-center">
				按<strong>A、D键</strong>实现上下翻页，左右箭头键亦有此功能。如果有什么要跟我说的，你可以在首页点击<strong>“点我提交变文”</strong>，在输入框输入你想说的话，我会在后台看到的。<br>
			没错，你们提交的地址与书名，都是我人工添加的。其实你要是不怎么懒的话，可以在贴吧留言，点首页，看置顶，在我的置顶帖那留言。
			</p><br>
			
			
		</div>
	</div>
	
	
<div class="panel-group" id="accordion">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title text-center">
                <a data-toggle="collapse" data-parent="#accordion"  aria-expanded="false" class="collapsed" href="#collapseOne">
                       7/14 增添了搜索功能，详细点开折叠                   
                </a> 
            </h4>
        </div>
        <div id="collapseOne" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
            <div class="panel-body text-center">
               搜索框是根据你输入的内容，对书库里书的标签、阵营以及名字进行索引。目前发现加载情况报告错误，待修改。
               
            </div>
        </div>
    </div>
   </div>
   
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title text-center">
                <a data-toggle="collapse" data-parent="#accordion"  aria-expanded="false" class="collapsed" href="#collapseTwo">
                       7/21 增添了用户藏书功能与按键翻页功能，详细点开折叠                   
                </a> 
            </h4>
        </div>
        <div id="collapseTwo" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
            <div class="panel-body text-center">
               	只有用户才能收藏，注册登陆后，点击书名后收藏按钮即可收藏。<br>
               	现在按下A或者D，可以实现翻页，左右键也可以。<br>
               	 找回账号功能还未开发。由于用户量少，下一步准备开发手机网站。
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title text-center">
                <a data-toggle="collapse" data-parent="#accordion"  aria-expanded="false" class="collapsed" href="#collapse3">
                       7/24 增加了字数、细分等选项，详细点开折叠                   
                </a> 
            </h4>
        </div>
        <div id="collapse3" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
            <div class="panel-body text-center">
               	优化了后台没有灵性的代码，让增添功能变得更方便。而且忽然发现一个非常有灵性的小方法<br>
               	于是，我加了字数以及类别等一大堆没用的选项块。<br>
               	手机网站还没开始动手。
            </div>
        </div>
    </div>
    
    
    
      <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title text-center">
                <a data-toggle="collapse" data-parent="#accordion"  aria-expanded="false" class="collapsed" href="#collapse4">
                       8/7日 重大更新，更新代码使得更具有扩展性           
                </a> 
            </h4>
        </div>
        <div id="collapse4" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
            <div class="panel-body text-center">
               	其实就是将原来的代码套上SSH框架上，<br>
               
            </div>
        </div>
    </div>
    
    
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title text-center">
                <a data-toggle="collapse" data-parent="#accordion"  aria-expanded="false" class="collapsed" href="#collapse5">
                       8/8日 增添了缓存技术、优化了代码，使得后台响应请求更快。并装上雅白开发的新一代爬取工具         
                </a> 
            </h4>
        </div>
        <div id="collapse5" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
            <div class="panel-body text-center">
               	由于使用雅白开发的新一代爬取工具，书库书籍突破一万本，导致后台响应慢<br>
               	最新的爬取工具，能智能辨识变文，准确度约为90%<br>
               	在增添了缓存技术后，第一次搜索全库书后台响应时间为12S，第二次2S。<br>
               	在完善分页逻辑后，响应时间下降至120ms。
               
            </div>
        </div>
    </div>
    
   </div>
   
    <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title text-center">
                <a data-toggle="collapse" data-parent="#accordion"  aria-expanded="false" class="collapsed" href="#collapse6">
                       8/14日 这几天大更新、增加了反馈处理界面，完善了诸多细节,更改了界面。用户藏书将于明日迁移     
                </a> 
            </h4>
        </div>
        <div id="collapse6" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
            <div class="panel-body text-center">
               	由于周六忙着给上古卷轴5 打mod，周日从三点一直忙到凌晨三点。由于抓取了大量的非变文（保守估计有1000本），所以增加了反馈处理界面。<br>
               	围绕着界面，又不得不增加了一大堆代码。
               	
               	
               	
               
            </div>
        </div>
    </div>
    
    
     <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title text-center">
                <a data-toggle="collapse" data-parent="#accordion"  aria-expanded="false" class="collapsed" href="#collapse7">
                       8/17日 修正收藏BUG。  
                </a> 
            </h4>
        </div>
        <div id="collapse7" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
            <div class="panel-body text-center">
               原因，文件损坏。
 
            </div>
        </div>
    </div>
    
    
     <div class="panel panel-default">
        <div class="panel-heading">
            <h4 class="panel-title text-center">
                <a data-toggle="collapse" data-parent="#accordion"  aria-expanded="false" class="collapsed" href="#collapse8">
                       8/28日  添加了俄罗斯方块游戏
                </a> 
            </h4>
        </div>
        <div id="collapse8" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
            <div class="panel-body text-center">
                准备添加评价系统，由于近段没时间，可能下个月才能实装。以后用户可以对书籍发书评。
 
            </div>
        </div>
    </div>
    
    
    
    
    
    
    
   </div>
   
   
   
   
   
   
   
   
   
</div>











</body>
<script  src="../js/jquery-1.11.3.min.js"></script> 

 <script src="../js/bootstrap.js" ></script>
</html>