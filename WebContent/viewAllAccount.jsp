<%-- 	<table style="width:80%">
		<tr>
			<th>Account Number</th>
			<th>User Name</th> 
			<th>Balance</th>
		</tr>	    
		<c:forEach items= "${requestScope.userList}" var="ump">		
			<tr>
				<td>
					<c:out value='${ump.accNum}'></c:out>
					<c:out value='${ump.accName}'></c:out>
					<c:out value='${ump.balance}'></c:out>
				</td>
			</tr>		
		</c:forEach>
	</table> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
  </head>

  <body>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

    <div class="container">
		<h2 class="">View All Account</h2>
		<table class="table">
			<thead class="thead-inverse">
				<tr>
					<th>Account Number</th>
					<th>User Name</th>
					<th>Balance</th>
				</tr>
			</thead>
			<c:forEach items= "${requestScope.allList}" var="user">		
				<tboday>	
					<tr>
						<td><c:out value='${user.accNum}'></c:out></td>
						<%-- <td><c:out value='${user.userName}'></c:out></td> --%>
						<td><c:out value='${user.balance}'></c:out></td>					
					</tr>	
				</tboday>	
			</c:forEach>
		</table>
		<nav aria-label="...">
	  <ul class="pagination">
	    <li>
	      <a href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    <li class="active">
	      <span>1 <span class="sr-only">(current)</span></span>
	    </li>
	    <li><a href="#">2</a></li>
	    <li><a href="#">3</a></li>
	    <li><a href="#">4</a></li>
	    <li><a href="#">5</a></li>
	    <li>
	      <a href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
  	</ul>
	</nav>
    </div>
  </body>
</html>