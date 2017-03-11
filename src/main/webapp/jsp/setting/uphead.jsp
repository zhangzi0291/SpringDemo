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
					<div class="box-title">上传头像</div>
				</div>
				 <form action="${basePath }/user/uploadHead.json"  enctype="multipart/form-data" method="post">
				<div class="box-body">
					<div class="box-header with-border">
<!-- 		              <h3 class="box-title">新建融资</h3> -->
		            </div>
		            <div class="box-body">
		          	 <input type="hidden" class="form-control"  name="id"  value="${user.id}"
		                		placeholder="融资金额">
		              <div class="input-group">
		                <span class="input-group-addon left-addon">头像图片（.jpg .png）</span>
		              		<input type="file" class="form-control" name="file" accept="image/jpeg,image/png">
		                <span class="input-group-addon"></span>
		              </div>
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

}
function initEvent(){
	$("input[type=submit]").on("click",function(){
		if($("input[name = file ]").val().length<=0){
			layer.alert("请选择图片后提交")
			return false
		}
	})
	$("input[name = file ]").on("change",function(){
		var fileName = $(this).val();
		if (fileName != null&& fileName != "") {
			  //lastIndexOf如果没有搜索到则返回为-1
			  if (fileName.lastIndexOf(".") != -1) {
			   var fileType = (fileName.substring(fileName.lastIndexOf(".") + 1,
			  fileName.length)).toLowerCase();
			   var suppotFile = new Array();
			   suppotFile[0] = "jpg";
			   suppotFile[1] = "png";
			   suppotFile[2] = "jpeg";
			  }
			  for ( var i = 0; i < suppotFile.length; i++) {
				    if (suppotFile[i] == fileType) {
						if (fileName.length > 60) {
							layer.alert("文件名过长");
							$(this).val("");$(this).text("");
							return false
						}else{
							break
						}
				    }else{
				    	layer.alert("只能上传图片文件")
				    	$(this).val("");$(this).text("");
				    	return false
				    }
			  }
		}
	})
}
function initTable(){
}

</script>
</html>
