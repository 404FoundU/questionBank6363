
<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
		<meta charset="utf-8">
		<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!--webfonts-->
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700' rel='stylesheet' type='text/css'>
		<!--//webfonts-->
</head>
<body>
	 <!-----start-main---->
	 <div class="main">
		<div class="login-form">
			<h1>Member Login</h1>
					<div class="head">
						<img src="images/user.png" alt=""/>
					</div>
				<form method="post" action="<%=request.getContextPath()%>/LoginController" class="login">
						<input type="text" class="text" value="USERNAME" placeholder="roleId" name="roleId" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'USERNAME';}" >
						<input type="password" value="Password" placeholder="password" name="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
						<div class="submit">
							<input type="submit"  value="LOGIN" >
							<input type="hidden" name="actionac" value="login1">
					</div>	
					
				</form>
			</div>
			<!--//End-login-form-->
			 <!-----start-copyright---->
   					<div class="copy-right">
						<p>Template by <a href="http://w3layouts.com">chaitanya</a></p> 
					</div>
				<!-----//end-copyright---->
		</div>
			 <!-----//end-main---->
		 		
</body>
</html>