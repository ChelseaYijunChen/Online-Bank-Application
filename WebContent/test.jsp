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
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

    <div class="container">
      <!-- <form > -->
      <form action="NewAccountServlet" method="post" id="form">
        <h2 class="">New a Account</h2>
        <div class="form-group row">
          <label for="" class="col-sm-3 col-form-label">Account Number</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" id="accNum" name="accNum" value="Don't need input. System will generate" disabled>
          </div>
        </div>
        <div class="form-group row">
          <label for="" class="col-sm-3 col-form-label">User Name</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" id="userName" name="userName" placeholder="Account Name">
          </div>
        </div>
        <div class="form-group row">
          <label for="" class="col-sm-3 col-form-label">Gender</label>
          <div class="col-sm-9">
            <label class="form-check-label col-sm-5">
              <input class="form-check-input" type="radio" name="gender" value="male" > Male
            </label>
            <label class="form-check-label col-sm-4">
  				<input class="form-check-input" type="radio" name="gender" value="female"> Female
            </label>
          </div>
        </div>
        <div class="form-group row">
          <label for="" class="col-sm-3 col-form-label">Email</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" id="email" name="email" placeholder="Email">
          </div>
        </div>
        <div class="form-group row">
							<label for="" class="col-sm-3 col-form-label">From</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="from" name="from" placeholder="CHICAGO">
							</div>
						</div>
						<div class="form-group row">
							<label for="" class="col-sm-3 col-form-label">To</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="to" name="to" placeholder="NYC">
							</div>
						</div>
        <div class="form-group row">
          <label for="" class="col-sm-3 col-form-label">Password</label>
          <div class="col-sm-9">
            <input type="password" class="form-control" id="password1" name="password1" placeholder="Password">
          </div>
        </div>
        <div class="form-group row">
          <label for="" class="col-sm-3 col-form-label">Confirm Password</label>
          <div class="col-sm-9">
            <input type="password" class="form-control" id="password2" name="password2" placeholder="Confirm Password">
          </div>
        </div>
        <div class="form-group row">
          <label for="" class="col-sm-3 col-form-label">Phone Number</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" id="phoneNum" name="phoneNum" placeholder="Phone Number">
          </div>
        </div>
        <div class="form-group row">
          <label for="" class="col-sm-3 col-form-label">Balance</label>
          <div class="col-sm-9">
            <input type="text" class="form-control" id="balance" name="balance" placeholder="Balance">
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
					minlength:3,
					maxlength: 7,
				},
			
				accName:{
					required: true,
					minlength:3,
					maxlength: 16,
				},
				
				email:{
					required: true,
					email: true,
				},
				from:{
					required: true,
					
				},
				to:{
					required: true,
					notEqual:"#from",
				},
			
				password1:{
					required: true,
					minlength:3,
					maxlength: 7,
				},
				password2:{
					required: true,
					/* equalTo: "#password1", */
					notEqual:"#password1",
					/* minlength:3,
					maxlength: 7, */
				},
				phoneNum:{
					required: true,
					number: true,
					exactlength: 10, 
				},
				balance:{
					required: true,
					min: 500,
				},
			},
			
			messages:{			
				password2: {
			        /* equalTo: "please input same password" */
			    },
			    /* email:{
			    	email:"Please provide a validate the email address"
			    }, */
			    balance:{
			    	min:"The mininum open amount must more than 500"
			    }
			    
			},
			submitHandler: function(form) {
			      form.submit();
			    }
		})
	})
	jQuery.validator.addMethod("notEqual", function(value, element, param) {
 		return this.optional(element) || value != $(param).val();
	}, $.validator.format("This has to be different..."));
	jQuery.validator.addMethod("exactlength", function(value, element, param) {
	 	return this.optional(element) || value.length == param;
	}, $.validator.format("Please enter {0} digit number.")); 
	/* jQuery.validator.addMethod("notEqual", function(value, element, param) {
		  return this.optional(element) || value != param;
	}, $.validator.format("Please specify a different (non-default) value"));  */
	
	</script>
</html>