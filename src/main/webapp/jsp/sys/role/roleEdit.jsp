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
					<div class="box-title">编辑角色</div>
				</div>
				<div class="box-body">
					<form action="${basePath }/role/edit.json" method="post" class="form-horizontal">
						<c:if test="${not empty error}">
							<div class="red">${error }</div>
						</c:if>
                       	<input type="hidden" class="form-control" name="roleId"  value="${info.roleId }">
						<div class="form-group">
							<label class="col-sm-2 control-label">角色名称</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="roleName"  value="${info.roleName }">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">是否启用</label>
	                        <div class="col-sm-10">
	                        	<input type="radio" name="enabled" value="1"  <c:if test="${info.enabled == '1' }">checked</c:if>>是 &nbsp;&nbsp;
	                        	<input type="radio" name="enabled" value="0" <c:if test="${info.enabled != '1' }">checked</c:if> >否
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">备注</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="roleDesc" value="${info.roleDesc }">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">关联权限</label>
	                        <div class="col-sm-10">
	                        </div>
							<label class="col-sm-2 control-label"></label>
	                        <div class="col-sm-10" id="authoritieLink">
	                        	
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
	$("#resourceType").change();
})
function initEvent(){
	$("#back").on("click",function(){
		window.history.go(-1)
	})
	$.ajax({
		type:"POST",
		url:basePath+"/authoritie/getAuth.json",
		success:function(data){
			resourceLink = $("#authoritieLink");
			html = "";
			for(var i in data){
				html +='<div class="col-md-4">                                                                                       '
				html +='	<div class="box box-default">                                                                                      '
				html +='  		<div class="box-body">                                                                                           '
				html +='    		<div class="row">                                                                                              '
				html +='				<div class="col-md-12">  '
				html +='				<input type="checkbox" name="authorityIds" value="'+data[i].authorityId+'" data-message="至少选择一个"/> '+data[i].authorityName
				html +='				</div>                                                                                                         '
				html +='			</div>                                                                                                         '
				html +='		</div>                                                                                                           '
				html +='	</div>  '
				html +='</div>                  '
			}
			resourceLink.append(html)
			initCheckBox()
			$.ajax({
				type:"POST",
				url:basePath+"/role/getRoleAuth.json",
				data:{
					roleId:"${info.roleId}"
				},
				success:function(data){
					for(var i in data){
						$("input[name=authorityIds]").each(function(index,ele){
							authorityId = $(this).val()
							if(data[i].authorityId==authorityId){
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
