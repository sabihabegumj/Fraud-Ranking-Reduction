
<%@page import="profit.interfaces.CloudAdmin_Interface"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="StyleSheet" href="cloudadmin.css">

<style type="text/css">
body {
	background-image: url("h.jpg");
	background-size: 500px 500px;
  }
  h2
  {
  color: black;
  }
</style>

</head>
<body>
<aside><div>
<h2><marquee direction="down" scrollamount="1">Admin gets the request from the App Launcher to make respective changes</h2></marquee></div>

</aside>

<header>
 </div>
<h1><marquee direction="right" scrollamount="2"><center>Admin Editorial Portal</center></marquee></h1>
</header>

<section>
<div align="center">
<table border="2px solid red">
<tr>
<th>Your Name</th>
<th>Date Of birth</th>
<th>Product Name</th>
<th>Cost</th>
<th>Priority</th>
<th>Edit</th>
</tr>


<%
List<CloudAdmin_Interface> list=(List<CloudAdmin_Interface>)request.getAttribute("interface");

System.out.println("jsp Size::"+list.size());
Iterator<CloudAdmin_Interface> iterator=list.iterator();

while(iterator.hasNext())
{
	CloudAdmin_Interface cloud=iterator.next();
%>
<tr>
<td><%=cloud.getYourName()%></td>
<td><%=cloud.getDob() %></td>
<td><%=cloud.getProductName() %></td>
<td><%=cloud.getCost() %></td>
<td><%=cloud.getPriority() %></td>
<%out.write("<td><a href='edit.jsp?id="+cloud.getId()+"'>edit</a></td>");%>
</tr>
<%
}
%>

</table>
</div>

</section>

<footer>
</footer>



</body>
</html>