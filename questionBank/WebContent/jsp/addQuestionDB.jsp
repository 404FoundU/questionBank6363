<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.bean.Loginbean" %>
<%@page import="com.bean.Questionbean"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="java.util.List"%>
    

<html>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/FinalStyle.css">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Add Ques</title>
		
		<script type="text/javascript">
			
		</script>	
	
	</head>
	
	<body>		

		<header id="header">
			<div id="logo">
				<p><span style="color:white">WELCOME <b></b></span><%=session.getAttribute("roleName")%></p>
                <p><span style="color:white">ROLE:<%=session.getAttribute("roleId")%></span></p>
<img src="<%=request.getContextPath()%>/images/admin.png" style="float: right;">
			</div>
		</header>
				
		<main>
			<div class="innertube">
				
				

				
			</div>
		</main>

		<nav id="nav">
			<div class="innertube">
				<h1>Heading</h1>
				<ul>
		<li><a href="<%=request.getContextPath() %>/FacultyController?action=addFaculty">Add Senior Faculty</a></li>
         <li><a href="<%=request.getContextPath() %>/FacultyController?action=assignCourse">Assign Course</a></li>
         <li><a href="<%=request.getContextPath() %>/QuestionController?action=addQues">addQuesToDb</a></li>
         <li><a href="<%=request.getContextPath() %>/QuestionController?action=viewQues">view ques</a></li>
         <li><a href="<%=request.getContextPath() %>/QuestionController?action=editQuesPage">Edit Question</a></li>
         <li><a href="<%=request.getContextPath() %>/QuestionController?action=DeleteQuesPage">Delete Questions</a></li>
         		</ul>
				
				</ul>
			</div>
		</nav>	
			
<footer id="footer">
			<div class="innertube">
				<p>Copy rights Team C...</p>
			</div>
		</footer>	
			
		
	</body>
</html>