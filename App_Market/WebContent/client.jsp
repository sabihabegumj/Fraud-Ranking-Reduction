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
<link rel="StyleSheet" href="client.css">
<style type="text/css">
body {
	background-image: url("mm.jpg");
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
<h1>Mobile Application Market</h1>
</header>

<section>

<% 
List<Client_interface> list=(List<Client_interface>)request.getAttribute("interface");
if(list!=null)
{
	System.out.println("jsp list not null"+list.size());
	
	
Iterator<Client_interface> iterate=list.iterator();


while(iterate.hasNext())
{
  Client_interface client=iterate.next();
  System.out.println("pram id::"+client.getID());
  System.out.println("pram priority::"+client.getPriority());
  out.write(" <div> ");
  out.write("<form action='client_action.jsp'>");
  out.write("<input type='text' name='id' value='"+client.getID()+"' hidden>");
  out.write("<input type='text' name='priority' value='"+client.getPriority()+"' hidden>");
  out.write("<input type='image' alt='image not support' src='data:image/jpg;base64,"+client.getImg()+"' >");
  out.write("<h3>"+client.getName()+"</h3>");
  out.write("<h4>Rating: "+client.getRank()+"</h4>");

  out.write("</form>");
  out.write("</div>");
  
}

}
else
{
	System.out.println("jsp list Null");
}
%>



</section>

<footer>

</footer>


</body>
</html>