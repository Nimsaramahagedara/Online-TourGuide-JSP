<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/adminstyle.css">
    <title>Admin</title>

    <script src="https://kit.fontawesome.com/24b485c31a.js" crossorigin="anonymous"></script>
    <script src="js/adminScript.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="navigation" style="margin: 0px;">
        <div class="logo">
            <img src="images/logowithSlogan.png" alt="">
        </div>
        
        <a href="AdminHandler?action=dashboard" class="tab"><i class="fa-solid fa-gauge"></i> Dashboard</a>
        <a href="AdminHandler?action=customers" class="tab"><i class="fa-solid fa-users"></i> Customers</a>
        <a href="AdminHandler?action=guiders" class="tab"><i class="fa-solid fa-user-secret"></i> Guiders</a>
        <a href="listings.html" class="tab"><i class="fa-solid fa-bars-progress"></i> Tour Listings</a>
        <a href="messages.jsp" class="tab active"><i class="fa-solid fa-calendar-days"></i> Messages</a>
        <a href="update.jsp" class="tab"><i class="fa-solid fa-list-check"></i>Account</a>
        <a href="AdminHandler?action=addpage" class="tab"><i class="fa-solid fa-list-check"></i>Add Admin</a>
    </div>
    <div class="dashboard">
        <div class="header">
            <div class="menu-btn">
                <i class="fa-solid fa-bars" onclick="showNavi()"></i>
                <h1>Messages</h1>
            </div>

            <div class="user">

             	<c:forEach var = "cus" items = "${cusData}">
                	<img src="images/adminDp/${cus.image}" alt="">
                	<div>
                    	<h3>${cus.name}</h3>
                    	<p> ${cus.email}</p>
                    </div>
                </c:forEach>
                <i class="fa-solid fa-chevron-down" onclick="showLogOut()" id="logout-btn"></i>
                <div class="logout" style="display: none;"><a href="LogoutServlet">LogOut</a></div>
            </div>
                
         </div>
        <div class="detail-container">
            <div class="main">
                <div class="text">
                    <h3>Messages</h3>
                    <button>See All</button>
                </div>
                <table class="table">
				  <thead>
				    <tr>
				     	<th scope="col">User Name</th>
				     	<th scope="col">Email</th>	
				     	<th scope="col">Phone</th>	      
				     	<th scope="col">Message</th>
				     	<th scope="col">Action</th>
				    </tr>
				  </thead>
				  <tbody>
				
					<c:forEach var = "recT" items = "${users}">
						<tr>
				      		<td>${recT.name}</td>
				      		<td>${recT.email}</td>
				      		<td>${recT.phone}</td>
				      		<td>${recT.address}</td>
				      		<th scope="row"><a href="AdminHandler?action=delete&id=${recT.id}"> Delete </a></th>
				      		
				    	</tr>
	                
					</c:forEach>

				  </tbody>
				</table>

            </div>
        </div>
    </div>
</body>
</html>