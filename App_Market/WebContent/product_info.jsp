<%@page import="profit.interfaces.Register_Interface"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="profit.interfaces.Client_interface"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="StyleSheet" href="product_info.css">

<style type="text/css">
body {
	background-image: url("buy.jpg");
  background-size: 800px 600px;
}
</style>

</head>
<body>
<aside>
<img alt="image not support" src="image0.png" >
<h3>This Page Shows All Popular Apps</h3>
</aside>

<header>
<h1>Mobile Application</h1>
</header>

<section>

<div class="div1">
<%
Register_Interface inter=(Register_Interface)request.getAttribute("interface");
out.write("<img alt='image not suppoted' src='data:image/jpg;base64,"+inter.getImg_String()+"'/>");
%>
<h2><%=inter.getProduct_Name() %></h2>
<h2>Rs.<%=inter.getCost() %></h2>
</div>

<div class="div2">
<h3>Product Name:<%=inter.getProduct_Name() %></h3>
<h3>App Launcher Name:<%=inter.getYour_Name() %></h3>

<h3>Product Cost:Rs.<%=inter.getCost() %></h3>

<form action="buy_1.jsp">
<input type="text" value='<%=inter.getId()%>' name="id" hidden >
<input type="submit" value="Buy">

</form>

</div >
</section>

<footer>

</footer>


</body>
</html>