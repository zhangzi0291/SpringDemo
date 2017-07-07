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
					<div class="box-title">资源管理</div>
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
			<label for="resourceName" >资源名称：</label><input id="resourceName" class="form-control" />
		</div>
		<div class="form-group">
			<label for="resourceType" >资源类型：</label>
			<select id="resourceType" class="form-control">
				<option value="">全部</option>
				<option value="url">链接</option>
				<option value="action">动作</option>
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
	$("#add").on("click",function(){
		jumpPage({
			url:basePath+"/resource/add.html",
		})
	})
	$("#edit").on("click",function(){
		var row = $table.bootstrapTable('getSelections');
		if(row.length != 1){
			layer.msg("请选择一条记录")
		}
		if(row[0].resourceId==undefined){
			layer.msg("跳转错误")
		}
		jumpPage({
			method:"POST",	
			url:basePath+"/resource/edit.html",
			resourceId:row[0].resourceId
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
					ids.push(rows[i].resourceId)
				}
				$.ajax({
					type:"POST",
					url:basePath+"/resource/del.json ",
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
		url:basePath+"/resource/list.json",
		queryParams:function (params) {
			params.resourceName=$("#resourceName").val()
			params.resourceType=$("#resourceType").val()
			return params;
		},
		columns:
			[	
			   { title : "check",   checkbox:true, },
// 			   { title : "资源ID",   field: "resourceId", },
			   { title : "资源名称",  field : "resourceName", 
//		 		"formatter":function(value){
//		 		   return "<a href='pokeDetail?name="+value+"'>"+value+"</a>"
//		 	   }
			   },
			   { title : "资源类型", field : "resourceType",  },
			   { title : "资源路径",  field : "resourceUrl",  },
			   { title : "是否父节点",  field : "parentId",  
				   "formatter":function(value){
			 		   if(value==undefined){
			 			   return "-"
			 		   }else if(value=="-1"){
			 			   return "是"
			 		   }else{
			 			   return "否"
			 		   }
			 	   }
			   },
			   { title : "排序号", field : "orderNum" },
			   { title : "ICON",   field : "iconName"},
			   { title : "备注", field : "resourceDesc",  },
			   { title: '操作', field: 'Id11', align: 'center', width: '100px',
					formatter: function (value, row, index) {
			          
			        }
			   }
		  	]
	})
	$table=$("#table").bootstrapTable(tableOption);
// 	$table.bootstrapTable('hideColumn', 'resourceId');
}

</script>
</html>
