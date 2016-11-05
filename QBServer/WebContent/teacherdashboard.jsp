<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="SideNavigation.jsp"/> 

<html class="st-layout ls-top-navbar-large ls-bottom-footer show-sidebar sidebar-l3" lang="en">
 <head>
  <title>Welcome</title>
  <link href="TeacherDashboardFiles/all.css" rel="stylesheet">
  <link href="TeacherDashboardFiles/app.css" rel="stylesheet">
 </head>

 <body>
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
	      <div class="panel-footer">
           <a  data-animated href="<c:url value="/TeacherCourseView" />"class="btn btn-success paper-shadow relative" data-z="0" data-hover-z="1" data-animated > View Courses</a>
          </div>
         </div>
        </div>
          
          <div class="item col-xs-12 col-lg-6">
           <div class="panel panel-default paper-shadow" data-z="0.5">
            <div class="panel-heading">
             <h4 class="text-headline margin-none">All Questions</h4>
             <p class="text-subhead text-light">Upload questions </p>
            </div>

            <div class="panel-footer text-right">
             <a class="btn btn-success paper-shadow relative" data-z="0" data-hover-z="1" data-animated href="<c:url value="/TeacherCourseView" />" >View Questions</a>
            </div>
           </div>
          </div>
          
        
         </div>
        </div>
       </div>
	  </div>
     </div>
			
		<!--  	<?php
 				  $row_count=1;

 while ($row = mysql_fetch_array($result)) {
            if($row_count<=3){
  ?>
                  <ul class="list-group">
                    <li class="list-group-item media v-middle">
                      <div class="media-body">
			<a href="WEB-INF/views/courses/teachercourseview.jsp" class="text-subhead list-group-link"><?php echo $row['course_name'] ?></a>
                      </div>
     
                  </ul>
				  	       <?php
	  }
	  
	  $row_count++;
	
	................ 			   }
 ?> -->
			   

               
		<!--  		  <?php
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
                          <span class="text-light"></span>
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
	  
	  
 ?>-->
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
            
        <!-- /st-content-inner -->

            <!-- /st-content-inner -->

      <!-- /st-content -->

    
    <!-- /st-pusher -->


    <!-- Footer -->
    
    <footer class="footer">
      <strong>QBMS</strong>  &copy; Copyright 2016
    </footer>
    <!-- // Footer -->

