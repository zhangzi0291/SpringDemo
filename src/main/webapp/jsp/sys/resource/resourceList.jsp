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
<!-- 					<table id = 'table'  cellspacing="0"></table> -->
					<div id="toolbar">
						<form class="form-inline" role="form">
						</form>
						<div class="btn-toolbar" role="toolbar">
							<div class="btn-group">
								<button id="add" class="btn btn-primary">新增</button>
							</div>
						</div>
					</div>
					<br>
					<div id = 'tree'  cellspacing="0"></div>
				</div>
			</div>
		</div>
	</section>
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
			url:basePath+"/resource/add.html",
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
	
	var tree = $('#tree').treeview({
	    data: getTree(),
	    showTags:true,
	    showBorder: true,
	    onSearchComplete: function(){
	    	resizeContent();
	    }
	});
	function getTree() {
	    var data = []
	    $.ajax({
	    	type:"post",
	    	url:basePath+"/resource/getResource.json",
	    	async:false,
	    	success:function(json){
			    for(var i in json){
			        data.push(setTree(json[i]))
			    }	    		
	    	}
	    })
	    return data;
	}
	function setTree(res){
	    res.nodes = res.child
	    res.text = res.resourceName +"  "+ res.resourceUrl
	   	res.tag ="<div class='row'>"
		    +"<span class='col-md-3'>"+res.resourceName+"</span>"
		    +"<span class='col-md-3'>"+res.resourceType+"</span>"
		    +"<span class='col-md-3'>"+res.resourceUrl+"</span>"
		    +"<span class='col-md-3'>"+res.orderNum+"</span>"
		    +"</div>"
	    res.state= {
 	        //checked: true,
	        // disabled: true,
	        expanded: false,
	        //selected: true
	    }
	    for(i in res.child){
	        setTree(res.child[i])
	    }
	    return res;
	}

	$.contextMenu({
        selector: 'li.node-tree', 
        items: {
            "edit": {name: "编辑", icon: "edit", callback:function(){
                var nodeId = $(this).data("nodeid");
                var nodeData = tree.treeview('getNode', nodeId);
                if(nodeData.resourceId==undefined){
        			layer.msg("跳转错误")
        			return;
        		}
                jumpPage({
        			method:"POST",	
        			url:basePath+"/resource/edit.html",
        			resourceId:nodeData.resourceId
        		})
            }},
            "delete": {name: "删除", icon: "delete", callback:function(){
                var nodeId = $(this).data("nodeid");
                var nodeData = tree.treeview('getNode', nodeId);
                layer.confirm('确定要删除？', {
	  				  btn: ['是','否'] //按钮
	  			},function(index){
	  				var ids =[]; 
  					ids.push(nodeData.resourceId)
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
            }},
        }
	});
	
}

</script>
</html>
