<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
          <div class="navbar-brand navbar-brand-primary navbar-brand-logo navbar-nav-padding-left ">
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a class="svg" href="index.jsp">
              <img style="margin-top:7px;" alt="" src="AdminDashboardFiles/logo.png" >
            </a>
          </div>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="main-nav">
          <ul class="nav navbar-nav">
           
          </ul>
          <ul class="nav navbar-nav navbar-nav-bordered navbar-right">
             <!--Amin -->
             <li >
              <a >
                <i class="fa fa-user" aria-hidden="true"></i>
                <span class="badge badge-primary">Admin</span>
              </a>
            
            </li>
            <!-- // Admin -->
            <!-- User -->
            <li class="dropdown">
            
                <li><a href="adminlogin.jsp">Logout</a></li>
              </ul>
            </li>
          </ul>
        </div>
        <!-- /.navbar-collapse -->

      </div>
    </div>
	
	<!-- Sidebar component with st-effect-1 (set on the toggle button within the navbar) -->
    <div class="sidebar left sidebar-size-3 sidebar-offset-0 sidebar-visible-desktop sidebar-visible-mobile sidebar-skin-dark" id="sidebar-menu" data-type="collapse">
      <div data-scrollable>

        <div class="sidebar-block">
          <div class="profile">
            <a href="#">
              <img src="admin.jpg" alt="people" class="img-circle width-80" />
            </a>
            <h4 class="text-display-1 margin-none"><?php echo $login_session; ?></h4>
          </div>
        </div>
		
        <ul class="sidebar-menu">
          <li class="active"><form action="" method="post"> <button name="subview" type="submit" value=" Coure View " class="btn btn-inverse" ><i class="fa fa-home"></i><span>Dashboard</span></button></form></li>
          <li><form action="" method="post"><button name="teacher_request" type="submit" value=" Create Course " class="btn btn-inverse"><i class="fa  fa-group"></i><span>Teacher Request</span></button></form></li>
          <li><form action="" method="post"><button name="teacher_view" type="submit" value=" Teacher View " class="btn btn-inverse"><i class="fa fa-user"></i><span>Teacher View</span></button></form></li>
          <li><form action="" method="post"><button name="create_course" type="submit" value=" Create Course " class="btn btn-inverse"><i class="fa fa-pencil-square"></i><span>Create Course</span></button></form></li>
          <li><form action="" method="post"><button name="assign_teacher" type="submit" value=" Assign Teacher " class="btn btn-inverse"><i class="fa fa-university"></i><span>Assign Teacher</span></button></form></li>
		  <li><form action="" method="post" ><button name="logout" type="submit" value="logout" class="btn btn-inverse"><i class="fa fa-sign-out"></i><span>Logout</span></button></form></li>
        </ul>
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
                    <a href="adminvewcourses.php" class="btn btn-white paper-shadow relative" data-z="0" data-hover-z="1" data-animated>View all</a>
                    <a href="admincreatecourse.php" class="btn btn-primary paper-shadow relative" data-z="0" data-hover-z="1" data-animated>CREATE COURSE <i class="fa fa-plus"></i></a>
                  </div>
                </div>
              </div>
                     <div class="item col-xs-12 col-lg-6">
                <div class="panel panel-default paper-shadow" data-z="0.5">
                  <div class="panel-heading">
                    <h4 class="text-headline margin-none">Teachers</h4>
                    <p class="text-subhead text-light">Recently Added Teachers</p>
                  </div>
			
                  <ul class="list-group">
                    <li class="list-group-item media v-middle">
                      <div class="media-body">
			<a href="" class="text-subhead list-group-link"></a>
                      </div>
     
                  </ul>
				  	       
                  <div class="panel-footer text-right">
                    <a href="teacherview.php" class="btn btn-white paper-shadow relative" data-z="0" data-hover-z="1" data-animated>View all</a>
                  </div>
                </div>
              </div>
                

        </div>
        <!-- /st-content-inner -->

      </div>
      <!-- /st-content -->

    </div>
    <!-- /st-pusher -->
    
    
<!-- Footer -->
    <footer class="footer">
      <strong>QBMS</strong>  &copy; Copyright 2016
    </footer>
    <!-- // Footer -->