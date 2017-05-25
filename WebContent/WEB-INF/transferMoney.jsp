<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="TransferMoneyServlet" method="post">
		Account Number: <input type="text" name="accNum">
		Enter Amount: <input type="text" name="amount">
		<input type="submit" value="submit transfer">
	</form>
</body>
</html>