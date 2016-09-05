<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<title>注册</title>
<%@include file="jstool.jsp"%>
<style>
.t {
	color: black;
	font-size: 40px;
	font-style: 微软雅黑;
	overflow: hidden;
	text-align: center;
}

.container {
	width: 400px;
}

font {
	color: red;
	font-family: 微软雅黑;
}

body {
	background-color: #66ccff;
}

.error {
	color: red;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#login").on('click', function() {
			window.location.href = "toLogin";
		})
		$("#loginform").easyform()
	})
	function checkuser() {
		$.ajax({
			type : "POST",
			url : "checkusername",
			data : "username=" + $("#inputUsername").val(),
			dateType : "json",
			success : function(date) {
				console.log("success")
				if (date == "false") {
					$("#inputUsername").trigger("easyform-ajax", true);
				} else {
					$("#inputUsername").trigger("easyform-ajax", false);
				}
			},
			error : function() {
				console.log("error")
			}
		})
	}
</script>
</head>
<body>
	<div class="t">
		<strong>欢迎使用管理系统</strong>
	</div>
	<div class="container">

		<form id="loginform" class="form-signin" action="${basePath}/register"
			method="POST">
			<br>
			<br>
			<br>
			<br>
			<h2 class="form-signin-heading">
				<b>注册</b>
			</h2>
			<br> <label for="inputUsername" class="sr-only">Username</label>
			<input type="text" name="userName" id="inputUsername"
				class="form-control"
				data-easyform="char-normal;real-time;ajax:checkuser()"
				data-easytip="position:right;class:easy-blue;"
				data-message="不能为空且用户名必是英文字母或数字" data-message-ajax="用户名已存在!"
				placeholder="请输入用户名"> <label for="inputPassword"
				class="sr-only">Password</label> <input type="password"
				name="userPwd" id="inputPassword" class="form-control"
				data-easyform="length:4 16;char-normal;real-time;"
				data-message="密码必须为4—16位"
				data-easytip="position:right;class:easy-blue;" placeholder="请输入密码">

			<label for="inputRePassword" class="sr-only">Password</label> <input
				type="password" name="repwd" id="inputRePassword"
				class="form-control"
				data-easyform="length:4 16;char-normal;real-time;equal:#inputPassword;"
				data-message="密码不一致" data-easytip="position:right;class:easy-blue;"
				placeholder="重复密码"> <label for="realName" class="sr-only">realName</label>
			<input type="text" name="realName" id="realName" class="form-control"
				data-easyform="null;" placeholder="真实名称（选填）"> <label
				for="mobilePhone" class="sr-only">mobilePhone</label> <input
				type="text" name="mobilePhone" id="mobilePhone" class="form-control"
				data-easyform="null;" placeholder="手机号码（选填）"> <label
				for="address" class="sr-only">address</label> <input type="text"
				name="address" id="address" class="form-control"
				data-easyform="null;" placeholder="地址（选填）"> <br> <input
				id="register" class="btn btn-lg btn-primary btn-block" type="submit"
				value="注册">
			<button id="login" class="btn btn-lg btn-primary btn-block"
				type="button">登陆</button>
		</form>
	</div>
	<!-- /container -->
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
