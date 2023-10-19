<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Admin Login</title>
    <style>
              
      body{
        background-image: url(images/bgimage.jpg);
        background-repeat: no-repeat;
        background-position: center;
        background-size: cover;
      }
      input[type=text], input[type=password] {
        width: 75%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
      }
      button {
        background-color: blue;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 75%;
        border:1px solid blue;
      }
      button:disabled{
      background-color: transparent;
      color:black;
      }
      .box{position: relative;
          margin: 20px auto;
          text-align: center;
          background-color: rgb(255, 255, 255);
          height: 550px;
          width: 400px;
          box-shadow: 0 0 10px rgba(0,0,0,0.3);
      }

      #myVideo {
        position:fixed;
        right:0;
        bottom:0;
        min-width: 100%; 
        min-height: 100%;
      }
      img{
        width: 20%;
        height: 20%;
      }
      .error{
      	color:red;
      }
     </style>
     <script src="script.js"></script>
  </head>
    <body>
        <div class="box">
          <form method="post" action="LoginServlet" >
            <br>
            <img src="images/lock.png" alt="">
            <br>
            <h2>Welcome Back</h2>
            <p class="error" id="error"></p>
             <c:forEach var = "error" items = "${error}">
             
            <p class="error">${error}</p> 
            
            </c:forEach>           
            <label for="uname"><b>Email*</b></label><br><br>
            <input type="text" placeholder="Enter Email" name="userid" id="email" oninput="check()"><br><br>
        
            <label for="psw"><b>Password*</b></label><br><br>
            <input type="password" placeholder="Enter Password" name="passid" id="password" oninput="check()">
            <p><a href="/">Forget password?</a></p>

            <button type="submit" id="submit">Login</button><br>
        </form>
        </div>
    </body>
</html>