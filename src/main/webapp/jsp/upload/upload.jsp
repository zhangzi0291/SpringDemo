<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<%@include file="../csstool.jsp"%>
	<style type="text/css">
	
	</style>
</head>
<body class="skin-blue fixed">
<div class="wrapper">
<jsp:include page="/jsp/header.jsp" flush="true"/>
<jsp:include page="/jsp/menu.jsp" flush="true"/>
<div class="content-wrapper">
	<section class="content">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<div class="box-title"><h2>文件上传</h2></div>
				</div>
				<div class="box-body">
					<form action="" method="post" enctype="application/x-www-form-urlencoded" >
						<div class="form-group">
							<label for="inputfile">文件输入</label>
						    <input type="file" id="file">
						</div>
					</form>
						<div class="col-xs-12">
							<button id="btn" class="btn btn-primary" style="width:auto;display:inline-block;">上传</button>   
						</div>
				</div>
			</div>
		</div>
	</section>
</div>
</div>
</body>
<%@include file="../jstool.jsp"%>
<script type="text/javascript">
$(function(){
	var url="${basePath}/upload";
	$("#btn").on("click",function(){
		upload("btn","file",url);
	})
})

</script>
</html>