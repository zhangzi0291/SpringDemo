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
$(function() {  
    FastClick.attach(document.body);  
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
<%
	if(session.getAttribute("user") != null) {
%>
   	$.ajax({
   		type:"POST",
   		url:basePath+"/getMenu",
   		success:function(data){
   			for(var i=data.length-1;i>=0;i--){
   				var topli=$("<li class='treeview'>")
   				var a=$("<a href >")
   				var span=$("<span>")
   				var icon=$("<i class='fa fa-angle-left pull-right'>")
   				span.text(data[i].menuName)
   				if("${nowMenu}"==data[i].menuName){
   					topli.addClass("active")
   				}
   				a.append(span);
   				a.append(icon);	
   				var child=data[i].child;
				var ul=$("<ul class='treeview-menu menu-open'>")
   				for(var j=0;j<child.length;j++){
   					var li=$("<li>")
   					var a2=$("<a>")
   					a2.attr("href","${basePath}/"+child[j].menuUrl);
   					a2.text(child[j].menuName)
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
<%
	}
%>
});
</script>