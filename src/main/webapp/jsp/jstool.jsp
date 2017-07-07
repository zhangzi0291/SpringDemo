<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${basePath}/plugins/jQuery/jquery-2.2.3.min.js "></script>
<script src="${basePath}/plugins/bootstrap/bootstrap.min.js"></script>
<script src="${basePath}/plugins/fastclick/fastclick.js"></script>
<script src="${basePath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${basePath}/plugins/iCheck/icheck.js"></script>
<script src="${basePath}/plugins/layer/layer.js"></script>
<script src="${basePath}/plugins/daterangepicker/moment.js"></script>
<script src="${basePath}/plugins/daterangepicker/daterangepicker.js"></script>
<script src="${basePath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="${basePath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>

<script src="${basePath}/plugins/bootstrap-table/bootstrap-table.js"></script>
<script src="${basePath}/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="${basePath}/plugins/bootstrap-table/extensions/export/bootstrap-table-export.min.js"></script>
<script src="${basePath}/js/easyform.js"></script>

<script src="${basePath}/plugins/app.js"></script>

<script src="${basePath}/js/tableexport.js"></script>
<script src="${basePath}/js/table.js"></script>
<script type="text/javascript">
Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
//设置页面高度，避免表格比外框高
function resizeContent(){
    var contentheight = $(".content").height()
    var childheight =  $(".content").children().height();
	if(contentheight<childheight){
		$(".content").height(childheight+10);
	}
}

function jumpPage(json){
	if(json.method == undefined){
		json.method = "GET"
	}
	var form = $("<form method='"+json.method+"'/>").attr("action", json.url)
	delete json.url
	delete json.method
	for (key in json){
		var input = $("<input type='hidden'>");
		input.attr("name",key);
		input.val(json[key]);
		form.append(input);
		console.log(input.val)
	}
	form.appendTo("body").submit().remove();
}
$(function() {  
	resizeContent();
    FastClick.attach(document.body);  
    //设置菜单
   	$.ajax({
   		type:"POST",
   		url:basePath+"/getMenu",
   		success:function(data){
   			for(var i=data.length-1;i>=0;i--){
   				if(data[i].child.length==0){
   					var topli=$("<li >")
   					var a=$("<a >")
   					var icon=$("<i class='fa '>")
   					var span=$("<span>")
   					if("${nowMenu}"==data[i].resourceName){
   	   					topli.addClass("active")
   	   				}
   					span.text(data[i].resourceName)
   					a.attr('href',"${basePath}/"+data[i].resourceUrl); 
   					icon.append(span);
   					a.append(icon);
   					topli.append(a);
   					$("#menu-header").after(topli);
   					continue;
   				}
   				var topli=$("<li class='treeview'>")
   				var a=$("<a href >")
   				var span=$("<span>")
   				var icon=$("<i class='fa fa-angle-left pull-right'>")
   				span.text(data[i].resourceName)
   				if("${nowMenu}"==data[i].resourceName){
   					topli.addClass("active")
   				}
   				a.append(span);
   				a.append(icon);	
   				var child=data[i].child;
				var ul=$("<ul class='treeview-menu menu-open'>")
   				for(var j=0;j<child.length;j++){
   					var li=$("<li>")
   					var a2=$("<a>")
   					a2.attr("href","${basePath}/"+child[j].resourceUrl);
   					a2.text(child[j].resourceName)
	   				if("${nowChild}"==child[j].resourceName){
	   					li.addClass("active")
	   				}
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
   		var menuName = $(this).find("a").find("span").text();
   		var childName = $(this).find(".treeview-menu").find("a").text();
   		$.ajax({
   			type:"POST",
   	   		url:basePath+"/setMenu",
   	   		data:{
   	   			"menuName":menuName,
   	   			"childName":childName,
   	   		},
   	   		success:function(data){
   	   			
   	   		}
   		})
   	})

});
</script>