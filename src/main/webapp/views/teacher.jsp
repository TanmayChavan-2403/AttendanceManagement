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
</head>
<body>
	<div id="mainContainer">
		<div id="innerWrapper">
			<div id="heading">
			
				<% if (session.getAttribute("username").equals("Aarti")) { %>
				    <p>You are logged in</p>
				<% } else { %>
					<h1> Faculty Information </h1>
				<% } %>
				
			</div>	
			<div id="content">
				<div id="left-section">
                    <div id="profile-section">
						<img src=${ profile } />
                    </div>
				</div>
				<div id="right-section">
					<div >
						<% String url = "/dynamicQR"; %>
						
						<form action=<%= url %> id="rs-content-wrapper">
							<div id="row">
								<div id="label">
									<strong> <h3> Faculty Name:  </h3> </strong>
								</div>
								<div id="value">
									<div id="value-content">
										<h3> ${name} </h3>
									</div>
								</div>
							</div>
					
							<div id="row">
								<div id="label">
									<strong> <h3> Lecture:  </h3> </strong>
								</div>
								<div id="value">
									<div id="value-content">
										<input id="lecture_inpField" type="text" name="lectureId" value=${ lecture } />
									</div>
								</div>
							</div>
							
							<div id="row">
								<div id="label">
									<strong> <h3> Total Conducted:  </h3> </strong>
								</div>
								<div id="value">
									<div id="value-content">
										<h3> ${conducted} </h3>
									</div>
								</div>
							</div>
							
							<div id="row">
								<div id="label">
									<strong> <h3> Batch:  </h3> </strong>
								</div>
								<div id="value">
									<div id="value-content">
										<h3> ${batch} </h3>
									</div>
								</div>
							</div>
							
							<div id="row">
								<div id="label">
									<strong> <h3> Branch:  </h3> </strong>
								</div>
								<div id="value">
									<div id="value-content">
										<h3> ${branch} </h3>
									</div>
								</div>
							</div>
							
							<div id="row">
								<div id="value">
									<div id="value-content">
										<button type='submit'>
											Start attendance session
										</button>
									</div>
								</div>
							</div>
						</form>
						
						<form action="/logout" method="GET">
							<button type='submit'>
								Logout
							</button>
						</form>

					</div>					
				</div>						
			</div>					
		</div>
	</div>
	
</body>
</html>