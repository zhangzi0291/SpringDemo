<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
          	<c:if test="${not empty user.userImg  }">
	            <img src="${basePath }/uploadfile/user/${user.userImg }" class="user-image" alt="User Image">
          	</c:if>
          	<c:if test="${empty user.userImg  }">
	            <img src="${basePath }/img/user.png" class="user-image" alt="User Image">
          	</c:if>
            <span class="hidden-xs">${user.userAccount }</span>
          </a>
          <ul class="dropdown-menu">
            <!-- User image -->
            <li class="user-header">
	          	<c:if test="${not empty user.userImg  }">
		            <img src="${basePath }/uploadfile/user/${user.userImg }" class="img-circle" alt="User Image">
	          	</c:if>
	          	<c:if test="${empty user.userImg  }">
		            <img src="${basePath }/img/user.png" class="img-circle" alt="User Image">
	          	</c:if>
				<p>
	                ${user.userName }
				</p>		
            </li>
            <!-- Menu Footer-->
            <li class="user-footer">
              <div class="pull-left">
                <a href="${basePath }/user/edit.html?userId=${user.userId}" class="btn btn-default btn-flat">详情</a>
              </div>
              <div class="pull-right">
                <a href="${basePath }/logout" class="btn btn-default btn-flat">注销</a>
              </div>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>
</header>