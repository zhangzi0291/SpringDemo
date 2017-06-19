<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>注册</title>
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
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="../../index2.html"><b>平台</b></a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">请填写个人信息</p>

    <form id="registerForm" action="${basePath }/register" method="post">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="用户名" name="userName" id="username"
        		data-easyform="char-normal;real-time;ajax:checkuser()"
				data-easytip="position:right;class:easy-blue;"
				data-message="不能为空且用户名必是英文字母或数字"
				data-message-ajax="用户名已存在!">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="email" class="form-control" placeholder="邮箱" name="userEmail" 
        		data-easyform="email;real-time;"
        		data-easytip="position:right;class:easy-blue;"
        		data-message="邮箱格式错误">
        <span class="glyphicon glyphicon-envelope form-control-feedback" ></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="密码" name="userPwd" id="password"
        		data-easyform="length:4 16;char-normal;real-time;"
				data-message="密码必须为4—16位"
                data-easytip="position:right;class:easy-blue;">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" placeholder="重复密码"
        		data-easyform="length:4 16;char-normal;real-time;equal:#password;"
				data-message="密码不一致"
                data-easytip="position:right;class:easy-blue;">
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <select class="form-control"  name="userProfession">
        	<option value="">职业</option>
        	<option value="学生">学生</option>
        	<option value="职员">职员</option>
        	<option value="个体户">个体户</option>
        	<option value="自由职业">自由职业</option>
        </select>
        <span class="glyphicon glyphicon-user  form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="真实姓名" name="realName"
        		data-easyform="char-chinese;real-time;"
        		data-easytip="position:right;class:easy-blue;"
        		data-message="含有非法字符">
        <span class="glyphicon glyphicon-user  form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" placeholder="身份证号码" name="idNumber"
        		data-easyform="length:15 18;number;real-time;"
        		data-easytip="position:right;class:easy-blue;"
        		data-message="身份证为15或18位数字">
        <span class="glyphicon glyphicon-user  form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox" id="check">我同意本平台 <a href="#">协议</a>
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <input type="submit" class="btn btn-primary btn-block btn-flat" value="注册" />
        </div>
        <!-- /.col -->
      </div>
    </form>

    已经拥有账号，<a href="login.html" class="text-center">点击登陆</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<%@include file="../jstool.jsp"%>

<script>
  $(function () {
    $('#check').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
    initEvent();
  });
function initEvent(){
	$("#registerForm").easyform()
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
				$("#username").trigger("easyform-ajax", true);
			}else{
				$("#username").trigger("easyform-ajax", false);
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
