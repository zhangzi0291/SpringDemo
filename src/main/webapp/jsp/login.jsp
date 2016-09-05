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
<title>登陆</title>
<%@include file="jstool.jsp" %>
<style>

.container {
	width: 400px;
}
font{
	color: red;
	font-family: 微软雅黑;
}
body{
	background-color: #66ccff;
}
.error{
	color: red;
}
.t{
	color: black;
	font-size: 40px;
 	font-style: 微软雅黑; 
 	overflow:hidden;
 	text-align: center;
}
</style>
<script type="text/javascript">
$(function(){
	$("#register").on('click',function(){
		window.location.href="toRegister";
	})
	$("#loginform").easyform()
})
function checkuser(){
		$.ajax({
			type: "POST",
			url:"checkusername" ,
			data:"username="+$("#inputUsername").val(),
			dateType:"json",
			success: function(date){
				console.log("success")
				if(date=="false"){
					$("#inputUsername").trigger("easyform-ajax", false);
				}else{
					$("#inputUsername").trigger("easyform-ajax", true);
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
		data:"username="+$("#inputUsername").val()+"&userpwd="+$("#inputPassword").val(),
		dateType:"json",
		success: function(date){
			console.log("success login")
			if(date=="false"){
				$("#inputPassword").trigger("easyform-ajax", false);
			}else{
				$("#inputPassword").trigger("easyform-ajax", true);
			}
		},
		error:function(){
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

		<form id="loginform" class="form-signin" action="${pageContext.request.contextPath}/login" method="POST">
			<br><br><br><br>
			<h2 class="form-signin-heading">
				<b>登陆</b>
			</h2><br>
			<label for="inputUsername" class="sr-only">Username</label> <input
				type="text"  name="userName"id="inputUsername" class="form-control"
				placeholder="请输入用户名" 
				data-easyform="char-normal;real-time;ajax:checkuser()"
				data-easytip="position:right;class:easy-blue;"
				data-message="不能为空且用户名必是英文字母或数字"
				data-message-ajax="用户不存在!"
				 autofocus>
			<label for="inputPassword" class="sr-only">Password</label> <input
				type="password"  name="userPwd"  id="inputPassword" class="form-control"
				data-easyform="char-normal;ajax:checklogin()"
				data-message="密码不能为空"
				data-easytip="position:right;class:easy-blue;"
				data-message-ajax="用户名或密码错误"
				placeholder="请输入密码" >
			<br>
			<div class="buttons">
			<input id="login" class="btn btn-lg btn-primary btn-block" type="submit"  value="登陆" >
			<button id="register" class="btn btn-lg btn-primary btn-block" type="button">注册</button>
			</div>
		</form>
	</div>
	<!-- /container -->
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
