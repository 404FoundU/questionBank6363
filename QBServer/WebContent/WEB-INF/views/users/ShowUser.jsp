<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${isAdmin}">
		<jsp:include page="../../../AdminSideNavigation.jsp"/>
	</c:when>
	<c:otherwise>
		<jsp:include page="../../../SideNavigation.jsp"/>
	</c:otherwise>
</c:choose>  

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  		<link href="TeacherDashboardFiles/all.css" rel="stylesheet">
	 	<link href="TeacherDashboardFiles/app.css" rel="stylesheet">
		<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
		
		<title>Show User</title>
	</head>
	<body>  
    	<div class="st-pusher" id="content">
      		<!-- this is the wrapper for the content -->
      		<div class="st-content">
        		<!-- extra div for emulating position:fixed of the menu -->
        		<div class="st-content-inner padding-none">
          			<div class="container-fluid">
        				<div class="container">
  							<div class="info">
	    						<h1>QBMS</h1><span>Question Bank Management System</span> 
  							</div>
						</div>
	
            			<div class="page-section">
              				<h1 class="text-display-1">User</h1>
            			</div>
            			
            			<div class="row" data-toggle="isotope">
                		 	<div class="item col-xs-30 col-lg-15">
                		  		<div class="panel panel-default paper-shadow" data-z="10">
                		   			<div class="panel-heading">
										<div class="form">

    										<div class="form-group">
    											<div>
    												<label><strong>User Name</strong></label>
    											</div>
     											<div class="form-control-material static required">
     												<label>${user.userName}</label>
 												</div>
    										</div>

    										<div class="form-group">
    											<div>
    												<label><strong>First Name</strong></label>
    											</div>
     											<div class="form-control-material static required">
     												<label>${user.firstName}</label>
 												</div>
    										</div>
   
   											<div class="form-group">
   												<div>
    												<label><strong>Last Name</strong></label>
   												</div>
   												<div class="form-group form-control-material static required">
     												<label>${user.lastName}</label>
   												</div>
   											</div>
   
   											<div class="form-group">
   												<div>
    												<label><strong>Is Admin</strong></label>
   												</div>
   												<div class="form-control-material static required">
     												<label>${user.admin ? "Yes" : "No"}</label>
     											</div>
   											</div>
										</div>
                  					</div>
                  				</div>
                  				<div class="panel-header">
                  					<c:if test="${isAdmin}">
                  						<a class="btn btn-success paper-shadow relative" href="<c:url value="/UsersView" />" >List Users </a>&nbsp;
                  					</c:if>
                  					<a class="btn btn-success paper-shadow relative" href="<c:url value="/EditUser">
      											<c:param name="id" value="${user.id}" />
      										</c:url>">Edit User</a>&nbsp;
      								<a class="btn btn-success paper-shadow relative" data-z="0" data-hover-z="1" data-animated href="<c:url value="/ResetUserPsw">
												<c:param name="userId" value="${user.id}" />
											</c:url>" >Reset Password</a>&nbsp;
                
                    			</div>
                  			</div>
        				</div>
        				
        				
        				
        				
        				
        				
        				<div class="page-section">
              				<h1 class="text-display-1">Questions and Answers</h1>
            			</div>
            			
            			<div class="row" data-toggle="isotope">
                		 <div class="item col-xs-30 col-lg-15">
                		 		     <div class="panel panel-default paper-shadow" data-z="10">
                		   <div class="panel-heading">
                		   
                
										<div class="form">

    										

											<div class="form-group">
												
												
                				<!-- COURSE QUESTIONS -->
                  					<div class="panel-heading">
                    					<div class="table-list-content">
											<table width="100%">
												<tr>
													<th width="8%">Chapter</th>
													<th width="23%">Question</th>
													<th width="23%">Answer</th>
													<th width="7%"></th>
												</tr>
  												<c:forEach items="${questions}" var="question">
  												<tr>
      													<td><c:out value="${question.chapter}" /></td>
      													<td><c:out value="${question.question}" /></td>
      								 				    <td><c:out value="${question.answer}" /></td> 
      													<td>
      														<a href="<c:url value="/ShowQuestion">
      																	<c:param name="id" value="${question.id}" />
      																</c:url>">Show</a>&nbsp;&nbsp;|&nbsp;
      														<a href="<c:url value="/EditQuestion"> 
      																	<c:param name="id" value="${question.id}" />
      																	<c:param name="answerId" value="${question.answerId}"/>  
      																	</c:url>">Edit</a>
      													</td>
    												</tr>
  												</c:forEach>
											</table>
                    					</div>
                  					</div>
												
											</div>
 										</div>
                  					</div>
                  				</div>
                  				
                  			</div>
        				</div>
        				
        				
        				
        				
        				
        				
        				
        				
        				
        				
        				
        			</div>
        		</div>
			</div>
		</div>

	</body>
	<footer class="footer">
      <strong>QBMS</strong>  © Copyright 2016
    </footer>
</html>