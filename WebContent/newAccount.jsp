<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="NewAccountServlet" method="post" id="form">
		<table>
			<tr>
				<td>Account Number:</td>
				<td><input id="accNum" type="text" name="accNum"></td>
			</tr>			
			<tr>
				<td>User Name:</td>
				<td><input id="userName" type="text" name="userName"></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" name="gender" value="male" > Male
  					<input type="radio" name="gender" value="female"> Female</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input id="email" type="text" name="email"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input id="password1" type="password" name="password1"></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input id="password2" type="password" name="password2"></td>
			</tr>
			<tr>
				<td>Mobile Number:</td>
				<td><input id="phoneNum" type="text" name="phoneNum"></td>
			</tr>
			<tr>
				<td>Opening balance:</td>
				<td><input id="balance" type="text" name="balance"></td>
			</tr>		
		</table>
		<p/>
            <input type="submit" value="Open Account">
	</form>
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
		
			userName:{
				required: true,
				minlength:3,
				maxlength: 16,
			},
			
			email:{
				required: true,
				email: true,
			},
		
			password1:{
				required: true,
				minlength:3,
				maxlength:10,
			},
			password2:{
				required: true,
				notEqual: "#password1",
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
		        equalTo: "please input same password"
		      },
		    /* phoneNum:{
		    	exactlength:"Please enter 10 digit number."
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

jQuery.validator.addMethod("exactlength", function(value, element, param) {
 return this.optional(element) || value.length == param;
}, $.validator.format("Please enter {0} digit number.")); 
jQuery.validator.addMethod("notEqual", function(value, element, param) {
	  return this.optional(element) || value != param;
	}, "Please specify a different (non-default) value");

</script>
</html>