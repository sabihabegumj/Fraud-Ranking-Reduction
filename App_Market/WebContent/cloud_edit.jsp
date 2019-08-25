<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="StyleSheet" href="register.css">

 <link rel="stylesheet" href="css/style21.css">
<style type="text/css">


body {
	background-image: url("edit.jpg");
    }
</style>


</head>
<body>
<header>
<h1><marquee behavior="scroll" direction="right" onmouseover="this.setAttribute('scrollamount', 3, 0);" onmouseout="this.setAttribute('scrollamount', 10, 0);">Update Your Details Here</marquee></h1>

</header>
<div align="center">
<%
String id=(String)request.getAttribute("id");
out.write("<form action='edit_done.jsp?id="+id+"' method='post' enctype='multipart/form-data'>");
%>

Name<br><input type="text" name="name" title="Must Enter Your name" placeholder="Update your name" required><br>
DOB<br><input type="date" name="dob" title="Must Enter Your DOB" placeholder=" update Date Of birth" required ><br>
Product Name<br><input type="text" name="product" title="must Enter Rpoduct Name" placeholder="UPdate Product name" required ><br>
Product Cost<br><input type="number" name="cost" title="must Enter Producy Cost" placeholder="Update cost" required><br>
priority <br><input type="number" name="priority" placeholder="Enter Priority" min="0" max="10" required><br>
Product Icon:<br><input type="file" name="img" accept="image/*"><br>
Email Id<br><input type="email" name="mail" required><br>
Change Password<br><input type="password" name="password" hidden id="pass1" required><br><br>
<br><input type="submit" >


</script>

</form>
</div>

<footer>

</footer>
</body>
</html>