<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
      

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<!-- <script type="text/javascript" src="http://tajs.qq.com/stats?sId=63412972" charset="UTF-8"></script>  -->
<!-- 2017 -->
  <title>变身文学</title>

  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
  

  <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/iconlogo-36.png">
   <!-- <link rel="stylesheet" href="css/font-awesome.min.css"/> -->
 <link href="http://libs.baidu.com/fontawesome/4.0.3/css/font-awesome.css" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
<!--   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/new_sz.css"/> -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/indexes.css"/>
</head>


<body>

<input  id="user" src="${pageContext.request.contextPath}" value="${user.uid}"  hidden="hidden" class="${user.uname}"  name="${user.party}" />

<div>
  <header>
    <a href="https://tieba.baidu.com/f?kw=%E5%8F%98%E8%BA%AB%E6%96%87%E5%AD%A6&fr=index"><img src="${pageContext.request.contextPath}/images/bswxlogo.png" alt=""/></a>
    <div>
      <div>
        <input type="text" id="searchinput" placeholder="在10525本变文中搜索"/>
        <button id="search">搜书</button>
          <span id="login" ><a href="${pageContext.request.contextPath}/views/login.jsp">登陆</a></span>
      </div>
   <!--  <ul class="active">
        <li></li>
        <li>        
          <span><a  href="views/login.jsp">去登陆或注册</a></span>
         </li>
     
      </ul> -->
       
    </div>
  </header>
</div>
<nav>
  <ul>
    <li><a href="https://tieba.baidu.com/f?kw=%E5%8F%98%E8%BA%AB%E6%96%87%E5%AD%A6&fr=index">首页</a><i></i></li>
    <li ><i></i></li>
    <li></li>
    <li class="active">全网索引</li>
    <li><a href="${pageContext.request.contextPath}/views/log.jsp" >更新日志</a>
    <i></i>
    </li>
    
    <li><a href="${pageContext.request.contextPath}/views/game.html" target="_blank">游戏</a> 
    <i></i>
    </li>
    <li><a href="${pageContext.request.contextPath}/views/game.html" target="_blank">收藏排行榜</a> 
    <i></i>
    </li>
    
    <!-- <li>其他咨询 <i></i></li> -->
    <li class="nav_r"><h5>点我提交变文</h5></li>
  </ul>
</nav>
<section id="choose">
  <ul>
    <li class="choose-header">阵营：</li>
    <li class="active"id="全部">全部</li>
    <li  id="百合">百合</li>
    <li  id="嫁人">嫁人</li>
    <li  id="不明">不明</li>
  </ul>
  <ul>
    <li class="choose-header">排序：</li>
    <li class="active" id="book_Words">字数</li>
    <li id="book_Date">日期</li>
  </ul>
  <ul>
    <li class="choose-header" >状态：</li>
    <li class="active" id="is not null">全部</li>
    <li id="='完结'">完本</li> 
  </ul>
   <ul>
    <li class="choose-header">字数分类：</li>
    <li class="active" id="全部">全部</li>
    <li id="10w">10W以下</li>
    <li id="30w">10W~30W</li>
    <li id="50w">30W~50W</li>
    <li id="100w">50W~100W</li>
    <li id="10000w">100W以上</li>
  </ul>
   <ul>
    <li class="choose-header">细分：</li>
    <li class="active" id="全部">全部</li>
    <li id="奇幻">奇幻</li>
    <li id="都市">都市</li>
    <li id="舰女人">舰女人</li>
    <li id="同人">同人</li>
    <li id="穿越">穿越</li>
     <li id="游戏">游戏</li>
  
  </ul>
  
  
</section>

<section id="main">
  <div>
    <ul id="bookList">
      
    </ul>
  </div>
  <div class="paging">
    <p>
      <a href="#" onclick="firstPage();">首页</a>
      <a href="#" onclick="previousPage();">上一页</a>
      第 <input type="text"  value="1" id="curpage"/>页  总<span id="count">1</span>页 <button class="button">go</button>
      <a href="#" onclick="nextPage();">下一页</a>
      <a a href="#" onclick="endPage();">尾页</a>
    </p>
  </div>
    <br><h3>按A/D键</h3>进行翻页，左右键也行
</section>

<footer>
	<div class="container">
		<div class="foot_info"></div>
		<div class="site_info">
			<p>Q群：218025776</p>
			<p>后台运维等苦力：红色阿克雷斯 </p>
			<p>爬虫工具：雅白</p>
			<p>推广与画大饼：神烛 </p>
			<p>主页布局：岛疯疯</p>
			<p>阵营图标设计：二哈</p>
		</div>
	</div>
</footer>

<div class="mask-background">
  <div>
    <span class="close-mask times">&times;</span>
    <h3>添加变文吧！</h3>
    <div>

      <input id="text" type="text" placeholder="请输入地址或小说名"/>
    </div>
    <h4>
      <span class="close-mask">取消</span>
      <span class="close-mask" id="add">确定</span>
    </h4>
  </div>
</div>

</body>
 
<!--  <script src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.11.1.min.js"></script> -->
<script  src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>   
<script src="${pageContext.request.contextPath}/js/indexes.js"></script>
<script src="${pageContext.request.contextPath}/tool/ajaxUtil.js"></script>

</html>