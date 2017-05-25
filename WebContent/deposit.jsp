<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <title>Signin Template for Bootstrap</title>

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
      <!-- <form > -->
      <form action="Deposit" method="post" id="form">
        <h2 class="">Deposit Money</h2>
        <div class="form-group row">
          <label for="" class="col-sm-3 col-form-label">Enter Account Number</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" id="accNum" name="accNum" placeholder="Enter Account Number">
          </div>
        </div>
        <div class="form-group row">
          <label for="" class="col-sm-3 col-form-label">Enter Amount</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" id="amount" name="amount" placeholder="Enter Amount">
          </div>
        </div>      
        <div class="form-group row">
          <div class="offset-sm-3 col-sm-9">
            <button type="submit" class="btn btn-primary">Submit</button>
          </div>
        </div>
      </form>
    </div>
  </body>
  <script type="text/javascript">
	$(function(){
		$("#form").validate({
			rules :{
				accNum:{
					required: true,
					number:true,
				},	
				amount:{
					required: true,
					number:true,
					min:0,
				}
			},
			submitHandler: function(form) {
			      form.submit();
			    }
		})
	})
  </script>
</html>