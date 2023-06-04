<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@100;200;300;400;500;600;700&family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
<style>
	#login-cont-wrapper{
		width: 30%;
		height: 85%;
		border: 1px solid black;
		background-color: rgba(255,255,255,0.95);
		border-radius: 15px;		
	}
	
	#heading{
		width: 100%;
		height: 10%;
		text-align: center;
	}
	
	#input-fields{
		width: 100%;
		height: 75%;
		border: 1px solid black;
	}
	
	#submitBtn{
		width: 100%;
		height: 15%;
		border: 1px solid black;		
	}
</style>
</head>
<body>
	<div id="mainContainer">
		<div id="innerWrapper">
			
			<% if (session.getAttribute("error") != null && !session.getAttribute("error").equals("NULL")) { %>
			    <p> <%= session.getAttribute("error") %> </p>
			<% } %>
				
			<div id="heading">
				<h1> Attendance Management System </h1>
			</div>	
			<div id="content" style="background-color: transparent">
				<div id="login-cont-wrapper">
					<div id="heading"> Login </div>
					<form action="/faculty" method="POST">
						<div id="input-fields">
							<input type="text" name="endSession" value="no" style="visibility: hidden" />
							<input type="text" name="username" placeholder = "Enter username"/>
							<input type="text" name="password" placeholder = "Enter password"/>
						</div>
						<button id="submitBtn"> SUBMIT </button>							
					</form>
				</div>				
			</div>					
		</div>
	</div>
	
</body>
</html>