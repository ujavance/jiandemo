<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>auj | 404错误</title>
    <script type="text/javascript" src="${APP_PATH }/static/js/jquery-2.1.4.min.js"></script>
    <link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${APP_PATH }/static/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH }/static/css/AdminLTE.min.css">
    <link rel="stylesheet" href="${APP_PATH }/static/css/_all-skins.min.css">
    <link rel="stylesheet" href="${APP_PATH }/static/plugins/iCheck/flat/blue.css">
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
        <a href="/" class="logo" style="border-right: none;">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>Jian</b></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>Jian</b></span>
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


    <!-- Content Wrapper. Contains page content -->
    <div class="" style="min-height: 1096px;">
        <div class="error-page">
            <h2 class="headline text-yellow"> 404</h2>
            <div class="error-content">
                <h3><i class="fa fa-warning text-yellow"></i> Oops! Page not found.</h3>
                <p>
                    We could not find the page you were looking for.
                    Meanwhile, you may <a href="../../index.html">return to dashboard</a> or try using the search form.
                </p>
                <form class="search-form">
                    <div class="input-group">
                        <input type="text" name="search" class="form-control" placeholder="Search">
                        <div class="input-group-btn">
                            <button type="submit" name="submit" class="btn btn-warning btn-flat"><i class="fa fa-search"></i></button>
                        </div>
                    </div><!-- /.input-group -->
                </form>
            </div><!-- /.error-content -->
        </div><!-- /.error-page -->


    </div>
    <!-- /.content-wrapper -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 2.3.0
        </div>
        <strong>Copyright &copy; 2018 <a href="#">jian</a>.</strong> All rights reserved.
    </footer>
</div><!-- ./wrapper -->

 </body>
</html>