
<%@page import="java.util.Enumeration"%>
<%@page import="profit.interfaces.history_interface"%>
<%@page import="java.util.Hashtable"%>
<%@page import="profit.interfaces.CloudAdmin_Interface"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>log</title>
<link rel="StyleSheet" href="cloudadmin.css">

<style type="text/css">
body {
	background-image: url("pic1.jpg");
    color: yellow;
}
h1{color: Red;

}
h2
{color: white;
}
</style>

</head>
<body>
<aside>

<img alt="image not support" src="image0.png" >


</aside>

<header>
<h1>Launcher's Logs</h1>
</header>

<section>
<div align="center">

<%Hashtable table=(Hashtable<String,List<history_interface>>)request.getAttribute("data"); 

Enumeration<String> en=table.keys();

while(en.hasMoreElements())
{
String key=en.nextElement();
%>
<table border="2px solid red" style="margin-bottom: 3%">
<caption><%=key %></caption>
<tr>
<th>Product id</th>
<th>Data Owner Id</th>
<th>Email Id</th>
<th>Date</th>
<th>Time</th>
<th>Rank</th>
<th>Card</th>
<th>Ip</th>
</tr>


<%
List<history_interface> list=(List<history_interface>)table.get(key);

System.out.println("jsp Size::"+list.size());
Iterator<history_interface> iterator=list.iterator();

while(iterator.hasNext())
{
	history_interface cloud=iterator.next();
%>
<tr>
<td><%=cloud.id%></td>
<td><%=cloud.pid %></td>
<td><%=cloud.eid %></td>
<td><%=cloud.date %></td>
<td><%=cloud.time %></td>
<td><%=cloud.rank %></td>
<td><%=cloud.card %></td>
<td><%=cloud.ip %></td>

</tr>
<%
}
%>

</table>

<%
}
%>
</div>

</section>

<footer>
</footer>



</body>
</html>