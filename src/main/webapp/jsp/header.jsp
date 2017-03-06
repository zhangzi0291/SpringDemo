<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="main-header">
  <a href="#" class="logo">
    <!-- LOGO -->
   <b>Admin</b>LTE
  </a>
  <nav class="navbar navbar-static-top" role="navigation">
	<!-- Navbar 左侧 -->
    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"></a>
    <!-- Navbar 右侧 -->
    <div class="navbar-custom-menu">
      <ul class="nav navbar-nav">
        <!-- User Account: style can be found in dropdown.less -->
        <li class="dropdown user user-menu">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <img src="${basePath }/upload/${user.headshotImg==null?'unknown.png':user.headshotImg}  " class="user-image" alt="User Image">
            <span class="hidden-xs">${user.userName }</span>
          </a>
          <ul class="dropdown-menu">
            <!-- User image -->
            <li class="user-header">
              <img src="${basePath }/upload/${user.headshotImg==null?'unknown.png':user.headshotImg}  " class="img-circle" alt="User Image">
              <p>
               ${user.realName }
              </p>
            </li>
            <!-- Menu Footer-->
            <li class="user-footer">
              <div class="pull-left">
                <a href="${basePath }/user/myinfo.html" class="btn btn-default btn-flat">详情</a>
              </div>
              <div class="pull-right">
                <a href="${basePath }/exit" class="btn btn-default btn-flat">注销</a>
              </div>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>
</header>