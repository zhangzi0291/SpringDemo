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
					<div class="box-title">编辑用户</div>
				</div>
					<div class="box-body">
					<form action="${basePath }/user/edit.json" method="post" class="form-horizontal" enctype="multipart/form-data" >
						<c:if test="${not empty error}">
							<div class="red">${error }</div>
						</c:if>
						<input type="hidden" class="form-control" name="userId"  id="userId" value="${info.userId }">
						<div class="form-group">
							<label class="col-sm-2 control-label" for="userAccount">用户账号</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="userAccount"  id="userAccount" value="${info.userAccount }" readonly 
	                        		data-easyform="char-normal;real-time;"
									data-message-char-normal="用户账号是英文字母或数字"
									data-message-ajax="用户已存在!">
	                        </div>
	                    </div>
						<div class="form-group" >
							<label class="col-sm-2 control-label" for="userPassword">密码</label>
	                        <div class="col-sm-10">
	                        	<input type="password" class="form-control" name="userPassword" id="userPassword" 
	                        		data-easyform="null;length:4 16;char-normal;"
									data-message-length="长度为4-16">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="reUserPassword">重复密码</label>
	                        <div class="col-sm-10">
	                        	<input type="password" class="form-control" name="reUserPassword" id="reUserPassword" 
	                        		data-easyform="equal:#userPassword;"
									data-message="密码不一致">
	                        </div>
	                    </div>
	                    <div class="form-group">
							<label class="col-sm-2 control-label">是否启用</label>
	                        <div class="col-sm-10">
	                        	<input type="radio" name="enable" value="1"  <c:if test="${info.enable == '1' }">checked </c:if>>是 &nbsp;&nbsp;
	                        	<input type="radio" name="enable" value="0" <c:if test="${info.enable != '1' }">checked </c:if> >否
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="userName">用户名称</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="userName" data-easyform="real-time;"  value="${info.userName }">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="userDept">公司</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="userDept" data-easyform="null;"  value="${info.userDept }">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="userDuty">职业</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="userDuty" data-easyform="null;"  value="${info.userDuty }">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="userDesc">备注</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="userDesc" data-easyform="null;"  value="${info.userDesc }">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="file">上传头像</label>
	                        <div class="col-sm-10">
	                        	<input type="file" class="form-control" name="file" data-easyform="null;">
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
	$("form").easyform();
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
				html +='				<input type="checkbox" name="roleIds" value="'+data[i].roleId+'" data-message="至少选择一个"/> '+data[i].roleName
				html +='				</div>                                                                                                         '
				html +='			</div>                                                                                                         '
				html +='		</div>                                                                                                           '
				html +='	</div>  '
				html +='</div>                  '
			}
			roleLink.append(html)
			initCheckBox()
			$.ajax({
				type:"POST",
				url:basePath+"/user/getUserRoles.json",
				data:{
					userId:"${info.userId}"
				},
				success:function(data){
					for(var i in data){
						$("input[name=roleIds]").each(function(index,ele){
							roleId = $(this).val()
							if(data[i].roleId==roleId){
								$(this).iCheck('check');
							}
						})
					}
				}
			})
			resizeContent()
		}
	})
}
</script>
</html>