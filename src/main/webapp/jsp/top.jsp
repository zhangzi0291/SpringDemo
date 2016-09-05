<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">
.top {
	width: 100%;
	height: 60px;
	background: #333333;
}

.left-top {
	padding-left: 20px;
	color: white;
	font-size: 30px;
}

.right-top {
	color: white;
	text-align: center;
	float: right;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#time").html(new Date().toLocaleString())
		setInterval(function() {
			$("#time").html(new Date().toLocaleString())
		}, 1000)
	})
</script>
<header>
	<div class="container">
		<div class="top">
			<span class="left-top"> 管理 </span> <span class="right-top">
				系统时间：<br> <strong id="time"></strong>
			</span> <span class="right-top"> &nbsp;欢迎您，${username}&nbsp;<br>
				<strong><a href="${pageContext.request.contextPath}/exit">退出</a></strong>
			</span>
		</div>
	</div>
</header>