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
				<h1> Attendance Management System </h1>
			</div>	
			<div id="content">
				<div id="left-section">
                    <div id="profile-section">
						<img id="profile" src="">
                    </div>
				</div>
				<div id="right-section">
					<div>
						<% String redirectURL = "/submitAttendance?lecture=" + session.getAttribute("id"); %>	
						<form action= <%= redirectURL %> method="POST" id="rs-content-wrapper">
							<div id="row">
								<div id="label">
									<strong> <h3> Name:  </h3> </strong>
								</div>
								<div id="value">
									<div id="value-content">
										<h3 id="name"></h3>
									</div>
								</div>
							</div>
							
							<div id="row">
								<div id="label">
									<strong> <h3> Uid:  </h3> </strong>
								</div>
								<div id="value">
									<div id="value-content">
										<input id="uid_inpField" type="text" name="uid" placeholder="UID" />
										<button type="submit">
											Get
										</button>
										
									</div>
								</div>
							</div>
							
							<div id="row">
								<div id="label">
									<strong> <h3> Lecture:  </h3> </strong>
								</div>
								<div id="value">
									<div id="value-content">
										<h3 id="lecture">
											${id}
										</h3>
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
	
	
	<script
	  src="https://code.jquery.com/jquery-3.7.0.min.js"
	  integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
	  crossorigin="anonymous">
	</script>
	
	<script>
		$("#rs-content-wrapper").on('submit', function(e){
			e.preventDefault();
			
			let f = $(this).serialize();
			console.log(f);
			
			let name = document.getElementById("name");
			let totConducted = document.getElementById("totConducted");
			let totAttended = document.getElementById("totAttended");
			let image = document.getElementById("profile");
						
			$.ajax({
				url: "/getStudentData",
				data: f,
				type: "POST",
				success: function(data, textStatus, jqXHR){
					name.innerText = data.name;
					image.src = data.profile;
					console.log(data);
					console.log("Successfully fetched");
				},
				error: function(jqXHR, textStatus, errorThrown){
					console.log("Ajax failed");
				}
			})
		})
	</script>
	
</body>
</html>