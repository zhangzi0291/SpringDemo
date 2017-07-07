<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath=request.getContextPath();
	request.setAttribute("basePath", basePath);
%>
	<!-- Bootstrap 3.3.6 -->
	<link rel="stylesheet" href="${basePath }/css/bootstrap/bootstrap.min.css">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="${basePath }/css/font-awesome/font-awesome.min.css">
	<!-- Ionicons -->
	<link rel="stylesheet" href="${basePath }/css/ionicons/ionicons.min.css">
	<!-- Date Picker -->
	<link rel="stylesheet" href="${basePath }/plugins/datepicker/datepicker3.css">
	<!-- Daterange picker -->
	<link rel="stylesheet" href="${basePath }/plugins/daterangepicker/daterangepicker.css">
	<!-- Daterange picker -->
	<link rel="stylesheet" href="${basePath }/plugins/bootstrap-table/bootstrap-table.css">
	<!-- iCheck -->
	<link rel="stylesheet" href="${basePath }/plugins/iCheck/all.css">
	
	<link rel="stylesheet" href="${basePath }/css/easyform.css">
	  <!-- AdminLTE style -->
	<link rel="stylesheet" href="${basePath }/css/AdminLTE/AdminLTE.min.css">
	<link rel="stylesheet" href="${basePath }/css/AdminLTE/skins/_all-skins.min.css">
<style>
* {
	margin: 0;
	padding: 0;
}
.onclick {
	cursor: pointer;
}
.red {
	color: red;
}
footer {
	margin-left: 230px;
	color: white;
}
.hr-line-dashed {
    border-top: 1px dashed #e7eaec;
    color: #ffffff;
    background-color: #ffffff;
    height: 1px;
    margin: 20px 0;
}
.align-left{
	text-align:left;: 
}
.align-right{
	text-align:right;: 
}
</style>
<script type="text/javascript">
	var basePath="${basePath}";
</script>
