<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>auj | Jian</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${APP_PATH }/static/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH }/static/plugins/select2/select2.css">
    <link rel="stylesheet" href="${APP_PATH }/static/css/AdminLTE.min.css">
    <link rel="stylesheet" href="${APP_PATH }/static/css/_all-skins.min.css">
    <link rel="stylesheet" href="${APP_PATH }/static/plugins/iCheck/flat/blue.css">
    <script src="${APP_PATH }/static/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${APP_PATH }/static/plugins/select2/select2.full.min.js"></script>
    <script src="${APP_PATH }/static/js/app.min.js"></script>
    <style type="text/css">
        span.glyphicon {
            padding-right: 0.2rem;
        }

        .select2-container--default .select2-selection--multiple {
            border: none;
        }
    </style>
</head>
<body class="layout-top-nav skin-black-light">
<div class="wrapper">
    <header class="main-header">
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <a href="" class="navbar-brand"><b>Jian</b>uj</a>
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#navbar-collapse">
                        <i class="fa fa-bars"></i>
                    </button>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" id="navbar-search-input" placeholder="Search">
                        </div>
                    </form>
                </div><!-- /.navbar-collapse -->
                <!-- Navbar Right Menu -->
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                        <!-- User Account Menu -->
                        <li class="dropdown user user-menu">
                            <!-- Menu Toggle Button -->
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <!-- The user image in the navbar-->
                                <img src="/static/img/user1-128x128.jpg" id="userImg" class="user-image"
                                     alt="User Image">
                                <!-- hidden-xs hides the username on small devices so only the image appears. -->
                                <span class="hidden-xs" id="userNameId">ahujin</span>
                            </a>
                            <ul class="dropdown-menu">
                                <!-- The user image in the menu -->
                                <li class="user-header">
                                    <img src="/static/img/user1-128x128.jpg" class="img-circle" alt="User Image">
                                    <p>
                                        ahujin

                                    </p>
                                </li>
                                <!-- Menu Body -->
                                <li class="user-body">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">喜欢数 1200</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">粉丝 23</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">关注 3</a>
                                    </div>
                                </li>
                                <!-- Menu Footer-->
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a href="#" class="btn btn-default btn-flat">Profile</a>
                                    </div>
                                    <div class="pull-right">
                                        <a href="/quit" class="btn btn-default btn-flat">Sign out</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-custom-menu -->
            </div><!-- /.container-fluid -->
        </nav>
    </header>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper" style="min-height: 535px;">
        <!-- Content Header (Page header) -->
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-7">
                    <!-- 发布文字 -->
                    <div class="box box-widget widget-user">
                        <!-- Add the bg color to the header using any of the bg-* classes -->
                        <div class="widget-user-header bg-blue" style="">
                            <h3 class="widget-user-username">${personal.username}</h3>
                            <h5 class="widget-user-desc">Web Designer</h5>
                        </div>
                        <div class="widget-user-image">
                            <img class="img-circle" src="/static/img/${personal.userimg}" alt="User Avatar">
                        </div>
                        <div class="box-footer">
                            <div class="row">
                                <div class="col-sm-4 border-right">
                                    <div class="description-block">
                                        <h5 class="description-header">${personal.likes}</h5>
                                        <span class="description-text">喜欢</span>
                                    </div><!-- /.description-block -->
                                </div><!-- /.col -->
                                <div class="col-sm-4 border-right">
                                    <div class="description-block">
                                        <h5 class="description-header">${personal.fans}</h5>
                                        <span class="description-text">粉丝</span>
                                    </div><!-- /.description-block -->
                                </div><!-- /.col -->
                                <div class="col-sm-4">
                                    <div class="description-block">
                                        <h5 class="description-header">${personal.follows}</h5>
                                        <span class="description-text">关注</span>
                                    </div><!-- /.description-block -->
                                </div><!-- /.col -->
                            </div><!-- /.row -->
                        </div>
                    </div><!-- /.box -->

                    <div id="articleIdInfoDiv" class="info-box">
                    </div>
                    <!-- 显示分页信息 -->
                    <div class="row">
                        <!--分页文字信息  -->
                        <div class="col-md-6" id="page_info_area"></div>
                        <!-- 分页条信息 -->
                        <div class="col-md-6" id="page_nav_area">

                        </div>
                    </div>
                </div><!-- /.col -->
                <div class="col-md-3">
                    <div class="box box-default">
                        <div class="box-header with-border">
                            <h3 class="box-title">其他信息</h3>
                        </div>
                        <div class="box-footer no-padding">
                            <ul class="nav nav-stacked">
                                <li><a href="#">文章数 <span id="articleNum" class="pull-right badge bg-blue">0</span></a></li>
                                <li><a href="#">标签数 <span id="tagNum" class="pull-right badge bg-blue">0</span></a></li>
                            </ul>
                        </div><!-- /.box-body -->
                        <div class="box-footer text-center">
                            <a href="" class="uppercase">View All Users</a>
                        </div><!-- /.box-footer -->
                    </div>
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.3.0
        </div>
        <strong>Copyright © 2018 <a href="#">jian</a>.</strong> All rights reserved.
    </footer>
</div>
<script type="text/javascript">
    /*
    * 全局变量
    * 当前用户id
    * 总记录数，当前页码
    * */
    var currentUserId;
    var totalRecord, currentPage;
    /*
    * Dom 加载完毕
    * - 初始化当前用户 id
    * - 加载文章信息
    * - end
    * */
    $(function () {
        currentUserId = ${personal.userid};
        console.log("init User id : " + currentUserId);
        to_page(1);
        baseInfo(currentUserId);
    });

    function baseInfo(id) {
        $.ajax({
            url: "${APP_PATH}/person/info",
            data: {userid: currentUserId},
            type: "GET",
            success: function (result) {
                if (result.code == 100) {
                    console.log(result);
                    $("#articleNum").html(result.extend.articleNum);
                    $("#tagNum").html(result.extend.tagNum);
                }
            }
        });
    }

    /*
    * 文章数据
    * 第pn页文章数据
    * */
    function to_page(pn) {
        $.ajax({
            url: "${APP_PATH}/person",
            data: {userId: currentUserId, pn: pn},
            type: "POST",
            success: function (result) {
                if (result.code == 100) {

                    if (result.extend.pageInfo.list.length < 1) {
                        $("#articleIdInfoDiv").append("<h4 style=\"text-align: center;padding-top: 30px;\">暂时没有动态消息!</h4>");
                        return false;
                    }
                    build_article(result);
                    build_page_info(result);
                    build_page_nav(result)
                }
            }
        });
    }

    /*解析文章集合数据*/
    function build_article(result) {
        /*存储文章集*/
        $("#articleIdInfoDiv").empty();
        var articlesInfo = result.extend.pageInfo.list;
        console.log(articlesInfo);

        $.each(articlesInfo, function (index, item) {
            /*box 每一篇文章*/
            var box = $("<div class=\"box box-widget commentBox\"></div>");
            /*box-header 部分: 文章内容，图片地址，用户名称，发布时间*/
            var header = $("<div class=\"box-header with-border\"></div>");
            var hbody = $("<div class=\"user-block\"></div>");
            var hname = $("<span class=\"username\"></span>").append("<a href=\"#\"></a>").append(item.user.username);
            var htime = $("<span class=\"description\"></span>").append(new Date(item.articletime).toLocaleString());
            var himg = $("<img class=\"img-circle\" src=\"\" alt=\"user image\">").attr("src", "${APP_PATH }/static/img/" + item.user.userimg);
            header.append(hbody.append(himg).append(hname).append(htime));
            /*box-body 部分: 评论按钮， 喜欢按钮， 分享按钮，评论按钮*/
            var body = $("<div class=\"box-body\"></div>");
            var btncollec = $("<button class=\"btn btn-default btn-xs shareBtn\"><i class=\"fa fa-share\"></i> Share</button>");
            var commentBtn = $("<button class=\"btn btn-default btn-xs commentsBtn\"><i class=\"fa fa-comment\"></i>评论</button>");
            commentBtn.prop("data-toggle", item.articleid);
            var btnlike = $("<button class=\"btn btn-default btn-xs likeBtn\" ><i class=\"fa fa-thumbs-o-up\"></i> 喜欢</button>").prop("user-id", item.userid).prop("article-id", item.articleid);
            var likenum = $("<span class=\"pull-right text-muted spanLikeNum\"></span>").append(item.likenum);
            var pcontent = $("<p></p>").append(item.articlebody);
            /*评论内容*/
            var commentsinfo = $("<div class=\"box-footer box-comments commenttoggle\" style=\"display: none;\"></div>");
            /*评论输入框*/
            var writeComment = $("<div class=\"box-footer commenttoggle\" style=\"display: none;\"></div>");
            var commentForm = $("<form></form>");
            var commentUserImg = $("<img class=\"img-responsive img-circle img-sm\" src=\"\"alt=\"alt text\">");
            commentUserImg.attr("src", "${APP_PATH }/static/img/${user.userimg}");
            var commentRight = $("<div class=\"img-push\"><input style='display:none' /></div>");
            var commentInput = $("<input type=\"text\" class=\"form-control input-sm\" onkeydown='if(event.keyCode==13){saveComment($(this));}'  placeholder=\"Press enter to post comment\">").prop("data", item.articleid).prop("userid", item.userid);
            commentRight.append(commentInput);
            commentForm.append(commentUserImg).append(commentRight).appendTo(writeComment);
            /*box中加入评论输入框，按钮，头部信息*/
            body.append(pcontent).append(btnlike).append(btncollec).append(likenum).append(commentBtn);
            box.append(header).append(body).append(commentsinfo).append(writeComment);
            /*文章（box）加入到div*/
            $("#articleIdInfoDiv").append(box);
        });
    }

    /*
    * 解析显示分页信息
    * - 显示分页信息
    * - 全局变量初始化: 当前页码位置，总记录数
    * */
    function build_page_info(result) {
        $("#page_info_area").empty();
        $("#page_info_area").append("当前" + result.extend.pageInfo.pageNum + "页,总" +
            result.extend.pageInfo.pages + "页,总" +
            result.extend.pageInfo.total + "条记录");
        totalRecord = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
    }

    /*
    * 解析显示分页条
    * - 点击分页要能去下一页
    * - 位于首页/尾页/当前页时，首页和尾页不可点击
    * - 有无前一页来决定能否前往前一页
    * */
    function build_page_nav(result) {
        //page_nav_area
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");
        //构建元素
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if (result.extend.pageInfo.hasPreviousPage == false) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            //为元素添加点击翻页的事件
            firstPageLi.click(function () {
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum - 1);
            });
        }
        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
        if (result.extend.pageInfo.hasNextPage == false) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum + 1);
            });
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.pages);
            });
        }
        //添加首页和前一页 的提示
        ul.append(firstPageLi).append(prePageLi);
        //1,2，3遍历给ul中添加页码提示
        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if (result.extend.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页 的提示
        ul.append(nextPageLi).append(lastPageLi);
        //把ul加入到nav
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }
</script>
</body>
</html>
