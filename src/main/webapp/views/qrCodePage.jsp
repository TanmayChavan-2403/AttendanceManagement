<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="display: flex; justify-content: center; align-items: center">
		<img alt="Qr Code" src=${url} />
	</div>
	<form action="/faculty" method="POST">
		<input type="text" name="endSession" value="yes" style="visibility: hidden" />
		<input type="text" name="username" value="" style="visibility: hidden" />
		<input type="text" name="password" value="" style="visibility: hidden" />
		<button type="submit">
			End Session
		</button>	
	</form>
</body>
</html>