<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>黑名单用户</title>
<%@include file="../csstool.jsp"%>
<style type="text/css">
.onclick{
	cursor:pointer;
}
.error-page>.headline {
	float: none;
}
.error-page{
	text-align: center;
}
</style>
</head>
<body class="skin-blue fixed">
<div class="wrapper">

<aside class="control-sidebar control-sidebar-dark"></aside>
<div class="control-sidebar-bg"></div>

<div class="content-wrapper">
	<!-- Main content -->
    <section class="content">
      <div class="error-page"> 
        <h2 class="headline text-yellow"> 黑名单用户</h2>

<!--         <div class="error-content"> -->

          <form class="search-form">

            <div class="row">
             <h3><i class="fa fa-warning text-yellow"></i> 你被加入了黑名单</h3>
	          <p>
	           	如果有疑问请联系管理员
	          </p>
            </div>
            </div>
            <!-- /.input-group -->
          </form>
        </div>
        <!-- /.error-content -->
<!--       </div> -->
      <!-- /.error-page -->
    </section>
</div>
</body>
<%@include file="../jstool.jsp"%>
<script type="text/javascript">

</script>
</html>
