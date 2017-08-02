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
					<div class="box-title">编辑定时任务</div>
				</div>
				<div class="box-body">
					<form action="${basePath }/job/edit.json" method="post" class="form-horizontal">
						<c:if test="${not empty error}">
							<div class="red">${error }</div>
						</c:if>
                       	<input type="hidden" class="form-control" name="jobId" value="${info.jobId }">
						<div class="form-group">
							<label class="col-sm-2 control-label">任务名称</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="jobName" value="${info.jobName }">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">任务群组</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="jobGroup" value="${info.jobGroup }">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">时间表达式</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="cronExpression" value="${info.cronExpression }" placeholder="http://www.pppet.net/">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">Class完全限定类名</label>
	                        <div class="col-sm-10">
	                        	<input type="text" class="form-control" name="jobClass" value="${info.jobClass }">
	                        </div>
	                    </div>
						<div class="form-group">
							<label class="col-sm-2 control-label">备注</label>
	                        <div class="col-sm-10">
	                        	<textarea rows="3" class="form-control"  name="jobDesc" >${info.jobDesc }</textarea>
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
}

</script>
</html>
