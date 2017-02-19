<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>登陆</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <%@include file="../csstool.jsp"%>
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <b>在线投融资</b>信息平台
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">请先登陆系统</p>

    <form id="loginForm" action="${basePath }/login" method="post">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="用户名" id="username"
        		name="username"
				data-easyform="char-normal;real-time;ajax:checkuser()"
				data-easytip="position:right;class:easy-blue;"
				data-message="不能为空且用户名必是英文字母或数字"
				data-message-ajax="用户不存在!"
				autofocus>
        <span class="glyphicon glyphicon-user  form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="密码" id="password"
		        name="password"
        		data-easyform="char-normal;ajax:checklogin()"
				data-message="密码不能为空"
				data-easytip="position:right;class:easy-blue;"
				data-message-ajax="用户名或密码错误">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox" id="remember" name="remember"
              data-easyform="null;"/> 记住我
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <input type="submit" class="btn btn-primary btn-block btn-flat" id="login" value="登陆"/>
        </div>
        <!-- /.col -->
      </div>
    </form>
   
    还没有账号，<a href="register.html" class="text-center">请注册</a>

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->


<%@include file="../jstool.jsp"%>
<script>
$(function () {
  $('#remember').iCheck({
    checkboxClass: 'icheckbox_square-blue',
    radioClass: 'iradio_square-blue',
    increaseArea: '20%' // optional
  });
  initEvent()
  
});
function initEvent(){
	$("#loginForm").easyform()
	$("#login").on("click",function(){
	 var username = $("#username").val()
	 var password = $("#password").val()
	 var remember = $("#remember").val()
	})
}


function checkuser(){
	$.ajax({
		type: "POST",
		url:"checkusername" ,
		data:"username="+$("#username").val(),
		dateType:"json",
		success: function(date){
			console.log("success")
			if(date=="false"){
				$("#username").trigger("easyform-ajax", false);
			}else{
				$("#username").trigger("easyform-ajax", true);
			}
		},
		error:function(){
			console.log("error")
		}
	})
}
function checklogin(){
$.ajax({
	type: "POST",
	url:"checklogin" ,
	data:"username="+$("#username").val()+"&password="+$("#password").val(),
	dateType:"json",
	success: function(date){
		console.log("success login")
		if(date=="false"){
			$("#password").trigger("easyform-ajax", false);
		}else{
			$("#password").trigger("easyform-ajax", true);
		}
	},
	error:function(){
		console.log("error")
	}
})
}
</script>
</body>
</html>
