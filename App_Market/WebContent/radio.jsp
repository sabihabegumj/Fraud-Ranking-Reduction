<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="radio_html.css" rel="stylesheet">
<style type="text/css">
body {
	background-image: url("nv.png");
  
}
</style>
<div class="testbox">
  <h1>Application Rating</h1>

  <form action="rank" method="post">
      <hr>
    <div class="accounttype">
    <h2>Star Rating</h2><hr>
    
    <input type="text" name="id" value='<%=request.getAttribute("id")%>' hidden>
    <input type="text" name="email" value='<%=request.getAttribute("email")%>' hidden>
    <input type="text" name="card" value='<%=request.getAttribute("card")%>' hidden>
      <input type="radio" value="2" id="radioOne" name="account" checked/>
      <label for="radioOne" class="radio" chec>one</label>
      <input type="radio" value="4" id="radioTwo" name="account" />
      <label for="radioTwo" class="radio">Two</label>
      <input type="radio" value="6" id="radioThree" name="account" />
      <label for="radioThree" class="radio">Three</label>
      <input type="radio" value="8" id="radioFour" name="account" />
      <label for="radioFour" class="radio">Four</label>
      <input type="radio" value="10" id="radioFive" name="account" />
      <label for="radioFive" class="radio">Five</label>
    </div>
  <hr>
  <h2> Write Your Review Here...</h2><hr>
  <label id="icon" for="name"><i class="icon-envelope "></i></label>
  <input type="text" name="name" id="name" placeholder="Comments" required/>
  
   <p> <a href="#"></a>.</p>
   <a href="#" class="button">  <input type="submit" value="Done"  /></a>
  </form>
</div>