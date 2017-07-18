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
					<div class="box-title">新增资源</div>
				</div>
				<div class="box-body">
					<form action="${basePath }/resource/add.json" method="post" class="form-horizontal">
						<c:if test="${not empty error}">
							<div class="red">${error }</div>
						</c:if>
						<div class="form-group">
							<label class="col-sm-2 control-label">资源名称</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="resourceName">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">资源类型</label>
	                        <div class="col-sm-10">
	                        	<select id="resourceType" class="form-control" name="resourceType">
									<option value="url">链接</option>
									<option value="action">动作</option>
								</select>
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">父类ID</label>
	                        <div class="col-sm-10">
	                        	<select class="form-control" name="parentId">
	                        	</select>
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">资源路径</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="resourceUrl">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">排序号</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="orderNum">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">ICON</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="iconName">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">备注</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="resourceDesc">
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
	$("#resourceType").on("change",function(){
		var resourceType= $("#resourceType").val()
		var parentIdDiv = $("select[name=parentId]").parent().parent()
		$("select[name=parentId]").val("")
// 		setOption()
		if(resourceType=="url"){
// 			parentIdDiv.show()
			setOption("-1","url")
		}else{
// 			parentIdDiv.hide()
// 			var parentId = $("select[name=parentId]")
// 			var option = $("<option>")
// 			option.html("")
// 			option.val("")
// 			parentId.append(option)
			setOption()
		}
	})
	function setOption(parentId,type){
		if(parentId == undefined){
			parentId == "";
		}
		if(type == undefined){
			type == "";
		}
		$.ajax({
			type:"POST",
			url:basePath+"/resource/getParentId.json ",
			data:{
				parentId:parentId,
				type:type,
			},
			success:function(data){
				var parentId = $("select[name=parentId]")
				parentId.empty();
				var option = $("<option>")
				option.html("根目录")
				option.val("-1")
				parentId.append(option)
				for(var i in data){
					var option = $("<option>")
					option.html(data[i].resourceName)
					option.val(data[i].resourceId)
					parentId.append(option)
				}
			}
		})
	}
}

</script>
</html>
