<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>	
<title>Email Id</title>
<meta charset="utf-8">
<link href="css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='http://fonts.googleapis.com/css?family=Arimo:400,700,400italic' rel='stylesheet' type='text/css'>
<style type="text/css">
body {
	background-image: url("afterb.jpg");
  
}
</style>

</head>
<body>


				 <!-----start-main---->
				 <div class="login-form">
			 		<div class="logo">
	         			 <img src="images/logo.png" alt=""/>
					</div>
			 		<h1>The OTP is sent to the Email Id</h1>	
			 		<form action="buy_done">
						<input type="text" class="text" name="email" value="Type your email address..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type your email address...';}" >
						<input type="text" value='<%=(String)request.getAttribute("id")%>' name="id" hidden>
						<input type="submit"  value="" >
		 			</form>
				 </div>
		  		
		 		
</body>
</html>