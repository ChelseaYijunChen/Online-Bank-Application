<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd ">
<html lang="en">
  <head>
    <!-- <meta charset="utf-8"> -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->	
	<script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
    <link rel="icon" href="../../favicon.ico">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
   
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
  </head>
<body>
<!-- 	<form action="LoginServlet" method="post" id="form">
		UserName: <input id="uname" type="text" name="uname"><br>
		Password: <input id="pword" type="text" name="pword"><br>
		<input type="submit" value="submit">
	</form> -->
	<div class="container">

      <div class="form-signin">
        <h4 class="form-signin-heading">Username and password does not match</h4>
        <a href="index.jsp">Try again</a>
        <!-- <button class="btn btn-lg btn-primary btn-block" >Try again</button> -->
      </div>
     </div>

</body>
<SCRIPT LANGUAGE="javascript"> 
	{  
	var url = window.location.href;
	window.history.go(-window.history.length);
	window.location.href = url;
	}
</SCRIPT> 
</html>