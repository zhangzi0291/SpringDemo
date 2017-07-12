<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>${title }</title>
<jsp:include page="/jsp/csstool.jsp" flush="true"/>
</head>
<body class="skin-blue fixed">
<jsp:include page="/jsp/header.jsp" flush="true"/>
<div class="wrapper">

<jsp:include page="/jsp/menu.jsp" flush="true"/>

<aside class="control-sidebar control-sidebar-dark"></aside>
<div class="control-sidebar-bg"></div>

<div class="content-wrapper">
	<section class="content">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<div class="box-title">新增用户</div>
				</div>
				<div class="box-body">
					<form action="${basePath }/role/add.json" method="post" class="form-horizontal">
						<c:if test="${not empty error}">
							<div class="red">${error }</div>
						</c:if>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="userAccount">用户账号</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="userAccount">
	                        </div>
	                    </div>
						<div class="form-group" >
							<label class="col-sm-2 control-label" for="userPassword">密码</label>
	                        <div class="col-sm-10">
	                        	<input type="password" class="form-control" name="userPassword" id="userPassword">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="reUserPassword">重复密码</label>
	                        <div class="col-sm-10">
	                        	<input type="password" class="form-control" name="reUserPassword" id="reUserPassword">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="userName">用户名称</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="userName">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="userDept">公司</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="userDept">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="userDuty">职业</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="userDuty" >
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="userDept">备注</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="userDept">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="file">上传头像</label>
	                        <div class="col-sm-10">
	                        	<input type="file" class="form-control" name="file">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">关联角色</label>
	                        <div class="col-sm-10">
	                        </div>
							<label class="col-sm-2 control-label"></label>
	                        <div class="col-sm-10" id="roleLink">
	                        	
	                        </div>
	                    </div>
						<div class="hr-line-dashed"></div>
						<div class="align-right">
							<input id="save" type="submit" class="btn btn-primary" value="保存" >
							<input id="back" type="button" class="btn btn-warning" value="返回">
						</div>
					</form>
				</div>	
			</div>
		</div>
	</section>
</div>

<jsp:include page="/jsp/footer.jsp" flush="true"/>
</body>
<jsp:include page="/jsp/jstool.jsp" flush="true"/>
<script type="text/javascript">
$(function(){
	initEvent();
})
function initEvent(){
	var reUserPasswordTip = $("#userPassword").easytip({position:top});
	reUserPasswordTip.show("daa");
	$("#reUserPassword").on("blur",function(){
		var password = $("#userPassword").val();
		if(password!=""){
			reUserPasswordTip.show("d");
		}
	})
	$("#back").on("click",function(){
		window.history.go(-1)
	})
	$.ajax({
		type:"POST",
		url:basePath+"/role/getRole.json",
		success:function(data){
			roleLink = $("#roleLink");
			html = "";
			for(var i in data){
				html +='<div class="col-md-4">                                                                                       '
				html +='	<div class="box box-default">                                                                                      '
				html +='  		<div class="box-body">                                                                                           '
				html +='    		<div class="row">                                                                                              '
				html +='				<div class="col-md-12">  '
				html +='				<input type="checkbox" name="roleIds" value="'+data[i].roleId+'" /> '+data[i].roleName
				html +='				</div>                                                                                                         '
				html +='			</div>                                                                                                         '
				html +='		</div>                                                                                                           '
				html +='	</div>  '
				html +='</div>                  '
			}
			roleLink.append(html)
			initCheckBox()
			resizeContent()
		}
	})
}

</script>
</html>
