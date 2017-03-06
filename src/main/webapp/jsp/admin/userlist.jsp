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
.queryBox>label{
  padding-right:0;
}
.nopadding{
  padding-left: 0px;
  padding-right: 0px;
}
.queryBox>input{
  padding-left: 0px;
  padding-right: 0px;
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
					<div class="box-title">用户列表</div>
				</div>
				<div class="box-body">
					<div class="row" >
						<div class="col-xs-4 queryBox marginTop">
							<label class="col-xs-3 control-label">用户名：</label>
							<input id="userName" class=" col-xs-3"    />
						</div>
						<div class="col-xs-4 queryBox marginTop">
							<label class="col-xs-3 control-label">职业：</label>
							<input id="userProfession" class=" col-xs-3"    />
						</div>
						<div class="col-xs-1">
							<button id="search" class="btn btn-primary search-high search-btn" type="button">搜索</button>
						</div>
					</div>
					<table id = 'table'  cellspacing="0"></table>
				</div>
			</div>
		</div>
	</section>
</div>
<div id="toolbar">
	<div class="btn-toolbar" role="toolbar">
		<div class="btn-group">
			<button type="button" class="btn btn-primary"  id="del">删除</button>
		</div>
	</div>
</div>

</body>
<%@include file="../jstool.jsp"%>
<script type="text/javascript">
var $table
var option = tableoption
$(function(){
	initPage();
	initTable();
	initEvent();
})
function initPage(){

}
function initEvent(){
	$("#del").on("click",function(){
		layer.confirm('确定要删除吗？', {
		    btn: ['确定','取消'], //按钮
		    shade: false //不显示遮罩
		}, function(index){
		    // 提交表单的代码，需要你自己写，然后用 layer.close 关闭就可以了，取消可以省略
			var selects = $table.bootstrapTable('getSelections');
			var ids= [];
			for(i=0;i<selects.length;i++){
				ids.push(selects[i].id);
			}
			del(ids);
		    layer.close(index);
		});
	})
	$("#search").on("click",function(){
		$.ajax({
			type:"POST",
			url:basePath+"/admin/userList.json",
			data:{
				userName:$("#userName").val(),
				userProfession:$("#userProfession").val(),
				"limit":tableoption.pageSize,
				"offset":0
			},
			success : function(data){
				console.log(data)
				$table.bootstrapTable('selectPage', 1);
				$table.bootstrapTable('load', data);
			}
		})
	})
}
function initTable(){
	option.url = basePath + "/admin/userList.json";
	option.queryParams=function (params) {
		params.userName=$("#userName").val()
		params.userProfession=$("#userProfession").val()
		return params;
	}
	option.columns=[	
	   { "title" : "check",   checkbox:true, },
	   { "title" : "操作",   "field": "option","width":"50px",
		   "formatter":function(value, row, index){
			   return [
			            "<a class=\"like\" href=\"javascript:viewInline('" + row.id +  "')\" title=\"查看\">",
			            '<i class="fa fa-search-plus"></i>',
			            '</a>  ',
			            "<a class=\"like\" href=\"javascript:delInline('" + row.id +  "')\" title=\"删除\">",
			            '<i class="fa fa-trash-o text-danger"></i>',
			            '</a>  '
			        ].join('')
			}   
	   },
	   { "title" : "id",   "field": "id", },
	   { "title" : "用户名",  "field" : "userName", },
	   { "title" : "邮箱", "field" : "userEmail",  },
	   { "title" : "职业", "field" : "userProfession",   },
  	]
	$table=$("#table").bootstrapTable(option);
}
function viewInline(){
	var selects = $table.bootstrapTable('getSelections');
	window.location.href = basePath+"/admin/userInfo.html?id="+selects[0].id
}
function delInline(id){
	layer.confirm('确定要删除吗？', {
	    btn: ['确定','取消'], //按钮
	    shade: false //不显示遮罩
	}, function(index){
	    // 提交表单的代码，需要你自己写，然后用 layer.close 关闭就可以了，取消可以省略
		var ids= [];
		ids.push(id);
		del(ids);
	    layer.close(index);
	});
}
function del(ids){
	$.ajax({
		type:"post",
		url:basePath+"/admin/delUser.json",
		data:{
			"ids":ids
		},
		success:function(data){
			if(data>0){
				layer.alert("删除成功")
				$table.bootstrapTable('refresh')
			}else{
				layer.alert("删除失败")
			}
		}
	})
}
</script>
</html>
