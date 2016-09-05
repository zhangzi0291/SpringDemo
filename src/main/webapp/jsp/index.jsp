<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
<%@include file="jstool.jsp"%>
<style type="text/css">
	body{
		background-color: gray;
	}
	.container{
		width: 99%;
	}
	.container>div{
		display: inline-block;
		text-align: center;
	}
	.middle{
		width: 1%;
		display:table-cell;
		vertical-align:middle;
		text-align:center;
		background-color: blue;
		height: 5rem;
	}
	.t{
		width: 100%;
		height: 25rem;
		background-color: silver;
	}
	.context{
		width: 100%;
		background-color: aqua;
	}
</style>
</head>
<body>
	<%@include file="top.jsp"%>
	<div class="container">
	<dv class="middle">收入：</dv>
	<dv class="middle">支出：</dv>
	<dv class="middle">本月收支：</dv>
	<div class="t" ></div>
	<div class="context">
		<button type="button">添加纪录</button>
	</div>
	</div>
</body>
</html>