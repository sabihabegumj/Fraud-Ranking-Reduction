<!DOCTYPE html>
<%@page import="profit.controller.Controller"%>
<%@page import="java.util.Random"%>
<html >
<head>
  <meta charset="UTF-8">
  <title>confirmation page</title>
   <link rel="stylesheet" href="css/style43.css">
<style type="text/css">
body {
	background-image: url("ch.jpg");
  background-size: 2000px 1000px;
}
</style>
  
</head>

<body>
  <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

<%
Random ran=new Random();

String as=""+ran.nextInt(2000) ;
Controller.buy_id=as;
%>

<div class="wrapper">
  <h1>Thanks for the Purchase</h1>
  <p> <h2>Please note down the Purchase Id - <%=as%> for Rating Purpose<h2></h2></p>
  
  <p> <h1>Would you like to rate the App?</h1></p>
  
  <form class="form"  action="purchase_confirmation" >
   <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
    <input type="hidden" name="status" value="yes">
    <input type="submit" class="submit" value="YES">
  </form>
  
  <form class="form"  action="index.html">
  <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
    <input type="hidden" name="status" value="no" onclick="index.html">
    <input type="submit" class="submit" value="No" onclick="index.html">
  </form>
  
  
</div>
<p class="optimize">
 
</p>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/index43.js"></script>

</body>
</html>
