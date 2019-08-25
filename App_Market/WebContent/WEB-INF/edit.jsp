<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="StyleSheet" href="register.css">
</head>
<body>
<header>
<h2>Cloud Admin Editor Port</h2>
</header>
<div align="center">
<%
String id=(String)request.getAttribute("id");
out.write("<form action='edit_done.jsp?id="+id+"' method='post' enctype='multipart/form-data'>");
%>

Your Name<br><input type="text" name="name" title="Must Enter Your name" placeholder="Update your name"><br>
Your DOB<br><input type="date" name="dob" title="Must Enter Your DOB" placeholder=" update Date Of birth" ><br>
Product Name<br><input type="text" name="product" title="must Enter Rpoduct Name" placeholder="UPdate Product name" ><br>
product Cost<br><input type="number" name="cost" title="must Enter Producy Cost" placeholder="Update cost" ><br>
priority <br><input type="number" name="priority" placeholder="Enter Priority" min="0" max="10"><br>
product Image::<br><input type="file" name="img" accept="image/*"><br>
Email <br><input type="mail" name="mail" ><br>

password<br><input type="password" name="password" hidden><br>
<br><input type="submit" >

</form>
</div>

<footer>

</footer>
</body>
</html>