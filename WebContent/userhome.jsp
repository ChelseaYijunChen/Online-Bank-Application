<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/dashboard.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>


  </head>
  <body>
  	<% 	response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
	   response.addHeader("Pragma", "no-cache"); 
	   response.addDateHeader ("Expires", 0); 
	   
	   	String email=(String)request.getSession().getAttribute("email");
	    
	    if(email==null){
	    	response.sendRedirect("index.jsp");
	    }
	   %>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Customer Home</a>
        </div>
		 <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="LogoutServlet">Log Out</a></li>
          </ul>
        </div> 
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <!-- <li class="active"><a href="newAccount.jsp" target="iframe_a">Home <span class="sr-only">(current)</span></a></li> -->
            <!-- <li><a href="miniStatement.jsp" target="iframe_a">Mini Statement</a></li> -->
            <li><a href="MiniStatement" target="iframe_a">Mini Statement</a></li>
            <li><a href="transfer.jsp" target="iframe_a">Transfer Money</a></li>
          </ul>
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <iframe height="800px" width="100%" src="userWelcome.jsp" name="iframe_a" style="border:none;">Welcome to Userhome</iframe>
        </div>
      </div>
    </div>


  </body>
<!--   <SCRIPT LANGUAGE="javascript"> 
	{  
	var url = window.location.href;
	window.history.go(-window.history.length);
	window.location.href = url;
	}
</SCRIPT> --> 
</html>
