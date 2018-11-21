<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>auj | Jian</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <script type="text/javascript" src="${APP_PATH }/static/js/jquery-2.1.4.min.js"></script>
    <link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${APP_PATH }/static/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH }/static/css/AdminLTE.min.css">
    <link rel="stylesheet" href="${APP_PATH }/static/css/_all-skins.min.css">
    <script src="${APP_PATH }/static/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${APP_PATH }/static/js/app.min.js"></script>
    <style type="text/css">
        span.glyphicon{
            padding-right: 0.2rem;
        }
    </style>
</head>


<body class="sidebar-mini  skin-black-light layout-boxed">


<div class="wrapper">
    <header class="main-header">
        <!-- Logo -->
        <a href="../../index2.html" class="logo" style="border-right: none;">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>Jian</b></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>Jian</b>管理</span>
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button" style="display: none">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>

        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="${APP_PATH }/static/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>Alexander Pierce</p>
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">

                <li class="">
                    <a href="#">
                        <i class="fa fa-book"></i> <span>我的文章</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="#"><i class="fa fa-file-picture-o"></i> <span>日记</span></a></li>
                        <li><a href="#"><i class="fa fa-file-sound-o"></i> <span>随笔</span></a></li>
                        <li><a href="#"><i class="fa fa-file-video-o"></i> <span>一件小事</span></a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa-comments-o"></i>  <span>最近消息</span>
                    </a>
                </li>
                <%--<li class="header">最近浏览</li>--%>
                <%--<li>--%>
                <%--<a href="#">--%>
                <%--<i class="fa fa-tag "></i><span>喜欢数</span>--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<a href="#">--%>
                <%--<i class="fa fa-tag "></i><span>粉丝</span>--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<a href="#">--%>
                <%--<i class="fa fa-tag "></i><span>换肤</span>--%>
                <%--</a>--%>
                <%--</li>--%>

                <li>
                    <a href="${APP_PATH}/quit">
                        <i class="fa fa-tag "></i>  <span>退出登录</span>
                    </a>
                </li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-md-12">





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
</div><!-- ./wrapper -->

<!--弹出框-->
<!-- 按钮触发模态框 -->
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="modal-title">分享<i id="sharefileName">java 入门</i></h4>
            </div>
            <div class="modal-body">
                <p>One fine body…</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>&lt;!&ndash; /.modal-content &ndash;&gt;
    </div>&lt;!&ndash; /.modal-dialog &ndash;&gt;
</div>
</body>
</html>