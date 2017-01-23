<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
<%@include file="csstool.jsp"%>
<style type="text/css">
.onclick{
	cursor:pointer;
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
			<div class="box">
				<div class="box-header">
					<div class="box-title">宝可梦</div>
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
		<label for="name" >名字：</label><input id="name"  />
	</div>
	<div class="form-group">
		<label for="property" >特性：</label><input id="property"  />
	</div>
	<div class="form-group">
		<label for="attribute" >属性：</label>
		<select id="attribute" >
			<option value="">不选择</option>
			<option>一般</option>
			<option>火</option>
			<option>水</option>
			<option>草</option>
			<option>电</option>
			<option>冰</option>
			<option>虫</option>
			<option>飞行</option>
			<option>地面</option>
			<option>岩石</option>
			<option>格斗</option>
			<option>超能力</option>
			<option>幽灵</option>
			<option>毒</option>
			<option>恶</option>
			<option>钢</option>
			<option>龙</option>
			<option>妖精</option>
		</select>
	</div>
	<button id="search" class="btn btn-primary" type="button">搜索</button>
</form>
</div>
</body>
<%@include file="jstool.jsp"%>
<script type="text/javascript">
var $table
var option = tableoption
$(function(){
	tableoption.queryParams=function (params) {
		params.name=$("#name").val()
		params.attribute=$("#attribute").val()
		params.property=$("#property").val()
		return params;
	}
	tableoption.columns=[	
	   { "title" : "check",   checkbox:true, },
	   { "title" : "id",   "field": "pid", },
	   { "title" : "名称",  "field" : "name", 
		"formatter":function(value){
		   return "<a href='pokeDetail?name="+value+"'>"+value+"</a>"
	   }
	   },
	   { "title" : "属性", "field" : "attribute1",  },
	   { "title" : "属性", "field" : "attribute2",  },
	   { "title" : "特性",  "field" : "property1",  },
	   { "title" : "特性",  "field" : "property2",  },
	   { "title" : "隐藏特性", "field" : "hide_property" },
	   { "title" : "HP",   "field" : "hp",  sortable:true,},
	   { "title" : "攻击", "field" : "atk", sortable:true, },
	   { "title" : "防御", "field" : "def", sortable:true, },
	   { "title" : "特攻", "field" : "spatk", sortable:true, },
	   { "title" : "特防", "field" : "spdef", sortable:true, },
	   { "title" : "速度", "field" : "speed", sortable:true, },
	   { "title" : "总值", "field" : "sum", sortable:true, },
  	]
	initTable();
	initEvent();
})
function initEvent(){
	$("#search").on("click",function(){
		console.log($table.options)
		$.ajax({
			type:"POST",
			url:basePath+"/getpoke",
			data:{
				"name":$("#name").val(),
				"attribute":$("#attribute").val(),
				"property":$("#property").val(),
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
	$table=$("#table").bootstrapTable(option);
}

</script>
</html>
