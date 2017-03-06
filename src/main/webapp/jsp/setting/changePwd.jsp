<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>${title}</title>
<%@include file="../csstool.jsp"%>
<style type="text/css">
.onclick{
	cursor:pointer;
}
.search-high{
	height: 30px;
	margin-bottom: 6px;
}
.queryBox{
  padding-left:0;
  padding-right:0;
}
.left-addon{
	width: 100px;
}
</style>
</head>
<body class="skin-blue fixed">
<div class="wrapper">

<jsp:include page="/jsp/header.jsp" flush="true"/>
<jsp:include page="/jsp/menu.jsp" flush="true"/>

<aside class="control-sidebar control-sidebar-dark"></aside>
<div class="control-sidebar-bg"></div>

<div class="content-wrapper">
	<section class="content">
		<div class="col-xs-12">
			<div class="box box-primary">
				<div class="box-header">
					<div class="box-title">修改密码</div>
				</div>
				 <form action="${basePath }/user/edituser.json">
				<div class="box-body">
					<div class="box-header with-border">
<!-- 		              <h3 class="box-title">新建融资</h3> -->
		            </div>
		            <div class="box-body">
		          	 <input type="hidden" class="form-control"  name="id"  value="${user.id}"
		                		placeholder="融资金额">
		              <div class="input-group">
		                <span class="input-group-addon left-addon">旧密码</span>
		              	<input type="password" class="form-control" placeholder="密码" id="oldpassword"
					        name="oldpassword"
			        		data-easyform="char-normal;ajax:checklogin();real-time;"
							data-message="密码不能为空"
							data-easytip="position:right;class:easy-blue;"
							data-message-ajax="密码错误">
		                <span class="input-group-addon"></span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon">新密码</span>
		              	<input type="password" class="form-control" placeholder="密码" name="userPwd" id="password"
			        		data-easyform="length:4 16;char-normal;real-time;"
							data-message="密码必须为4—16位"
			                data-easytip="position:right;class:easy-blue;">
		                <span class="input-group-addon"></span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon">新密码</span>
		              	<input type="password" class="form-control" placeholder="重复密码"
			        		data-easyform="length:4 16;char-normal;real-time;equal:#password;"
							data-message="密码不一致"
			                data-easytip="position:right;class:easy-blue;">
		                <span class="input-group-addon"></span>
		              </div>
		              <br>
		              
		              
		            </div>
				</div>
				<div class="box-footer">
					<input class="btn btn-info pull-right" type="submit"  value="提交"  >
				</div>
				</form>
			</div>
		</div>
	</section>
</div>
</body>
<%@include file="../jstool.jsp"%>
<script type="text/javascript">
$(function(){
	intiPage();
	initTable();
	initEvent();
})
function intiPage(){
	$( "#repaymentDate" ).datepicker({
		format: "yyyy-mm-dd",
		language:"zh-CN",
		todayHighlight:true,
		startDate:new Date()
	});
}
function initEvent(){
	$("form").easyform()
}
function initTable(){
}

function checklogin(){
	$.ajax({
		type: "POST",
		url:"checkPwd" ,
		data:"password="+$("#oldpassword").val(),
		dateType:"json",
		success: function(date){
			console.log("success login")
			if(date=="false"){
				$("#oldpassword").trigger("easyform-ajax", false);
			}else{
				$("#oldpassword").trigger("easyform-ajax", true);
			}
		},
		error:function(){
			console.log("error")
		}
	})
}
</script>
</html>
