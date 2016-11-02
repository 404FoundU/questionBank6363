<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

   

<html class="st-layout ls-top-navbar-large ls-bottom-footer show-sidebar sidebar-l3" lang="en">
 <head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  
  <title>Welcome</title>
 
  <link href="TeacherDashboardFiles/all.css" rel="stylesheet">
  <link href="TeacherDashboardFiles/app.css" rel="stylesheet">
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
      
      <div class="navbar-brand navbar-brand-primary navbar-brand-logo navbar-nav-padding-left">
       QBMS Dashboard<a class="svg" href="index.jsp">
        <img style="margin-top:7px;" alt="" src="TeacherDashboardFiles/logo.png" >
       </a>
      </div>
     </div>

     <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="main-nav">
       <ul class="nav navbar-nav">
           
       </ul>
       <ul class="nav navbar-nav navbar-nav-bordered navbar-right">
        <!-- Teacher -->
         <li >
          <a>
           <i class="fa fa-user" aria-hidden="true"></i>
            <span class="badge badge-primary">Teacher</span>
          </a>
            
         </li>
            <!-- // Teacher -->
            <!-- User -->
         <li class="dropdown">
           <li><a href="teacherlogin.jsp">Logout</a></li>
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
              <img src="../TeacherDashboardFiles/logo.png" alt="people" class="img-circle width-80" />
            </a>
            <h4 class="text-display-1 margin-none"><?php echo $login_session; ?></h4>
          </div>
        </div>

        <ul class="sidebar-menu">
          <li class="active"> <a href="teacherdashboard.jsp" /> <i class="fa fa-bar-chart-o"></i><span>Dashboard</span></a></li>
          <li class="hasSubmenu">
            <a href="<c:url value="/TeacherCourseView"/>" ><i class="fa fa-book"></i><span>Courses</span></a>
            <ul id="course-menu">
          		<li><form action=" " method="post"> <input type="hidden"  name="tid" value= ""/>
				<button name="courseview" type="submit" value=" Course View " href="<c:url value="/TeacherCourseView" />" " class="btn btn-inverse"><span>My Courses</span></button></form></li>
             	<li><form action="" method="post"> <input type="hidden"  name="tid" value=""/>
				<button name="uploadlecture" type="submit" value=" Assign Leacture " href="AddQuestion" class="btn btn-inverse"><span>Upload Questions</span></form></li>   
             	<li><form action="" method="post"> <input type="hidden"  name="tid" value= ""/>
				<button name="viewlectureofcourse" type="submit" value=" Lecture View " href="ShowQuestion" class="btn btn-inverse">View Questions</span></form></li>           			  
       		</ul>
          </li>
          <!--  
    <li class="hasSubmenu">
            <a href="#student-menu"><i class="fa fa-user"></i><span>Students</span></a>
            <ul id="student-menu">
          <li><form action="" method="post"> <input type="hidden"  name="tid" value= ""/>
<button name="studentview" type="submit" value=" student View " class="btn btn-inverse"><span>Students View</span></button></form></li>          			  
       </ul>
          </li>
		  <li class="hasSubmenu">
            <a href="#quiz-menu"><i class="fa fa-edit"></i><span>Quiz</span></a>         
			<ul id="quiz-menu">
		<li><form action="" method="post"> <input type="hidden"  name="tid" value= ""/>
<button name="chosecourseforquiz" type="submit" value="chosecourseforquiz" class="btn btn-inverse"><span>Upload Quiz</span></button></form></li>  	
		<li><form action="" method="post"> <input type="hidden"  name="tid" value= ""/>
<button name="quizdownload" type="submit" value="quizdownload" class="btn btn-inverse"><span>Download Solution</span></button></form></li> 
		<li><form action="" method="post"> <input type="hidden"  name="tid" value= ""/>
<button name="quizhistory" type="submit" value="quizhistory" class="btn btn-inverse"><span>Quiz History</span></button></form></li>  	
 		
			 </ul>
          </li>
		    <li class="hasSubmenu">
            <a href="#assignment-menu"><i class="md md-assignment"></i><span>Assignment</span></a>         
			<ul id="assignment-menu">
		<li><form action="" method="post"> <input type="hidden"  name="tid" value= ""/>
<button name="assignmentchosecourse" type="submit" value="chosecourseforquiz" class="btn btn-inverse"><span>Upload Assignment</span></button></form></li>  	
			<li><form action="" method="post"> <input type="hidden"  name="tid" value= ""/>
<button name="assignmenthistory" type="submit" value="quizhistory" class="btn btn-inverse"><span>Assignment History</span></button></form></li>  				
			 </ul>
          </li>
		  <li class="hasSubmenu">
            <a href="#activity-menu"><i class="fa fa-bar-chart-o"></i><span>Student Activities</span></a>
            <ul id="activity-menu">
		
              <li><form action="" method="post"> <input type="hidden"  name="tid" value= ""/>
<button name="LA" type="submit" value="lectureActivity" class="btn btn-inverse"><span>Lecture Activities</span></button></form> </li>      
  <li><form action="" method="post"> <input type="hidden"  name="tid" value= ""/>
<button name="CA" type="submit" value="courseactivity" class="btn btn-inverse"><span>Course Activities</span></button></form> </li>      
<li><form action="" method="post"> <input type="hidden"  name="tid" value= ""/>
<button name="CG" type="submit" value="coursegraph" class="btn btn-inverse"><span>Course Graph</span></button></form> </li>      
            </ul>
          </li>
          <li class="hasSubmenu">
            <a href="#forum-menu"><i class="fa fa-file-text-o"></i><span>Forum</span></a>
            <ul id="forum-menu">
		
              <li><form action="" method="post"> <input type="hidden"  name="tid" value= ""/>
<button name="formhome" type="submit" value="form" class="btn btn-inverse"><span>Forum Home</span></button></form> </li>      
  
            </ul>
          </li>
          <li class="hasSubmenu">
            <a href="#account-menu"><i class="fa fa-user"></i><span>Account</span></a>
            <ul id="account-menu">
           <li><form action="" method="post">
<button name="editprofile" type="submit" value="editprofile" class="btn btn-inverse"><span>Edit Profile</span></button></form></li>
             
            </ul>
          </li>
		    -->
		    
          <li><a  href="teacherlogin.jsp" class="fa fa-sign-out"></i><span>Logout</span></a></li>
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
                    <p class="text-subhead text-light">Upload courses</p>
                  </div>
			<?php
 				  $row_count=1;

 while ($row = mysql_fetch_array($result)) {
            if($row_count<=3){
  ?>
                  <ul class="list-group">
                    <li class="list-group-item media v-middle">
                      <div class="media-body">
			<a href="teachercourseview.jsp?tid=<?php echo $Login_id?>" class="text-subhead list-group-link"><?php echo $row['course_name'] ?></a>
                      </div>
     
                  </ul>
				  	       <?php
	  }
	  
	  $row_count++;
				   }
 ?>

                  <div class="panel-footer text-right">
                    <a class="btn btn-success paper-shadow relative" data-z="0" data-hover-z="1" data-animated href="<c:url value="/TeacherCourseView" />" >View Courses</a>
                  </div>
                </div>
              </div>
			   

               <div class="item col-xs-12 col-lg-6">
                <div class="panel panel-default paper-shadow" data-z="0.5">
                  <div class="panel-heading">
                    <h4 class="text-headline margin-none">All Questions</h4>
                    <p class="text-subhead text-light">Upload questions </p>
                  </div>
				  <?php
				  $row_count=1;
				   while ($row = mysql_fetch_array($result1)) {
      if($row_count<=3){
  ?>
                  <ul class="list-group">
                    <li class="list-group-item media v-middle">
                      <div class="media-body">
                        <h4 class="text-subhead margin-none">
                          <a  class="list-group-link"><?php echo $row['quiz_obj_title']?></a>
                        </h4>
                        <div class="caption">
                          <span class="text-light">Course:</span>
                          <a ><?php echo $row['course_name']?></a>
                        </div>
                      </div>
                      <div class="media-right text-center">
                        <div class="text-display-12"><?php echo $row['quiz_obj_type']?></div>
                      </div>
                    </li>
                  </ul>
				             <?php
				   }
				   $row_count++;
				   }
	  
	  
 ?>
                  <div class="panel-footer">
                    <a href="quizcourseview.php?tid=<?php echo $Login_id?>" class="btn btn-success paper-shadow relative" data-z="0" data-hover-z="1" data-animated > View Questions</a>
<<<<<<< HEAD
                  </div>
                </div>
              </div>
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              <div class="item col-xs-12 col-lg-6">
                <div class="panel panel-default paper-shadow" data-z="0.5">
                  <div class="panel-heading">
                    <h4 class="text-headline margin-none">All Questions</h4>
                    <p class="text-subhead text-light">Uploded Questions</p>
                  </div>
			<?php
 				  $row_count=1;

 while ($row = mysql_fetch_array($result)) {
            if($row_count<=3){
  ?>
                  <ul class="list-group">
                    <li class="list-group-item media v-middle">
                      <div class="media-body">
			<a href="teachercourseview.php?tid=<?php echo $Login_id?>" class="text-subhead list-group-link"><?php echo $row['course_name'] ?></a>
                      </div>
     
                  </ul>
				  	       <?php
	  }
	  
	  $row_count++;
				   }
 ?>

                  <div class="panel-footer text-right">
                    <a class="btn btn-success paper-shadow relative" data-z="0" data-hover-z="1" data-animated href="<c:url value="/TeacherCourseView" />" >View Courses</a>
=======
>>>>>>> d8071510a1621a79370bd56ae835a9576de52a08
                  </div>
                </div>
              </div>
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
			  						            
	   
                      </tbody>
		

                    </table>
                  </div>
			
                </div>
              </div>
		 	<!--    
     <div class="item col-xs-12 col-lg-6" style ="background-color: white;">
	 	   <h4 class="text-headline margin-none">Forum Activity</h4>
		   
                <p class="text-subhead text-light">Latest forum topics & comments</p>
				
	      <ul class="list-group relative paper-shadow" data-hover-z="0.5" data-animated>
		  	  
		  	                           <li class="list-group-item paper-shadows">
                    <div class="media v-middle">
                      <div class="media-left">
                        <a href="#">
                          <img src="images/<?php echo $row['user_pic']?>" alt="person" class="img-circle width-40" />
                        </a>
                      </div>
                      <div class="media-body">
                        <a href="forumdetail.php?uid=<?php echo $Login_id?>&utype=<?php echo 'teacher'?>&username=<?php echo $row['forum_postby']?>&userpic=<?php echo $row['user_pic']?>&forumid=<?php echo  $row['forum_id']?>&screen=<?php echo 0 ?>" class="text-subhead link-text-color"><?php echo $row['forum_question']?></a>
                        <div class="text-light">
                          Topic: <a><?php echo $row['forum_title']?></a> &nbsp; By: <a><?php echo $row['forum_postby']?></a>
                        </div>
                      </div>
                     <div class="media-right">
                        <div class="width-60 text-right">
					                          <td><?php echo $date ?></td>

                          
                        </div>
                      </div>
                    </div>
					
                  </li> 
			  		  
                </ul>		
              </div>
		-->	  
        </div>
        
        <!-- /st-content-inner -->

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

  </div>