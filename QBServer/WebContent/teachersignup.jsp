<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html >
  <head>
    <meta charset="UTF-8">
    <title>QBMS</title>
    <link rel="stylesheet" href="TeacherFiles/reset.css">
    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Montserrat:400,700'>
    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="TeacherFiles/stylesss.css">
    
  </head>

  <body>
   <div class="container">
    <div class="info">
     <a href="index.jsp" style= "text-decoration: none !important; color:white;"><h1>QBMS</h1><span>Question Bank Management System</span></a> 
    </div>
   </div>
   
  <div class="form">
    <div class="thumbnail"><img src="TeacherFiles/54.png" onclick="window.location.href='index.jsp'"/></div>
   
   <div > 
    <h3 style=" margin-bottom: 10px; margin-top: -20px; color: #2DBE60; "> Teacher </h3> 
   </div>

   <form action="TeacherSignup" method="post">
    <div class="form-group" >
     <div class="form-control-material">
      <input class="form-control" id="username" name="username" type="text" required maxlength="60" placeholder="Enter Username">
     </div>
    </div>
   
   <div class="form-group form-control-material static required">
    <input type="text" class="form-control" name= "firstname" id="Firstname" maxlength="60" placeholder="Enter Firstname">
   </div>
                       
   <div class="form-group form-control-material static required">
    <input type="text" class="form-control" name= "lastname" id="Lastname" maxlength="60" placeholder="Enter Lastname">
   </div>
   
   <div class="form-group">
    <div class="form-control-material static required">
    <input class="form-control" id="password" name="password" type="password" required maxlength="13" placeholder="Enter Password">
    </div>
   </div>
   
   <div class="form-group">
    <div class="form-control-material static required">
     <input class="form-control" id="password2" name="rpassword" type="password" required maxlength="13" placeholder="Confirm Password">
    </div>
   </div>
	
   <div class="form-group">
    <div class="form-control-material">
     <input class="form-control" id="contact" name="contact" type="number" required placeholder="Enter Contact" maxlength="11">
    </div>
  </div>

  
   <div class="form-group">
    <select id="gender" name="gender" style="/* width: 100%; *//* margin-bottom: 10px; *//* color: #A9A9A9; *//* background-color: #F2F2F2; *//* padding-top: 17px; */outline: 0;      background: #f2f2f2;      width: 100%;      border: 0;      margin: 0 0 15px;      padding: 15px;      border-top-left-radius: 3px;      border-top-right-radius: 3px;      border-bottom-left-radius: 3px;      border-bottom-right-radius: 3px;      box-sizing: border-box;      font-size: 14px;color: darkgrey;" data-toggle="select2">
     <optgroup label="Gender Type">
       <option value="Male">Male</option>
       <option value="Female">Female</option>
	   <option value="Other">Other</option>                  
     </optgroup>
	</select>               
   </div>
 
<button name="submit" type="submit">Create <i class="fa fa-user"></i></button>
   <p class="message">Already registered? <a href="teacherlogin.jsp">Sign In</a></p>
  
  </form>
 </div>

  <video id="video" autoplay="autoplay" loop="loop" poster="polina.jpg">
   <source src="http://andytran.me/A%20peaceful%20nature%20timelapse%20video.mp4" type="video/mp4"/>
  </video>
 
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
  <script src="TeacherFiles/index.js"></script>
   
 </body>
</html>

