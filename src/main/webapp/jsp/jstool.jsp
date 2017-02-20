<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="${basePath}/plugins/jQuery/jquery-2.2.3.min.js "></script>
<script src="${basePath}/plugins/bootstrap/bootstrap.min.js"></script>
<script src="${basePath}/plugins/fastclick/fastclick.js"></script>
<script src="${basePath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>

<script src="${basePath}/plugins/layer/layer.js"></script>

<script src="${basePath}/plugins/bootstrap-table/bootstrap-table.js"></script>
<script src="${basePath}/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="${basePath}/plugins/bootstrap-table/extensions/export/bootstrap-table-export.min.js"></script>
<script src="${basePath}/js/tableexport.js"></script>
<script src="${basePath}/js/upload.js"></script>

<script src="${basePath}/plugins/app.js"></script>

<script src="${basePath}/js/table.js"></script>
<script type="text/javascript">
$(function() {  
    FastClick.attach(document.body);  
   	$.ajax({
   		type:"POST",
   		url:basePath+"/getMenu",
   		success:function(data){
   			for(var i=data.length-1;i>=0;i--){
   				var topli=$("<li class='treeview'>")
   				var a=$("<a href >")
   				var span=$("<span>")
   				var icon=$("<i class='fa fa-angle-left pull-right'>")
   				span.text(data[i].menu_name)
   				if("${nowMenu}"==data[i].menu_name){
   					topli.addClass("active")
   				}
   				a.append(span);
   				a.append(icon);	
   				var child=data[i].child;
				var ul=$("<ul class='treeview-menu menu-open'>")
   				for(var j=0;j<child.length;j++){
   					var li=$("<li>")
   					var a2=$("<a>")
   					a2.attr("href","${basePath}/"+child[j].menu_url);
   					a2.text(child[j].menu_name)
   					li.append(a2);
   					ul.append(li);
   				}
				topli.append(a);
				topli.append(ul);
   				$("#menu-header").after(topli)
   			}
   		}
   	})
   	$("aside.main-sidebar > div > div.sidebar > ul ").on("click","li",function(){
   		console.log(11111)
   		var menuName = $(this).find("a").find("span").text();
   		$.ajax({
   			type:"POST",
   	   		url:basePath+"/setMenu",
   	   		data:{
   	   			"menuName":menuName
   	   		},
   	   		success:function(data){
   	   			
   	   		}
   		})
   	})
});
</script>