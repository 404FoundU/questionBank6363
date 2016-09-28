<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.bean.Loginbean" %>
<%@page import="com.bean.Questionbean"%>
<%@page import="com.bean.CourseBean"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="java.util.List"%>
   
    

<html>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/FinalStyle.css">
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
<script type="text/javascript" charset="utf8" src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript" charset="utf8" src="<%=request.getContextPath()%>/javascript/script.js"></script>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.1.min.js"></script>
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.1/jquery.dataTables.min.js"></script>
		<script type="text/javascript" charset="utf-8">
			$(document).ready(function() {
				$('#example').dataTable({
					
					// "sPaginationType": "full_numbers",
				});
			
			} );
		</script>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Delete Questions</title>
		
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
			<div class="innertube" >
	<h4>Details of questions from all the Streams</h4>
	<form action="<%=request.getContextPath()%>/QuestionController?action=deleteQues" method="POST">
				
	<table border="2"  id="example" style="top: inherit;" >
	
		<thead>
				<tr>
			
				<th>select</th> 
								<th>question</th>
				<th>delete</th>
				</tr>
			</thead>
	<tbody>
	 <%
		ArrayList<Questionbean> tbean = (ArrayList<Questionbean>) request.getAttribute("viewlist");
	%>
	<%
		if(tbean!=null){
		for (Questionbean bean : tbean) {
	%>
	
			<tr>
			<td><input type="radio" value="<%=bean.getQID()%>" name="deleteItem">
		<td><%=bean.getQuestion()%></td>
		
       <td> <input type="submit" value="Delete" /></td>	
			 </tr>
		<%
		}}
		%>
		</tbody>
		
	</table>
	<!-- <input type="submit"  value="Delete" />
	<input type="hidden" name="action" value="deleteQues" /> -->
	</form>

				
								
			</div>
		</main>

		<nav id="nav">
			
			<div id='cssmenu'>
<ul>
   <li><a href="<%=request.getContextPath() %>/FacultyController?action=addFaculty"><span>Add Senior Faculty</span></a></li>
   <li class='active has-sub'><a href='#'><span>Faculty menu</span></a>
      <ul>
         <li class='has-sub'><a href='#'><span>Questions menu</span></a>
            <ul>
               <li><a href="<%=request.getContextPath() %>/QuestionController?action=addQues"><span>Add Questions</span></a></li>
               <li class='last'><a href="<%=request.getContextPath() %>/QuestionController?action=viewQues"><span>Make Question Paper</span></a></li>
            </ul>
         </li>
         <li class='has-sub'><a href='#'><span>Modify Questions</span></a>
            <ul>
               <li><a href="<%=request.getContextPath() %>/QuestionController?action=editQuesPage"><span>Edit Questions</span></a></li>
               <li class='last'><a href="<%=request.getContextPath() %>/QuestionController?action=DeleteQuesPage"><span>Delete Questions</span></a></li>
            </ul>
         </li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Course menu</span></a>
          <ul>
               <li><a href="<%=request.getContextPath() %>/FacultyController?action=assignCourse"><span>Assign Course To Faculty</span></a></li>
               <li class='last'><a href='#'><span>View Available Courses</span></a></li>
             <li class='last'><a href="<%=request.getContextPath() %>/CourseController?action=addCourse"><span>Add Course To List</span></a></li>
               
            </ul>
     
   </li>
   <li><a href='#'><span>About</span></a></li>
   <li class='last'><a href='#'><span>Contact</span></a></li>
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