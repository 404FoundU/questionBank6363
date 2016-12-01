<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="AdminSideNavigation.jsp"/>  

<html class="st-layout ls-top-navbar-large ls-bottom-footer show-sidebar sidebar-l3" lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Welcome</title>
  <link href="AdminDashboardFiles/all.css" rel="stylesheet">

  
  <link href="AdminDashboardFiles/app.css" rel="stylesheet">

</head>

<body>

  <!-- Wrapper required for sidebar transitions -->
  <div class="st-container">

    <!-- Fixed navbar -->
    <div class="navbar navbar-size-large navbar-default navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <a href="#sidebar-menu" data-toggle="sidebar-menu" class="toggle pull-left visible-xs"><i class="fa fa-ellipsis-v"></i></a>
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#main-nav">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <div class="navbar-brand navbar-brand-primary navbar-brand-logo navbar-nav-padding-left"> Team Charlie  
      </div>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="main-nav">
          <ul class="nav navbar-nav">
           
          </ul>
          <ul class="nav navbar-nav navbar-nav-bordered navbar-right">
             <!--Amin -->
            <!-- // Admin -->
            <!-- User -->
            <li class="dropdown">
             <li><a ><i class="fa fa-user" aria-hidden="true"></i>&nbsp;<span class="badge badge-primary" style ="font-size: 16px;">Admin</span></a></li>
        &nbsp     
<li><a  style= "padding-right: 62px;" href="index.jsp"><i class="fa fa-fw fa-sign-out">Logout</i>&nbsp</a></li>              </ul>
            </li>
          </ul>
        </div>
        <!-- /.navbar-collapse -->

      </div>
    </div>
	
	
	
	
	
	
	
	
	
	
	
	

    <!-- sidebar effects OUTSIDE of st-pusher: -->
    <!-- st-effect-1, st-effect-2, st-effect-4, st-effect-5, st-effect-9, st-effect-10, st-effect-11, st-effect-12, st-effect-13 -->
	
	
	
    <!-- content push wrapper -->
    <div class="st-pusher" id="content">

      <!-- sidebar effects INSIDE of st-pusher: -->
      <!-- st-effect-3, st-effect-6, st-effect-7, st-effect-8, st-effect-14 -->

      <!-- this is the wrapper for the content -->
      <div class="st-content">

        <!-- extra div for emulating position:fixed of the menu -->
        <div class="st-content-inner padding-none">

          <div class="container-fluid">

            <div class="page-section">
              <h1 class="text-display-1">Dashboard</h1>
            </div>

            <div class="row" data-toggle="isotope">
             
              <div class="item col-xs-12 col-lg-6">
                <div class="panel panel-default paper-shadow" data-z="0.5">
                  <div class="panel-heading">
                    <h4 class="text-headline margin-none">All Courses</h4>
                    <p class="text-subhead text-light">Uploded courses</p>
                  </div>

                  <ul class="list-group">
                    <li class="list-group-item media v-middle">
                      <div class="media-body">
						<a href="app-instructor-course-edit-course.html" class="text-subhead list-group-link"></a>
                      </div>
                  </ul>

                  <div class="panel-footer text-right">
                    <!-- <a href="adminvewcourses.php" class="btn btn-white paper-shadow relative" data-z="0" data-hover-z="1" data-animated>View all</a>
                    <a href="admincreatecourse.php" class="btn btn-primary paper-shadow relative" data-z="0" data-hover-z="1" data-animated>CREATE COURSE <i class="fa fa-plus"></i></a> -->
	           		<a  data-animated href="<c:url value="/AdminCourseView" />"class="btn btn-success paper-shadow relative" data-z="0" data-hover-z="1" data-animated > View Courses</a>
                  </div>
                </div>
              </div>
              
              <div class="item col-xs-12 col-lg-6">
                <div class="panel panel-default paper-shadow" data-z="0.5">
                  <div class="panel-heading">
                    <h4 class="text-headline margin-none">Users</h4>
                    <p class="text-subhead text-light">Recently Added Users</p>
                  </div>
			
                  <ul class="list-group">
                    <li class="list-group-item media v-middle">
                      <div class="media-body">
						<a href="" class="text-subhead list-group-link"></a>
                      </div>
     			  </ul>
				  	       
                  <div class="panel-footer text-right">
                    <a href="<c:url value="/UsersView" />" class="btn btn-white paper-shadow relative" data-z="0" data-hover-z="1" data-animated>View all</a>
                  </div>
                </div>
              </div>
        	</div>
        	
			<div class="row" data-toggle="isotope">
				<div class="item col-xs-12 col-lg-6">
                	<div class="panel panel-default paper-shadow" data-z="0.5">
                  		<div class="panel-heading">
                    		<h4 class="text-headline margin-none">All Departments</h4>
                    		<p class="text-subhead text-light">Uploded Departments</p>
                  		</div>

                  		<ul class="list-group">
                    		<li class="list-group-item media v-middle">
                      			<div class="media-body">
									<a href="app-instructor-course-edit-course.html" class="text-subhead list-group-link"></a>
                      			</div>
                  		</ul>

                  		<div class="panel-footer text-right">
	           				<a  data-animated href="<c:url value="/DepartmentsView" />"class="btn btn-success paper-shadow relative" data-z="0" data-hover-z="1" data-animated > View Departments</a>
                  		</div>
                	</div>
              	</div>
			</div>
        	<!-- /st-content-inner -->
		</div>
      	</div>
      	<!-- /st-content -->
	</div>
    </div>
    <!-- /st-pusher -->
    </div>
    </body>
<!-- Footer -->
    <footer class="footer">
      <strong>QBMS</strong>  &copy; Copyright 2016
    </footer>
    <!-- // Footer -->