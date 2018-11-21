<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- Standard Meta -->
    <meta charset="utf-8" />
    <title>Jian | 登录</title>
    <link href="${APP_PATH }/static/css/semantic.min.css" rel="stylesheet" />
    <link href="${APP_PATH }/static/css/main.css" rel="stylesheet" />
    <script src="${APP_PATH }/static/js/jquery-2.1.4.min.js"></script>
    <style type="text/css">
        .help-block{
            color: #ff3000;
            font-style: italic;
        }
        .ui.fluid.icon.input.has-success input {
            border: 1px solid #21ba45;
        }
        .ui.fluid.icon.input.has-error input {
            border: 1px solid #ff3000;
        }
    </style>
</head>
<body>
<div class="ui container" style="padding-top:10%">
    <div class="ui grid center aligned">
        <div class="row">
            <div class="sixteen wide tablet six wide computer column">
                <div class="ui left aligned segment">
                    <form id="loginForm">
                        <div id="form1" class="ui form">

                            <h1 class="ui header center aligned">
                                <div class="content">

                                </div>
                            </h1>

                            <div class="field">
                                <label>
                                    Email or Username:
                                </label>
                                <div class="ui fluid icon input">
                                    <input name="username" id="u_name" type="text" autocomplete="off" style="width:100%!important;min-width:100%;width:100%;">
                                    <i class="icon mail outline"></i>
                                </div>
                                <span id="helpName" class="help-block"></span>
                            </div>
                            <div class="field">
                                <label>
                                    Password:
                                </label>
                                <div class="ui fluid icon input">
                                    <input name="password" id="u_pass" type="password" autocomplete="off" style="width:100%!important;min-width:100%;width:100%;">
                                    <i class="icon key"></i>
                                </div>
                                <span  id="helpPassword" class="help-block"></span>
                            </div>
                            <div class="field">
                                <label>
                                    Repead Password:
                                </label>
                                <div class="ui fluid icon input">
                                    <input id="r_pass" type="password" autocomplete="off" style="width:100%!important;min-width:100%;width:100%;">
                                    <i class="icon key"></i>
                                </div>
                            </div>
                            <div class="field">


                                <a  class="ui teal right labeled icon button fluid" ajax-va="error" href="${APP_PATH}/login">
                                    Login
                                    <i class="icon sign in"></i>
                                </a>

                                <a id="login" onclick="login()" class="ui blue right labeled icon button fluid" >
                                    Sign Up
                                    <i class="icon spy"></i>
                                </a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<script>
    var colors = ["#F25F5C", "#247BA0", "#8e44ad", "#ED6A5A", "#32936F", "#2c3e50", "#E83F6F", "#32936F", "#2E294E"];
    var rand = Math.floor(Math.random() * colors.length);
    $('body').css("background-color", colors[rand]);
</script>
<script type="text/javascript">


    function login() {
        if(!validateUser()){
            return false;
        };
        if($("#login").attr("ajax-va")=="error"){
            return false;
        }
        if ($("#r_pass").val() != $("#u_pass")) {
            return false;
        }
        $.ajax({
            url:"${APP_PATH}/user",
            type:"PUT",
            data: $("#loginForm").serialize(),
            success:function(result){
                console.log(result);
            }
        });
    }

    //校验用户名是否可用
    $("#u_name").change(function(){
        //发送ajax请求校验用户名是否可用
        var userName = this.value;
        $.ajax({
            url:"${APP_PATH}/user",
            data:"username="+userName,
            type:"GET",
            success:function(result){
                if(result.code==100){
                    // show_validate_msg("#u_name","success","用户名可用");
                    $("#login").attr("ajax-va","success");
                }else{
                    show_validate_msg("#u_name","error", "用户名不可用");
                    $("#login").attr("ajax-va","error");
                }
            }
        });
    });

    //校验表单数据
    function validateUser(){
        //1、拿到要校验的数据，使用正则表达式
        var empName = $("#u_name").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        if(!regName.test(empName)){
            //alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
            show_validate_msg("#u_name", "error", "用户名可以是2-5位中文或者6-16位英文和数字的组合");
            return false;
        }else{
            show_validate_msg("#u_name", "success", "");
        };

        //2、校验密码信息
        var passwordValue = $("#u_pass").val();
        var regPassword = /(^[a-zA-Z0-9_-]{3,6}$)/;
        if(!regPassword.test(passwordValue)){
            //alert("邮箱格式不正确");
            //应该清空这个元素之前的样式
            show_validate_msg("#u_pass", "error", "密码长度为3-6位英文和数字的组合");
            /* $("#email_add_input").parent().addClass("has-error");
            $("#email_add_input").next("span").text("邮箱格式不正确"); */
            return false;
        }else{
            show_validate_msg("#u_pass", "success", "");
        }
        return true;
    }

    //显示校验结果的提示信息
    function show_validate_msg(ele,status,msg){
        //清除当前元素的校验状态
        $(ele).parent().removeClass("has-success has-error");
        $(ele).parent().next("span").text("");
        if("success"==status){
            $(ele).parent().addClass("has-success");
            $(ele).parent().next("span").text(msg);
        }else if("error" == status){
            $(ele).parent().addClass("has-error");
            $(ele).parent().next("span").text(msg);
        }
    }
</script>

</body>
</html>


