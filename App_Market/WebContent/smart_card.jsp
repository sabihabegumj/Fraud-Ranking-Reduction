<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>Aadhar Validation</title>

    <link rel="stylesheet" href="css/style3.css" media="screen" type="text/css" />
<style type="text/css">
body {
	background-image: url("pic4.jpg");

}
</style>



 


    <meta charset="utf-8">

    <title>Aadhar Card</title>

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,700">

    <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
 <![endif]-->
 

  </head>

  <body>

    <div class="container">

      <div id="login">

        <form action="smart_card" method="get">

          <fieldset class="clearfix">

            <p><span class="fontawesome-user"></span><input type="text" value='<%=(String)request.getAttribute("id")%>' name="id" onBlur="if(this.value == '') this.value = 'Username'" onFocus="if(this.value == 'Username') this.value = ''" hidden></p> <!-- JS because of IE support; better: placeholder="Username" -->
            
             <p><span class="fontawesome-user"></span><input type="text" value='<%=(String)request.getAttribute("email")%>' name="email" onBlur="if(this.value == '') this.value = 'Username'" onFocus="if(this.value == 'Username') this.value = ''" hidden></p>
            <p><span class="fontawesome-lock"></span><input type="text" name="card"  placeholder="Enter AADHAAR card no"  onBlur="if(this.value == '') this.value = 'Password'" onFocus="if(this.value == 'Password') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Password" -->
            <p><input type="submit" value="Validate"></p>

          </fieldset>

        </form>

    

      </div> <!-- end login -->

    </div>

  </body>
</html>

</body>

</html>