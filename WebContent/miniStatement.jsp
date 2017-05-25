<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%-- <%@ taglib uri="http://paginationtag.miin.com" prefix="pagination-tag"%>  --%>
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
    
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
  
	<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>
    
  </head>

  <body>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
	<%
		String spageid=request.getParameter("page");  
		int pageid=Integer.parseInt("3");  
		int total=5;  
		if(pageid==1){}  
		else{  
	    	pageid=pageid-1;  
	    	pageid=pageid*total+1;  
		} 
	%>
    <div class="container">
		<h2 class="">Mini Statement</h2>
		<table class ="table">
  			<thead class="thead-inverse">
				<tr>
					<!-- <th>#</th> -->
					<th>Transaction Date</th>
					<th>Amount</th>
					<th>Transaction Type</th>
					<!-- <th>Balance</th> -->
				</tr>
			</thead>
	 		<c:forEach items= "${requestScope.miniList}" var="trans">	 
			<tbody>	
				<tr>
					<td><c:out value='${trans.transactionDate}'></c:out></td>
					<td><c:out value='${trans.amount}'></c:out></td>
					<td><c:out value='${trans.type}'></c:out></td>					
				</tr>
			</tbody>		
	 		</c:forEach> 
		</table>
		<nav aria-label="">
		  <ul class="pagination">
		    <li>
		      <a href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
<!-- 		    <li class="active">
		      <span>1 <span class="sr-only">(current)</span></span>
		    </li> -->
		    <li><a href="miniStatement.jsp?page=1">1</a></li>
		    <li><a href="miniStatement.jsp?page=2">2</a></li>
		    <li><a href="miniStatement.jsp?page=3">3</a></li>
		    <li>
		      <a href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
	  	  </ul>
		</nav>
    </div>
    <%-- <pagination-tag:pager start="<%=start%>" range="<%=range%>" results="<%=results%>"/> --%>
  </body>
</html>