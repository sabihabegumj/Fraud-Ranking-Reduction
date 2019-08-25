<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd>
<html >
  <head>
    <meta charset="UTF-8">
    <title>password</title>
    
   
        <link rel="stylesheet" href="css/style4.css">
<style type="text/css">
body {
	background-image: url("nv.png");
  background-size: 800px 600px;
}
</style>
  </head>

  </head>

  <body>

    <div class="wrapper">
	<div class="container">
		<h1>Welcome</h1>
		
		<form class="for" action="one_time_validate" method="get"> 
		    <input type="hidden" value='<%=(String)request.getAttribute("id")%>' name="id"   >
			<input type="hidden" value='<%=(String)request.getAttribute("email")%>' name="email" >
			<input type="text" placeholder="One Time Password" name="password" >
			<button type="submit" id="login-butto">Next</button>
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

    
    
    
  </body>
</html>
