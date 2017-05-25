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
   
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

  </head>
<body>
<!-- 	<form action="LoginServlet" method="post" id="form">
		UserName: <input id="uname" type="text" name="uname"><br>
		Password: <input id="pword" type="text" name="pword"><br>
		<input type="submit" value="submit">
	</form> -->
	    <%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	    response.setDateHeader("Expires", 0); // Proxies.
	%>
	<div class="container">

      <form action="LoginServlet" method="post" id="form" class="form-signin">
        <h2 class="form-signin-heading">Bank Of Universe</h2>
        <label for="inputEmail" class="sr-only">Email</label>
        <input type="text" id="userName" class="form-control" placeholder="Email" name="email">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="password" class="form-control" placeholder="Password" name="password">
<!--         <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div> -->
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> 
</body>

<script type="text/javascript">
$(function(){
	$("#form").validate({
		rules :{
			email:{
				required: true,
				email:true,
			},
		
			password:{
				required: true,
				minlength:3,
				maxlength: 7,
			},
		},
		
		messages:{			
			/*   uname: {
			        required: "Please provide a username",
			        minlength: "Your username length must between 3 and 7 characters",
			        maxlength:"fffff"
			      }, */
			      
			 /* password: {
			        required: "Please provide a password",
			        minlength: "Your password length must between 3 and 7 characters"
			      },  */
		},
		submitHandler: function(form) {
		      form.submit();
		    }
	})
})

</script>
</html>