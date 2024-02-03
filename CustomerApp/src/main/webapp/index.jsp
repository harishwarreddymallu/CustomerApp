<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
 <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/index.css"></c:url>"></head>
<body background="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeBWh-N29jJyAs7J-Za5LvkJr2ZSB9VCK1Ig&s">
   <header style="margin-top:-1%;">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtT48Xru65tY6-EGjuHU_IvILXsfphYzpfzQ&s" width="50px" height="50px" style="padding-left:5px;padding-top:5px">
        <h1 style="margin-top:-5%;margin-left:23%">
   	    <span style="color:red"id="first">C</span>
        <span style="color:blue">U</span>
        <span style="color:#055E68">S</span>
        <span style="color:#FF0060">T</span>
        <span style="color:green">O</span>
        <span style="color:purple"id="first">M</span>
        <span style="color:#3E065F">E</span>
        <span style="color:#DB005B">R</span>
        <span style="color:brown"> </span>&nbsp;&nbsp;
        <span style="color:#FF2171">A</span>
        <span style="color:purple">P</span>
        <span style="color:#2A1A5E">P</span>
        <span style="color:#950101">L</span>
        <span style="color:blue">I</span>
        <span style="color:#012C0B"id="first">C</span>
        <span style="color:brown">A</span> 
        <span style="color:#FF0060">T</span>
        <span style="color:green">I</span>
        <span style="color:purple"id="first">O</span>
        <span style="color:red"id="first">N</span>
        </h1>
       
     </header>
		 
		 
		 <br><br><br>
       <div class="form-container">
       
		
			<h3 align="center">SIGN IN</h3>
			<img src="https://cdn-icons-png.flaticon.com/128/4449/4449949.png" width="50px" height="50px" style="padding-left:42%;">
			<br><br><h5 align="center" style="margin-top:-15px;color:red;">${responseMessage}</h5><br>
        <form action="getHomePage" method="post">
			
		    
            <input type="email" name="username" placeholder="User Name" required>

            <input type="password" name="password" placeholder="Password"  required>

            
            <input type="submit" value="Submit">
        </form>
        <br>
         
    </div>
    <footer style="margin-top:2%;position: fixed; width:100%;"></footer>
   
</body>
</html>