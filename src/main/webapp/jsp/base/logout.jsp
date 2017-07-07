<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
<%@include file="../csstool.jsp"%>
<style type="text/css">
.onclick{
	cursor:pointer;
}
</style>
</head>
<body class="skin-blue fixed">
<div class="wrapper">

<aside class="control-sidebar control-sidebar-dark"></aside>
<div class="control-sidebar-bg"></div>

<div class="content-wrapper">
	<!-- Main content -->
    <section class="content">
      <div class="error-page">
        <h2 class="headline text-yellow">已退出</h2>

        <div class="error-content">
        	<h3><br></h3>
          <p>
           <i class="fa fa-warning text-yellow"></i> 您已经退出系统
          </p>
          <form class="search-form">
            <div class="input-group">
                <p><span id="time"></span>秒后返回登陆页面</p>
            </div>
            <!-- /.input-group -->
          </form>
        </div>
        <!-- /.error-content -->
      </div>
      <!-- /.error-page -->
    </section>
</div>
</body>
<%@include file="../jstool.jsp"%>
<script type="text/javascript">
	var leftTime = 3000
	$("#time").html(leftTime/1000);
	window.setInterval(function(){
		leftTime = leftTime-1000
		var time = leftTime/1000
		$("#time").html(time);
	},1000);
	window.setTimeout(function(){
		window.location.href=basePath+"/login.html"
	},leftTime)
</script>
</html>
