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
					<div class="box-title">编辑资源</div>
				</div>
				<div class="box-body">
					<form action="${basePath }/resource/edit.json" method="post" class="form-horizontal">
						<c:if test="${not empty param.error}">
							<div class="red">${param.error }</div>
						</c:if>
                       	<input type="hidden" class="form-control" name="resourceId" value="${info.resourceId }">
						<div class="form-group">
							<label class="col-sm-2 control-label">资源名称</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="resourceName" value="${info.resourceName }">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">资源类型</label>
	                        <div class="col-sm-10">
	                        	<select id="resourceType" class="form-control" name="resourceType" >
									<option value="url" <c:if test="${info.resourceType =='url' }">selected</c:if>  >链接</option>
									<option value="action" <c:if test="${info.resourceType =='action' }">selected</c:if> >动作</option>
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
							<label class="col-sm-2 control-label" >资源路径</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="resourceUrl" value="${info.resourceUrl }">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">排序号</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="orderNum" value="${info.orderNum }">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">ICON</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="iconName" value="${info.iconName }">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">备注</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="resourceDesc" value="${info.resourceDesc }">
	                        </div>
	                    </div>
						<div class="hr-line-dashed"></div>
						<div class="align-right">
							<button id="save" type="submit" class="btn btn-primary">保存</button>
							<button id="back" type="button" class="btn btn-warning">返回</button>
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
	$("#search").on("click",function(){
		$table.bootstrapTable('refresh');
	})
	$("#back").on("click",function(){
		window.history.go(-1)
	})
	$("#resourceType").on("change",function(){
		var resourceType= $("#resourceType").val()
		var parentIdDiv = $("select[name=parentId]").parent().parent()
		$("select[name=parentId]").val("")
		if(resourceType=="url"){
			parentIdDiv.show()
			setOption()
		}else{
			parentIdDiv.hide()
			var parentId = $("select[name=parentId]")
			var option = $("<option>")
			option.html("")
			option.val("")
			parentId.append(option)
		}
	})
	function setOption(){
		$.ajax({
			type:"POST",
			url:basePath+"/resource/getParentId.json ",
			success:function(data){
				var oldVal = "${info.parentId}"
				var parentId = $("select[name=parentId]")
				parentId.empty();
				var option = $("<option>")
				option.html("根目录")
				option.val("-1")
				if(oldVal=="-1"){
					option.prop("selected",true)
				}
				parentId.append(option)
				for(var i in data){
					var option = $("<option>")
					option.html(data[i].resourceName)
					option.val(data[i].resourceId)
					if(oldVal==data[i].resourceId){
						option.prop("selected",true)
					}
					parentId.append(option)
				}
			}
		})
	}
}

</script>
</html>
