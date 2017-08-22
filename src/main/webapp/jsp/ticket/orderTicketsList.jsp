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
					<div class="box-title">订票通知列表</div>
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
		<label for="name" >时间：</label><input id="date"  />
	</div>
	<div class="form-group">
		<label for="property" >出发站：</label><input id="startStation"  />
	</div>
	<div class="form-group">
		<label for="property" >到达站：</label><input id="endStation"  />
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
</body>
<jsp:include page="/jsp/jstool.jsp" flush="true"/>
<script type="text/javascript">
var $table
$(function(){
	initTable();
	initEvent();
})
function initEvent(){
	$('#date').daterangepicker({
// 		timePicker : true,
//     	timePickerIncrement : 1, //时间的增量，单位为分钟
//     	timePicker12Hour : false, //是否使用12小时制来显示时间  
		singleDatePicker: true,
		showDropdowns: true,
		opens : 'right', //日期选择框的弹出位置				    	
		'applyClass' : 'btn-sm btn-success',
		'cancelClass' : 'btn-sm btn-default',					
		locale: {
			format: 'YYYY-MM-DD',
			applyLabel: '确定',
			cancelLabel: '取消',
			fromLabel: '从',
			toLabel: '到',
			weekLabel: '周',
			customRangeLabel: 'Custom Range',
			daysOfWeek: ["日", "一", "二", "三", "四", "五", "六"],
			monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
			firstDay: moment.localeData()._week.dow,
		}
	})
	$("#search").on("click",function(){
			$table.bootstrapTable('refresh');
	})
	$("body").on("click","i.fa-trash",function(){
		$("#del").click();
	})
	$("body").on("click","i.fa-edit",function(){
		$("#edit").click();
	})
	$("#add").on("click",function(){
		jumpPage({
			url:basePath+"/train/add.html",
		})
	})
	$("#edit").on("click",function(){
		var row = $table.bootstrapTable('getSelections');
		if(row.length != 1){
			layer.msg("请选择一条记录")
		}
		if(row[0].orderticketsId==undefined){
			layer.msg("跳转错误")
			return;
		}
		jumpPage({
			method:"POST",	
			url:basePath+"/train/edit.html",
			orderticketsId:row[0].orderticketsId
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
					ids.push(rows[i].orderticketsId)
				}
				$.ajax({
					type:"POST",
					url:basePath+"/train/del.json ",
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
		url:basePath + "/train/orderTicketsList.json",
		queryParams:function (params) {
			params.date=$("#date").val()
			params.startStation=$("#startStation").val()
			params.endStation=$("#endStation").val()
			return params;
		},
		columns:[	
			   { "title" : "check",   checkbox:true, },
			   { "title" : "添加人",   "field": "orderUser", },
			   { "title" : "出发站",  "field" : "fromStation", },
			   { "title" : "到达站", "field" : "toStation",  },
			   { "title" : "通知邮箱",  "field" : "emailAddress",  },
			   { "title" : "预定日期",  "field" : "orderDate",  
				   "formatter":function(value,row){
					   return new Date(value).Format("yyyy-MM-dd hh:mm:ss	")
				   }
			   },
			   { 
				   title: '操作', field: 'Id11', align: 'center', width: '100px',
					formatter: function (value, row, index) {
							var html = "<span ><a href='#'><i class='fa fa-edit tableIcon warning'></i></a></span>"
							html += "<span><a  href='#'><i class='fa  fa-trash tableIcon danger'></i></a></span>"
							return html;
						}
					} ],
		})
		$table = $("#table").bootstrapTable(tableOption);
	}
</script>
</html>
