<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
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
					<div class="box-title">角色管理</div>
				</div>
				<div class="box-body">
					<table id = 'table'  cellspacing="0"></table>
				</div>
			</div>
		</div>
	</section>
</div>
<div id="toolbar">
	<form class="form-inline" role="form">
		<div class="form-group">
			<label for="roleName" >用户名称：</label><input id="roleName" class="form-control" />
		</div>
		<div class="form-group">
			<label for="enabled" >是否启用：</label>
			<select id="enabled" class="form-control">
				<option value="">全部</option>
				<option value="1">是</option>
				<option value="0">否</option>
			</select>
		</div>
		<button id="search" class="btn btn-primary" type="button">搜索</button>
	</form>
	<div class="btn-toolbar" role="toolbar">
		<div class="btn-group">
			<button id="add" class="btn btn-primary">新增</button>
			<button id="edit" class="btn btn-warning">修改</button>
			<button id="del" class="btn btn-danger">删除</button>
		</div>
	</div>
</div>
<jsp:include page="/jsp/footer.jsp" flush="true"/>
</body>
<jsp:include page="/jsp/jstool.jsp" flush="true"/>
<script type="text/javascript">
var $table
$(function(){
	initTable();
	initEvent();
})
function initEvent(){
	$("#search").on("click",function(){
		$table.bootstrapTable('refresh');
	})
	$("body").on("click","i.fa-edit",function(){
		$("#edit").click();
	})
	$("body").on("click","i.fa-trash",function(){
		$("#del").click();
	})
	$("#add").on("click",function(){
		jumpPage({
			url:basePath+"/user/add.html",
		})
	})
	$("#edit").on("click",function(){
		var row = $table.bootstrapTable('getSelections');
		if(row.length != 1){
			layer.msg("请选择一条记录")
		}
		if(row[0].userId==undefined){
			layer.msg("跳转错误")
			return;
		}
		jumpPage({
			method:"POST",	
			url:basePath+"/user/edit.html",
			userId:row[0].userId
		})
	})
	$("#del").on("click",function(){
		var rows = $table.bootstrapTable('getSelections');
		if(rows.length == 0){
			layer.msg("请至少选择一条记录")
		}else{
			layer.confirm('确定要删除？', {
				  btn: ['是','否'] //按钮
			},function(index){
				var ids =[]; 
				for (var i in rows){
					ids.push(rows[i].userId)
				}
				$.ajax({
					type:"POST",
					url:basePath+"/user/del.json ",
					data:{
						ids:ids
					},
					success:function(data){
						console.log(data)
						if(data>0){
							layer.msg("删除成功")
						}else{
							layer.msg("删除失败")
						}
						$table.bootstrapTable('refresh');
						layer.close(index)
					},
					error:function(){
						layer.msg("服务异常，删除失败")
						layer.close(index)
					}
				})
			},
			function(){})
		}
		
	})
}
function initTable(){
	tableOption = getOption({
		url:basePath+"/user/list.json",
		queryParams:function (params) {
			params.userName=$("#userName").val()
			params.enabled=$("#enabled").val()
			return params;
		},
		columns:
			[	
			   { title : "check",   checkbox:true, },
// 			   { title : "权限ID",   field: "resourceId", },
			   { title : "角色名称",  field : "userName",},
			   { title : "公司",  field : "userDept",},
			   { title : "职业",  field : "userDuty",},
			   { title : "备注", field : "userDesc",  },
			   { title: '操作', field: 'Id11', align: 'center', width: '100px',
					formatter: function (value, row, index) {
						var html = "<span ><a href='#'><i class='fa fa-edit tableIcon warning'></i></a></span>"
						html += "<span><a  href='#'><i class='fa  fa-trash tableIcon danger'></i></a></span>"
			          return html;
			        }
			   }
		  	]
	})
	$table=$("#table").bootstrapTable(tableOption);
// 	$table.bootstrapTable('hideColumn', 'resourceId');
}

</script>
</html>
