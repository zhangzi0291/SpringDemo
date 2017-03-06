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
					<div class="box-title">黑名单详细信息</div>
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
		                <span class="input-group-addon left-addon">用户名</span>
		              <input type="text" class="form-control" placeholder="用户名" name="userName" id="username" 
		              	value="${user.userName }" readonly>
		                <span class="input-group-addon"></span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon">邮箱</span>
		                <input type="email" class="form-control" placeholder="邮箱" name="userEmail" 
		                	value="${user.userEmail }" readonly>
		                <span class="input-group-addon"></span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon">职业</span>
		               <select class="form-control"  name="userProfession" disabled>
				        	<option value="学生"  ${user.userProfession=='学生'?'selected':'' }>学生</option>
				        	<option value="职员" ${user.userProfession=='职员'?'selected':'' }>职员</option>
				        	<option value="个体户" ${user.userProfession=='个体户'?'selected':'' }>个体户</option>
				        	<option value="自由职业" ${user.userProfession=='自由职业'?'selected':'' }>自由职业</option>
				        </select>
		                <span class="input-group-addon"></span>
		              </div>
		              <br>
		              <div class="input-group">
		                <span class="input-group-addon left-addon">备注</span>
						<textarea class="form-control" rows="6"  readonly>${info.remark}</textarea>
						<span class="input-group-addon"></span>
		              </div>
		              
		            </div>
				</div>
				<div class="box-footer">
<!-- 					<input class="btn btn-info pull-right" type="submit"  value="提交"  > -->
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
	
}
function initTable(){
}

</script>
</html>
