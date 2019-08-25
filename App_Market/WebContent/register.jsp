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
	background-image: url("pic4.jpg");
    }
</style>
</head>
<body>
<header>
<h2>Launch Your Application In The Application Market</h2>
</header>
<div align="center">
<form action="register_done.jsp" method="post" enctype="multipart/form-data">
Name<br><input type="text" name="name" required title="Must Enter Your name" placeholder="Enter your name"><br>
Your DOB<br><input type="date" name="dob" title="Must Enter Your DOB" placeholder="Date Of birth" required><br>
Product Name<br><input type="text" name="product" title="must Enter Rpoduct Name" placeholder="Product name" required><br>
Product Cost<br><input type="number" name="cost" title="must Enter Producy Cost" placeholder="Cost" reqiured><br>
 <input type="hidden" name="priority" placeholder="Enter Priority" min="0" max="10" value="1" hidden>
Product Icon<br><input type="file" name="img" required accept="image/*"><br>
Email Id<br><input type="email" name="mail" required placeholder="Email Id"><br>
Password<br><input type="password" name="password" id="pass1"  placeholder="Password"required><br>
Confirm Password<br><input type="password" name="password"  id= "pass2" placeholder="Re-type the same Password" required><br>
<br><input type="submit" value = submit onclick="myFunction()">

</form>
</div>
<script>
    function myFunction() {
        var pass1 = document.getElementById("pass1").value;
        var pass2 = document.getElementById("pass2").value;
        if (pass1 != pass2) {
            alert("Passwords Do not match");
            document.getElementById("pass1").style.borderColor = "#E34234";
            document.getElementById("pass2").style.borderColor = "#E34234";
        }
        else {
            alert("Passwords Match");
        }
    }
</script>

<footer>

</footer>
</body>
</html>