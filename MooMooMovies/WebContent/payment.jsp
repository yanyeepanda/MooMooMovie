<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Payment</title>
</head>
<body>
	<h1>Please fill in your payment information</h1>
	<form action='/MooMooMovies/ticket' method="post">
	<input type="hidden" name="command" value="Payment">
		Card Number:<input type="text" name="cardNumber">
		<br>
		Account Name:<input type="text" name="accountName">
		<br>
		Expiry Date:<input type="text" name="expiryDate">
		<br>
		Security Pin:<input type="text" name="securityPin">
		<br>
		<input type="submit" value="Submit">
	</form>

</body>
</html>