<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<%
	//String basePath=request.getContextPath();
	//request.setAttribute("basePath", basePath);
%>
	<!-- Bootstrap 3.3.6 -->
	<link rel="stylesheet" href="${basePath }/css/bootstrap/bootstrap.min.css">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
	<!-- Ionicons -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
	<!-- Date Picker -->
	<link rel="stylesheet" href="${basePath }/plugins/datepicker/datepicker3.css">
	<!-- Daterange picker -->
	<link rel="stylesheet" href="${basePath }/plugins/daterangepicker/daterangepicker.css">
	<!-- Daterange picker -->
	<link rel="stylesheet" href="${basePath }/plugins/bootstrap-table/bootstrap-table.css">
	
	  <!-- AdminLTE style -->
	<link rel="stylesheet" href="${basePath }/css/AdminLTE/AdminLTE.min.css">
	<link rel="stylesheet" href="${basePath }/css/AdminLTE/skins/_all-skins.min.css">
<style>
	*{
		margin: 0;
		padding: 0;
	}
</style>
<script type="text/javascript">
	var basePath="${basePath}";
</script>
