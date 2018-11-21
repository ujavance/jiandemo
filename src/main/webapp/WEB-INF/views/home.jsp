<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <script src="${APP_PATH }/static/js/myJS/follower.js"></script>
    <style type="text/css">
        span.glyphicon {
            padding-right: 0.2rem;
        }

        .select2-container--default .select2-selection--multiple {
            border: none;
        }
        .users-list-date{
            cursor: pointer;
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
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
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
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <!-- The user image in the navbar-->
                                <img src="${APP_PATH}/static/img/${user.userimg}" id="userImg" class="user-image" alt="User Image">
                                <!-- hidden-xs hides the username on small devices so only the image appears. -->
                                <span class="hidden-xs" id="userNameId">${user.username}</span>
                            </a>
                            <ul class="dropdown-menu">
                                <!-- The user image in the menu -->
                                <li class="user-header">
                                    <img src="${APP_PATH}/static/img/${user.userimg}" class="img-circle" alt="User Image">
                                    <p>
                                        ${user.username}
                                        <%--<small>Member since Nov. 2012</small>--%>
                                    </p>
                                </li>
                                <!-- Menu Body -->
                                <li class="user-body">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">喜欢数 ${user.likes}</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">粉丝 ${user.fans}</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">关注 ${user.follows}</a>
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
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-7">
                    <!-- 发布文字 -->
                    <div class="box box-default" style="border:none;box-shadow: none;border-radius: 4px">
                        <div class="box-body">
                            <div class="row">
                                <div class="col-md-12">

                                    <form action="${APP_PATH}/article" method="post" id="publishForm"
                                          enctype="multipart/form-data">
                                        <div class="form-group">
                                            <textarea class="form-control" name="content" rows="3"
                                                      placeholder="Enter ..."></textarea>
                                        </div><!-- /.form-group -->

                                        <div class="box box-default collapsed-box"
                                             style="border:none;box-shadow: none;margin-bottom: 0;">
                                            <div class="box-header">
                                                <h3 class="box-title">
                                                    <span class="btn btn-box-tool"
                                                          onclick="document.getElementById('img_1').click();return false;">图片</span>
                                                    <input style="display: none" type="file" class="img" name="img"
                                                           id="img_1" accept="image/*" onchange="l(this)"/>
                                                    <span id="chooseTag" class="btn btn-box-tool"
                                                          data-widget="collapse">#标签#</span>
                                                    <span>${user.userid}</span>
                                                </h3>
                                                <div class="box-tools">

                                                </div><!-- /.box-tools -->
                                            </div><!-- /.box-header -->
                                            <div class="box-body" style="display: none;">
                                                <div class="form-group">
                                                    <%--<label>Minimal</label>--%>
                                                    <select id="selectIdTag" name="tagId" class="form-control select2"
                                                            style="width: 40%;">
                                                    </select>
                                                </div><!-- /.form-group -->
                                                <div class="form-group">
                                                    <div width="225px"><img src="" width="225px" id="1"/></div>
                                                </div>
                                                <div class="form-group">
                                                    <input id="publiskBtn" type="submit" value="发布">
                                                </div>
                                                <input type="text" name="userId" hidden="" value="${user.userid}">
                                            </div><!-- /.box-body -->

                                        </div>
                                    </form>
                                </div>
                            </div><!-- /.row -->
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                    <%--文字集合--%>
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
                            <h3 class="box-title">相似关注者</h3>
                        </div>
                        <div class="box-footer no-padding">
                            <ul class="users-list clearfix" id="recommondUserInfo">
                                <li>
                                    <img src="${APP_PATH}/static/img/user1-128x128.jpg" class="user-image" alt="User Image">
                                    <a class="users-list-name" href="#">Alexander Pierce</a>
                                    <span class="users-list-date"> + 关注</span>
                                </li>
                                <li>
                                    <img src="${APP_PATH}/static/img/user8-128x128.jpg" class="user-image"  alt="User Image">
                                    <a class="users-list-name" href="#">Norman</a>
                                    <span class="users-list-date" data-user="" data-result="" >已关注</span>
                                </li>
                            </ul><!-- /.users-list -->
                        </div><!-- /.box-body -->
                        <div class="box-footer text-center">
                            <a href="" class="uppercase">View All Users</a>
                        </div><!-- /.box-footer -->
                    </div>

                        <%--个人信息--%>
                        <div class="box box-default">
                            <div class="box-header with-border">
                                <i class="fa fa-user-o"></i>
                                <h3 class="box-title">个人信息</h3>
                            </div>
                            <div class="box-footer no-padding">
                                <ul class="nav nav-stacked">
                                    <li><a href="#">Projects <span class="pull-right badge bg-blue">31</span></a></li>
                                    <li><a href="#">Tasks <span class="pull-right badge bg-aqua">5</span></a></li>
                                    <li><a href="#">Completed Projects <span class="pull-right badge bg-green">12</span></a></li>
                                    <li><a href="#">Followers <span class="pull-right badge bg-red">842</span></a></li>
                                </ul>
                            </div>
                        </div>
                        <%--个人信息--%>
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.3.0
        </div>
        <strong>Copyright &copy; 2018 <a href="#">jian</a>.</strong> All rights reserved.
    </footer>
    <script type="text/javascript">
        /*
        * 全局变量
        * 当前用户id
        * 总记录数，当前页码
        * */
        var currentUserId;
        var totalRecord,currentPage;
        /*
        * Dom 加载完毕
        * - 初始化当前用户 id
        * - 加载文章信息
        * - end
        * */
        $(function () {
            currentUserId = ${user.userid};
            console.log("init User id : " + currentUserId);
            to_page(1);
        });
        /*
        * 评论
        * - 修改 input 默认回车提交事件。【通过加入冗余的 input控件】
        * - 点击按钮 -> 关闭/打开【评论内容 和 评论输入框】
        * - 两者处于关闭状态。点击，加载显示 【评论内容 和 评论输入框】。相反，关闭两者。
        * - 加载显示。如果 id 存在，根据id查找，评论内容。如果评论内容，为空，则隐藏该区域，仅显示输入框
        * */
        $(document).on("click", ".commentsBtn", function () {
            var dom = $(this);
            var titleid = dom.prop("data-toggle");
            var btnParent = dom.parent();
            var comments = btnParent.next();
            comments.toggle(200);
            comments.next().toggle(200);
            if (btnParent.next().is(':hidden')) {
                console.log("Comment input content is show,just hidden.");
            } else {
                console.log("Comment input content is hidden,show and load data.");
                if (titleid != null) {
                    $.ajax({
                        url: "${APP_PATH}/comment",
                        data: "id=" + titleid,
                        type: "POST",
                        success: function (result) {
                            if (result.code == 100) {
                                build_comment(result,comments);
                                if (btnParent.next().find(".box-comment").length < 1) {
                                    btnParent.next().hide();
                                }
                            }
                        }
                    });
                }
            }
        });
        /*关注用户
        * 点击 【.users-list-date】关注用户
        * 1. 根据 data-user="" 获取用户id，根据 data-result="""获取是否关注。
        * 2. 未关注。发送 userid 和 targetId 到后台, 修改当前标识，标识已经关注，修改文字显示 【已关注】
        *       1. 后台查找逻辑，如果已经关注，给出提示。
        *       2. 关注用户。
        * 3. 已关注。给出提示框，已经关注
        * */
        $(document).on("click", ".users-list-date", function () {
            var dom = $(this);
            /*ok 标识已经点击当前按钮*/
            if (dom.prop("data-result") === "ok"){
                // 已经关注
                alert("~已经关注");
            } else {
                // 未关注
                dom.html("已关注");
                dom.prop("data-result", "ok");
                // 发送请求
                $.ajax({
                    url: "${APP_PATH}/observe",
                    data: {followId:dom.prop("data-user"), userId: currentUserId},
                    type: "PUT",
                    success:function (result) {
                        if (result.code === 100){
                            // 关注
                            alert("关注成功!!!");
                            dom.prop("data-result", "ok");
                        }else{
                            // 未关注
                            alert(result.extend.info);
                        }
                    }
                });
            }
        });
        function build_comment(result, dom) {
            var commentsInfo = result.extend.comments;
            /*清空评论区的*/
            dom.empty();
            $.each(commentsInfo, function (index, item) {
                /*评论区域*/
                /*循环生成评论集合*/
                var comment = $("<div class=\"box-comment\"></div>");
                var cuserimg = $("<img class=\"img-circle img-sm\" src='' alt=\"user image\">");
                cuserimg.attr("src", "${APP_PATH}/static/img/" + item.user.userimg);
                var ctime = $("<span class=\"text-muted pull-right\"></span>").append(new Date(item.commentcreatetime).toLocaleTimeString());
                var cusername = $("<span class=\"username\"></span>").append(item.user.username).append(ctime);
                var cbody = $("<div class=\"comment-text\"></div>").append(cusername).append(item.commentbody);
                comment.append(cuserimg).append(cuserimg).append(cbody);
                comment.appendTo(dom);
            });
        }
        /*
        * 文章数据
        * 第pn页文章数据
        * */
        function to_page(pn) {
            $.ajax({
                url: "${APP_PATH}/read",
                data: "pn=" + pn,
                type: "GET",
                success: function (result) {
                    if (result.code == 100) {
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
                var commentInput = $("<input type=\"text\" class=\"form-control input-sm\" onkeydown='if(event.keyCode==13){saveComment($(this));}'  placeholder=\"Press enter to post comment\">").prop("data", item.articleid ).prop("userid", item.userid);
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
        function build_page_info(result){
            $("#page_info_area").empty();
            $("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页,总"+
                result.extend.pageInfo.pages+"页,总"+
                result.extend.pageInfo.total+"条记录");
            totalRecord = result.extend.pageInfo.total;
            currentPage = result.extend.pageInfo.pageNum;
        }
        /*
        * 解析显示分页条
        * - 点击分页要能去下一页
        * - 位于首页/尾页/当前页时，首页和尾页不可点击
        * - 有无前一页来决定能否前往前一页
        * */
        function build_page_nav(result){
            //page_nav_area
            $("#page_nav_area").empty();
            var ul = $("<ul></ul>").addClass("pagination");
            //构建元素
            var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
            var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
            if(result.extend.pageInfo.hasPreviousPage == false){
                firstPageLi.addClass("disabled");
                prePageLi.addClass("disabled");
            }else{
                //为元素添加点击翻页的事件
                firstPageLi.click(function(){
                    to_page(1);
                });
                prePageLi.click(function(){
                    to_page(result.extend.pageInfo.pageNum -1);
                });
            }
            var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
            var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
            if(result.extend.pageInfo.hasNextPage == false){
                nextPageLi.addClass("disabled");
                lastPageLi.addClass("disabled");
            }else{
                nextPageLi.click(function(){
                    to_page(result.extend.pageInfo.pageNum +1);
                });
                lastPageLi.click(function(){
                    to_page(result.extend.pageInfo.pages);
                });
            }
            //添加首页和前一页 的提示
            ul.append(firstPageLi).append(prePageLi);
            //1,2，3遍历给ul中添加页码提示
            $.each(result.extend.pageInfo.navigatepageNums,function(index,item){
                var numLi = $("<li></li>").append($("<a></a>").append(item));
                if(result.extend.pageInfo.pageNum == item){
                    numLi.addClass("active");
                }
                numLi.click(function(){
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
        /*
        * 保存评论
        * - 传入当前 按钮Dom
        * - 获取 【评论内容 、 用户id】
        * - put 提交评论后，清空评论输入框
        * */
        function saveComment(dom){
            var commentId  = dom.prop("data");
            var userid  = dom.prop("userid");
            var commentContent= dom.val();
            console.log(commentContent);
            console.log(commentId);
            if (commentContent.length > 1) {
                $.ajax({
                    url: "${APP_PATH}/comment",
                    data: {commentbody: commentContent, articleid: commentId, userid: userid},
                    type: "put",
                    success: function (result) {
                        if (result.code == 100) {
                            console.log(result);
                            // 使用 ajax 不经过后台直接插入一条评论
                            insertComment(commentContent, dom);
                            // 清空评论表单 input 中的数据
                            dom.val("");
                        }
                    }
                });
            }
        }
        /*
        * 插入一条评论
        * - 获取【姓名，时间，评论内容】
        * - 使用js在界面插入，然后数据保存到数据库
        * */
        function insertComment(commentContent, dom){
            var username = $("#userNameId").text();
            var userImg = $("#userImg").attr("src");
            var boxcomment = $("<div class=\"box-comment\"></div>")
            /*图片，时间，姓名，内容*/
            var cuimg = $("<img class=\"img-circle img-sm\" src=\"\" alt=\"user image\">").attr("src", userImg)
            var ctime = $("<span class=\"text-muted pull-right\"></span>").append(new Date().toLocaleString());
            var cname = $("<span class=\"username\"></span>").append(username).append(ctime);
            var ccontent = $("<div class=\"comment-text\"></div>").append(cname).append(commentContent);
            boxcomment.append(cuimg).append(ccontent);
            dom.parents().find(".commentBox").find(".box-comments").append(boxcomment);
        }
        /*点赞按钮
        * - 根据标识，判断是否可点击
        * - js 获取点赞数+1，将文章id发送到后台
        * */
        $(document).on("click", ".likeBtn", function () {
            var dom = $(this);
            if (dom.prop("data-click") != "ok") {
                var userId = dom.prop("user-id");
                var articleId = dom.prop("article-id");
                console.log("userId" + userId);
                console.log("articleId" + articleId);
                if (userId != null && articleId != null) {
                    $.ajax({
                        url: "${APP_PATH}/like",
                        data: {userId: userId, articleId: articleId},
                        type: "post",
                        success: function (result) {
                            if (result.code == 100) {
                                console.log(result);
                                var spanNumdom = dom.parent().find(".spanLikeNum");
                                var num = parseInt(spanNumdom.text())+1;
                                spanNumdom.html(num);
                                console.log("num :" + num);
                                dom.prop("data-click", "ok");
                            }else{
                                console.log(result.extend.info);
                                alert(result.extend.info)
                                dom.prop("data-click", "ok");
                            }
                        }
                    });
                }
                return;
            }
            alert("~你已经点过赞了!");
        });
        /* 输入候选框
         * - 输入关键词，匹配关键词相应的【标签】
         * */
        $(".select2").select2({
            ajax: {
                url: '${APP_PATH}/tag',
                type: "POST",
                delay: 1000,
                data: function (params) {
                    return "tagName=" + params.term;
                },
                processResults: function (data, params) {
                    console.log(data);
                    if (data.code == 100) {
                        return {results: data.extend.tags};
                    }
                    return {results: []};
                },
                cache: true
            },
            placeholder: '输入标签',
            escapeMarkup: function (markup) {
                return markup;
            }, // let our custom formatter work
            minimumInputLength: 1,
            templateResult: formatRepo,
            templateSelection: formatRepoSelection
        });
        /*
        * 输入框
        * - 正在搜索时，提示信息
        * - 搜索成公司时，显示文本
        * */
        function formatRepo(repo) {
            console.log(repo);
            if (repo.loading) {
                return "搜索···";
            }
            return "<div class='select2-result-repository clearfix'>" + repo.text + "</div>";
        }
        /*
        * 输入框+下拉选择框，解析文本
        * */
        function formatRepoSelection(repo) {
            return repo.text;
        }
        /*文件上传*/
        function l(evn) {
            var name = event.target.files[0].name;//获取上传的文件名
            var divObj = $(evn).prev()  //获取div的DOM对象
            $(divObj).html(name) //插入文件名
            var id = $(evn).attr('id');//获取id
            var num = id.substr(4, 1)
            var file = event.target.files[0];
            if (window.FileReader) {
                var reader = new FileReader();
                reader.readAsDataURL(file);
                //监听文件读取结束后事件
                reader.onloadend = function (e) {
                    $("#" + num).attr("src", e.target.result);    //e.target.result就是最后的路径地址
                };
            }
        }
    </script>
</div><!-- ./wrapper -->
</body>
</html>