<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<!-- <meta charset="UTF-8"> -->
    
  		<link href="TeacherDashboardFiles/all.css" rel="stylesheet">

	 	<link href="TeacherDashboardFiles/app.css" rel="stylesheet">
    
		<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
		
		<title>Add New Course</title>
	</head>
	<body>  
		<div class="container">
  			<div class="info">
  
	    		<h1>QBMS</h1><span>Question Bank Management System</span> 
  			</div>
		</div>
		
   		<!-- content push wrapper -->
    	<div class="st-pusher" id="content">
      		<!-- this is the wrapper for the content -->
      		<div class="st-content">
        		<!-- extra div for emulating position:fixed of the menu -->
        		<div class="st-content-inner padding-none">
          			<div class="container-fluid">
            			<div class="page-section">
              				<h1 class="text-display-1">Course</h1>
            			</div>
            			
            			<div class="row" data-toggle="isotope">
              
              				<div class="item col-xs-12 col-lg-6">
                				<div class="panel panel-default paper-shadow" data-z="0.5">
                				
                  					<div class="panel-heading">
										<div class="form">

    										<div class="form-group">
    											<div>
    												<label><strong>Course Name</strong></label>
    											</div>
     											<div class="form-control-material">
     												</label><label>${course.courseName}</label>
 												</div>
    										</div>
   
   											<div class="form-group">
   												<div>
    												<label><strong>Course Dept/Number</strong></label>
   												</div>
   												<div class="form-group form-control-material static required">
     												<label>${course.deptName}-${course.courseNumber}</label>
   												</div>
   											</div>
   
   											<div class="form-group">
   												<div>
    												<label><strong>Credits</strong></label>
   												</div>
   												<div class="form-control-material static required">
     												<label>${course.credit}</label>
     											</div>
   											</div>

 										</div>
                  					</div>
                  				</div>
                  				<div class="panel-header">
                  					<a href="<c:url value="/TeacherCourseView" />" >List</a>&nbsp&nbsp|&nbsp
                  					<a href="<c:url value="EditCourse">
      											<c:param name="id" value="${course.id}" />
      										</c:url>">Edit</a>
                    			</div>
                  			</div>
        				</div>
        			</div>
        		</div>
			</div>
		</div>

	</body>
</html>