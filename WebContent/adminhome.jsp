<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!--     <META Http-Equiv="Cache-Control" Content="no-cache">
	<META Http-Equiv="Pragma" Content="no-cache">
	<META Http-Equiv="Expires" Content="0"> -->
    <link rel="icon" href="../../favicon.ico">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/dashboard.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
	  <script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<%-- 	<% 	response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
	   response.addHeader("Pragma", "no-cache"); 
	   response.addDateHeader ("Expires", 0); %> --%>
  </head>
  <body>
  <%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	    response.setDateHeader("Expires", 0); // Proxies.
	    
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
          <a class="navbar-brand" href="#">Admin Home</a>
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
            <li><a href="test.jsp" target="iframe_a">Open a new account</a></li>
            <!-- <li><a href="viewAllAccount.jsp" target="iframe_a">view all accounts</a></li> -->
            <li><a href="UserServlet" target="iframe_a">view all accounts</a></li>
            <li><a href="searchAccount.jsp" target="iframe_a">Search account</a></li>
            <li><a href="withdraw.jsp" target="iframe_a">Withdraw money</a></li>
            <li><a href="deposit.jsp" target="iframe_a">Deposit money</a></li>
          </ul>
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <!-- <h1 class="page-header">Welcome to Adminhome</h1> -->
          <iframe height="800px" width="100%" src="adminWelcome.jsp" name="iframe_a" style="border:none;">Welcome to Adminhome</iframe>
        </div>
      </div>
    </div>


  </body>
<!--  <SCRIPT LANGUAGE="javascript"> 
	{  
	var url = window.location.href;
	window.history.go(-window.history.length);
	window.location.href = url;
	}
</SCRIPT>  -->
</html>
<%-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" type="text/css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
<!-- 	<div class="wrap">
	    <div class="floatleft">
	    	
	    </div>
	    <div class="floatright">
	    fdsfdvgfsds
	    </div>
	    <div style="clear: both;"></div>
	</div> -->
	
	<div style="width: 100%;">
	   <div style="float:left; width: 20%">
	   		<a href="#" id="open">Open a new account</a><br>
			<a href="newAccount.jsp" target="iframe_a">view all accounts</a><br>
			<a href='search.jsp'>Search account</a><br>
			<a href="ShowAll">Withdraw money</a><br>
			<a href="ShowAll">Deposit money</a><br>
	   </div>
	   <div style="float:left; width:80%" id="view" >
	   
	   		<iframe height="800px" width="100%" src="#" name="iframe_a" style="border:none;"></iframe>
	   		<jsp:include page="newAccount.jsp"/>
	   </div>
	</div>
	<div style="clear:both"></div>	
	
	<!-- ========================= -->
<!-- 	<script>
	$( "#open" ).load( "newAccount.jsp " );
	</script> -->
	
</body>
</html> --%>