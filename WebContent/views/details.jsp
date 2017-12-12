<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>详细</title>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/iconlogo-36.png">
    <!-- Bootstrap core CSS -->
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=63412972" charset="UTF-8"></script>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/font-awesome.min.css"/>
    <link href="../css/details.css" rel="stylesheet">

</head>
<body>
<input  id="avgScore" src="${avgScore.avg}" value="${user.uid}"  hidden="hidden" class="${user.uname}"  name="${user.party}" />
<div class="header">
    <div>
        <div class="row">
            <div class="col-xs-6">
                <a href="index.html">
                    <img src="../images/bswxlogo-1.png" alt=""/>
                </a>
            </div>
            <div class="col-xs-4">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="在此搜索变文">
                     <span class="input-group-btn">
                        <button class="btn btn-default" type="button">搜索</button>
                     </span>
                </div>
            </div>
            <div class="col-xs-2">
                <a href="" class="sign-in">登录</a>
            </div>
        </div>
    </div>
</div>
<a href="#" class="return-top fa fa-arrow-up"></a>
<div class="container">
    <div class="row">
        <div class="col-xs-12 label-container">
            <span class="label " style="background-color: pink">${book.book_State}</span>
            <span class="label " style="background-color: pink">${book.book_Party}</span>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-6">
            <h3>
                ${book.book_Name}
               
            </h3>
        </div>
        <div class="col-xs-6 star-container">
            <p class="pull-right">
                <span style="color: plum;">
                    <span>
                        <span id="star1" class="fa fa-star-o"></span>
                    </span>
                    <span>
                        <span id="star2" class="fa fa-star-o"></span>
                    </span>
                    <span>
                        <span id="star3" class="fa fa-star-o"></span>
                    </span>
                    <span>
                        <span id="star4" class="fa fa-star-o"></span>
                    </span>
                    <span>
                        <span id="star5" class="fa fa-star-o"></span>
                    </span>
                    <b>
                       ${avgScore.avg}分
                    </b>
                </span>
                <span>
                      本书共有${avgScore.num}个评价
                </span>
            </p>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-6">
            <div class="row">
                <div class="col-xs-4 text-center">
                    <img alt="" width="107px" height="150px" src="${book.book_Url}"/>
                </div>
                <div class="col-xs-8">
                    <ul class="book-details">
                        <li>
                            作者: ${book.book_Author}
                        </li>
                        <li>
                            字数: ${book.book_Words}字
                        </li>
                        <li>
                            来自: ${book.book_site}
                        </li>
            
                        <li>
                            标签： ${book.book_Tag} 
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="col-xs-6 progress-container">
        <p>嫁人派评价比率</p>
            <div class="progress">
                <div style="width:${avgScore.jiaren}%" class="progress-bar progress-bar-success">${avgScore.jiaren}%</div>
            </div>
              <p>百合党评价比率</p>
            <div class="progress">
                <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0"
                     aria-valuemax="100" style="width: ${avgScore.jiaren}%">
                    ${avgScore.baihe}%
                </div>
            </div>
              <p>正剧党评价比率</p>
            <div class="progress">
                <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="60" aria-valuemin="0"
                     aria-valuemax="100" style="width: ${avgScore.jiaren}%">
                     ${avgScore.zhengjv}%
                </div>
            </div>
              <p>通吃派评价比率</p>
            <div class="progress">
                <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0"
                     aria-valuemax="100" style="width: ${avgScore.jiaren}%">
                      ${avgScore.tongchi}%
                </div>
            </div>
        </div>
    </div>
    <div class="row margin">
        <div class="col-xs-12">
            <div class="accordion" id="accordion-container">
                <div class="accordion-group">
                    <div class="accordion-heading bg-primary">
                        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                            &nbsp;本书介绍
                        </a>
                    </div>
                    <div id="collapseOne" class="accordion-body collapse" style="height: 0px; ">
                        <div class="accordion-inner">
                         ${book.book_Msg}  
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <!-- 第一列-->
        <div class="col-xs-4">
            <!-- 评论模块-->
            <div class="comment-module">
                <div class="media">
                    <div class="media-left media-middle">
                        <a href="#">
                            <img class="media-object" src="../images/user.jpg" alt="">
                        </a>
                    </div>
                    <div class="media-body">
                        <p class="media-heading">我是智障
                            <br/>
                            2017/8/21 16:14
                        </p>
                    </div>
                    <img src="../images/嫁人.png" alt=""   />
                </div>
                <div class="comment-content">
                    这本书就算有种种缺点但还是给个仙草，在寒门穿越文里面这本算是一股清流比较符合实际的文，首先不脑残。
                    虽然我不会写小说但是我真的会看小说，许多我看不下去小说不是文笔不好而是一股脑残扑面而来，比如猪脚
                    受到挑衅了就爱抄诗词去打脸，自己没有真才实学剽窃别人的东西还得意洋洋这样的猪脚真心没有代入感。在
                    比如猪脚天天在宅斗都没见怎么读书就连中大三元了。好像大三元就像现在的大白菜一样两元钱三斤。最喜欢
                    这文的就是没有剽窃，而且猪脚不故意装B猪脚不擅长诗词就大方的承认并且找到自己擅长的方面发展。在就
                    是没有极品亲戚邻居什么的这个挺符合现实就算心里怎么想大明上得过得去这才是大多数人的选择。
                </div>
                <div class="btn-group" role="group" aria-label="...">
                    <button type="button" class="btn btn-default btn-md">
                        <span class="fa fa-thumbs-o-up" aria-hidden="true"></span> 点赞
                    </button>
                    <button type="button" class="btn btn-default btn-md">
                        <span class="fa fa-mail-forward" aria-hidden="true"></span> 评论
                    </button>
                </div>
            </div>
        </div>
        <!-- 第二列-->
        <div class="col-xs-4">
            <div class="comment-module">
                <div class="media">
                    <div class="media-left media-middle">
                        <a href="#">
                            <img class="media-object" src="../images/user.jpg" alt="">
                        </a>
                    </div>
                    <div class="media-body">
                        <p class="media-heading">我是智障
                            <br/>
                            2017/8/21 16:14
                        </p>
                    </div>
                    <img src="../images/百合.png" alt=""/>
                </div>
                <div class="comment-content">
                    我之仙草，很不错有时很有启发，觉得是没太开金手指的穿越，女穿男，转折写的不错。
                </div>
                <div class="btn-group" role="group" aria-label="...">
                    <button type="button" class="btn btn-default btn-md">
                        <span class="fa fa-thumbs-o-up" aria-hidden="true"></span> 点赞
                    </button>
                    <button type="button" class="btn btn-default btn-md">
                        <span class="fa fa-mail-forward" aria-hidden="true"></span> 评论
                    </button>
                </div>
            </div>
        </div>
        <!-- 第三列-->
        <div class="col-xs-4">
            <div class="comment-module">
                <div class="media">
                    <div class="media-left media-middle">
                        <a href="#">
                            <img class="media-object" src="../images/user.jpg" alt="">
                        </a>
                    </div>
                    <div class="media-body">
                        <p class="media-heading">我是智障
                            <br/>
                            2017/8/21 16:14
                        </p>
                    </div>
                    <img src="../images/正剧.png" alt=""/>
                </div>
                <div class="comment-content">
                    忽略几个小膈应，这文其实能看，言语通顺，人物有智商，虽然不是起点男虎躯一震八方来投
                    摧枯拉朽叫日月换了新颜的爽白文，但猪脚好歹踏踏实实地在做事。除了，一个天雷！请问作
                    者，把猪脚安排成女穿男而不是男主穿越，到底逻辑跟爽点在哪？！！！！全文没看见一点男
                    猪脚必须是女性穿越的理由！反倒每每看见猪脚夫妻感情甜甜蜜蜜就闪回猪脚其实是女性穿过
                    来的，膈应人啊！！！
                </div>
                <div class="btn-group" role="group" aria-label="...">
                    <button type="button" class="btn btn-default btn-md">
                        <span class="fa fa-thumbs-o-up" aria-hidden="true"></span> 点赞
                    </button>
                    <button type="button" class="btn btn-default btn-md">
                        <span class="fa fa-mail-forward" aria-hidden="true"></span> 评论
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/assess.js"></script>
</body>
</html>