
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/adminstyle.css">
    <link rel="stylesheet" href="styles/addAdmin.css">
    <title>Create Admin</title>

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
        <a href="messages.jsp" class="tab"><i class="fa-solid fa-calendar-days"></i> Messages</a>
        <a href="update.jsp" class="tab"><i class="fa-solid fa-list-check"></i>Account</a>
        <a href="AdminHandler?action=addpage" class="tab active"><i class="fa-solid fa-list-check"></i>Add Admin</a>
    </div>
    <div class="dashboard">
        <div class="header">
            <div class="menu-btn">
                <i class="fa-solid fa-bars" onclick="showNavi()"></i>
                <h1>Insert New Admin</h1>
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
         
         <form action="AdminHandler?action=add" method="post" class="add-admin-form">
            <h1>New Admin Creation</h1>
            <p class="error"></p>

            <input type="hidden" name="id" value="0">

            <p>Email : </p>
            <input type="email" name="email" class="input-field">

            <p>Name : </p>
            <input type="text" name="name" class="input-field">

            <p>Password (Default is admin) : </p>
            <input type="text" name="pwd" value="admin" class="input-field">

            <input type="hidden" value="adminDefault.jpg" name="img">
            
            <input type="hidden" value="admin" name="pass">

            <input type="submit" value="Create Admin" class="submit-btn">

         </form>
         
           <table class="admin-table">
         	<tr><td colspan="2">Available Admins</td></tr>
         	<tr>
         		<th>Name</th>
         		<th>Email</th>
         	</tr>
         	<c:forEach var = "ad" items = "${admins}">
                	<tr>
                    	<td>${ad.name}</td>
                    	<td> ${ad.email}</td>
                    </tr>
             </c:forEach> 
         </table>
    </div>
</body>
</html>