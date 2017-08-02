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
					<div class="box-title">定时任务管理</div>
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
			<label for="roleName" >用户账号：</label><input id="userAccount" class="form-control" />
		</div>
		<div class="form-group">
			<label for="roleName" >用户名称：</label><input id="userName" class="form-control" />
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
	$("body").on("click","i.fa-play",function(){
		var row = $table.bootstrapTable('getSelections');
		console.log({
			jobId:row[0].jobId
		})
		$.ajax({
			type:"POST",
			url:basePath+"/job/startJob",
			data:{
				jobId:row[0].jobId
			},
			success:function(data){
				if(data==undefined||data==''){
					layer.msg("已开始")
					$table.bootstrapTable('refresh');
				}else{
					layer.msg(data)
				}
			}
		})
	})
	$("body").on("click","i.fa-pause",function(){
		var row = $table.bootstrapTable('getSelections');
		$.ajax({
			type:"POST",
			url:basePath+"/job/stopJob",
			data:{
				jobId:row[0].jobId
			},
			success:function(data){
				if(data==undefined||data==''||data=='true'){
					layer.msg("已暂停")
					$table.bootstrapTable('refresh');
				}else{
					layer.msg("暂停失败")
				}
			}
		})
	})
	$("body").on("click","i.fa-trash",function(){
		$("#del").click();
	})
	$("#add").on("click",function(){
		jumpPage({
			url:basePath+"/job/add.html",
		})
	})
	$("#edit").on("click",function(){
		var row = $table.bootstrapTable('getSelections');
		if(row.length != 1){
			layer.msg("请选择一条记录")
		}
		if(row[0].jobId==undefined){
			layer.msg("跳转错误")
			return;
		}
		jumpPage({
			method:"POST",	
			url:basePath+"/job/edit.html",
			jobId:row[0].jobId
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
					ids.push(rows[i].jobId)
				}
				$.ajax({
					type:"POST",
					url:basePath+"/job/del.json ",
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
		url:basePath+"/job/list.json",
		queryParams:function (params) {
			params.userName=$("#userName").val()
			params.userAccount=$("#userAccount").val()
			return params;
		},
		columns:
			[	
			   { title : "check",   checkbox:true, },
			   { title : "任务名称",  field : "jobName",},
			   { title : "任务分组",  field : "jobGroup",},
			   { title : "任务状态",  field : "jobStatus",
				   "formatter":function(value){
					   switch (value) {
							case '0':
								return "停止"
							case '1':
								return "运行"
							case '2':
								return "等待"
							case '3':
								return "阻塞"
							case '4':
								return "错误"
		
							default:
								return "停止"
						}
				   },
			   },
			   { title : "时间表达式", field : "cronExpression",  },
			   { title : "任务描述", field : "jobDesc",  },
			   { title : "类名", field : "jobClass",  
				   formatter:function(value){
					   return value.substr(value.lastIndexOf(".")+1,value.length-1)
				   }
				},
			   { title : "开始时间", field : "jobStarttime",  formatter:formatDate },
			   { title : "结束时间", field : "jobEndtime",  formatter:formatDate },
			   { title: '操作', field: 'Id11', align: 'center', width: '100px',
					formatter: function (value, row, index) {
						var html ="";
						console.log(row.jobStatus==='1')
						if(row.jobStatus=='1'){
							html += "<span ><a href='#'><i class='fa fa-pause tableIcon primary'></i></a></span>"
						}else{
							html += "<span ><a href='#'><i class='fa fa-play tableIcon primary'></i></a></span>"
						}
						html += "<span ><a href='#'><i class='fa fa-edit tableIcon warning'></i></a></span>"
						html += "<span><a  href='#'><i class='fa  fa-trash tableIcon danger'></i></a></span>"
			          return html;
			        }
			   }
		  	]
	})
	$table=$("#table").bootstrapTable(tableOption);
// 	$table.bootstrapTable('hideColumn', 'resourceId');
}
function formatDate(value){
	   return new Date(value).Format("yyyy-MM-dd hh:mm:ss")
}
</script>
</html>
