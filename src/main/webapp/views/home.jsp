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
				<h1 id="heading-tagh1"> Attendance Management System </h1>
				<% if (session.getAttribute("attended").equals("true")){ %>
					<h4 style="color: green"> Attendance updated successfully! </h4>
				<% } %>

				<% if (request.getAttribute("warning") != null && !request.getAttribute("warning").equals("null")) { %>
					<h4 style="color: red"> <%= request.getAttribute("warning") %> </h4>
				<%  } %>
			</div>	
			<div id="content">
				<div id="left-section">
                    <div id="profile-section">
						<img id="profile" src=${StudentProfile}>
                    </div>
				</div>
				<div id="right-section">
					<div class="rs-content-wrapper">

						<div >
							<% String url = "/getStudentData?reqType=fetch&lectureId=" + session.getAttribute("lectureId"); %>
							<form id="row" action=<%= url %> method="POST">
								<div id="label">
									<strong> <h3> Uid:  </h3> </strong>
								</div>
								<div id="value">
									<div id="value-content">
										<% if (session.getAttribute("StudentUID").equals("")) { %>
											<input id="uid_inpField" type="text" name="uid" placeholder="UID" />
										<% } else { %>
											<input id="uid_inpField" value=${StudentUID} type="text" name="uid" placeholder="UID" />
										<% } %>
										
										<button type="submit">
											Get
										</button>
									</div>
								</div>
							</form>
						</div>

						<form class="rs-content-wrapper" action="/getStudentData?reqType=submit" method="POST">
							<div id="row">
								<div id="label">
									<strong> <h3> Name:  </h3> </strong>
								</div>
								<div id="value">
									<div id="value-content">
										<h3 id="name">${StudentName}</h3>
									</div>
								</div>
							</div>

							<div id="row">
								<div id="label">
									<strong> <h3> Lecture:  </h3> </strong>
								</div>
								<div id="value">
									<div id="value-content">
										<input type="text" name="uid"  style="display: none" value=${StudentUID} >
										<input type="text" name="lectureId"  style="display: none" value=${lectureId}>
										<% if (session.getAttribute("lectureId").equals("")) { %>
											<h3 id="lecture"></h3>
										<% } else { %>
											<h3 id="lecture"> ${lectureId} </h3>
										<% } %>
										
									</div>
								</div>
							</div>
							
						
							<div id="row">
								<div id="value">
									<div id="value-content">
										<button type="submit">
											Submit Attendance
										</button>
									</div>
								</div>
							</div>

						</form>
						
					</div>					
				</div>						
			</div>					
		</div>
	</div>
	

</body>
</html>