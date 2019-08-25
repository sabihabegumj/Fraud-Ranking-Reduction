<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd>
<html >
  <head>
    <meta charset="UTF-8">
    <title>buy id verification</title>
    
   
        <link rel="stylesheet" href="css/style4.css">
<style type="text/css">
body {
	background-image: url("b.jpg");
  background-size: 800px 600px;
}
</style>
  </head>

  <body>

    <div class="wrapper">
	<div class="container">
		<h1>Enter Purchase ID</h1>
		
		<form class="for" action="buy_id_done" method="get"> 
		    <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
			<input type="text" placeholder="Purchase Id" name="buy_id" >
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
