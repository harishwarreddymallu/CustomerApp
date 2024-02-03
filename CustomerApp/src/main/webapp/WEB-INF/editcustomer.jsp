<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>

    <!-- Link to external CSS file using JSTL -->
    <link rel="stylesheet" type="text/css" href="<c:url value='resources/css/index.css'></c:url>">

    <!-- Internal styles for header, form, and other elements -->
    <style>
        header {
            border: 1px solid grey;
            background-color: #10EAF0;
            position: fixed;
            width: 100%;
        }

        footer {
            border: 1px solid grey;
            background-color: #10EAF0;
            text-align: center;
            padding-top: 2%;
            padding-bottom: 3%;
            position: fixed;
            width: 100%;
        }

        form {
            border: 1px grey;
        }

        .form-container {
            max-width: 800px;
            margin: 0 auto;
            background: #FCFFB2;
            padding: 20px;
            margin-top: 4%;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }

        .form-container h3 {
            text-align: center;
            width: 100%; /* Ensures full width for h3 */
        }

        .form-container img {
            display: block; /* Ensures the image is centered */
            margin: 2% auto;
        }

        .form-container input[type="text"],
        .form-container input[type="email"],
        .form-container input[type="password"],
        .form-container input[type="number"] {
            width: 48%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        .form-container input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }

        .form-container input[type="submit"]:hover {
            background-color: #45a049;
        }

        .b {
            margin-top: -6%;
            padding-left: 85%;
        }
    </style>
</head>

<body bgcolor="white">
    <!-- Header section with logo and company name -->
    <header style="margin-top: -1%;">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtT48Xru65tY6-EGjuHU_IvILXsfphYzpfzQ&s"
            width="50px" height="50px" style="padding-left: 5px; padding-top: 5px">
        <h2 style="margin-top: -5%; margin-left: 23%">
            <span style="color:red" id="first">C</span>
            <span style="color:blue">U</span>
            <span style="color:#055E68">S</span>
            <span style="color:#FF0060">T</span>
            <span style="color:green">O</span>
            <span style="color:purple" id="first">M</span>
            <span style="color:#3E065F">E</span>
            <span style="color:#DB005B">R</span>
            <span style="color:brown"> </span>&nbsp;&nbsp;
            <span style="color:#FF2171">A</span>
            <span style="color:purple">P</span>
            <span style="color:#2A1A5E">P</span>
            <span style="color:#950101">L</span>
            <span style="color:blue">I</span>
            <span style="color:#012C0B" id="first">C</span>
            <span style="color:brown">A</span>
            <span style="color:#FF0060">T</span>
            <span style="color:green">I</span>
            <span style="color:purple" id="first">O</span>
            <span style="color:red" id="first">N</span>
        </h2>
    </header>

    <br>
    <!-- Display success and error messages -->
    <h4 align="center" style="margin-top: -15px; color: green">${responseMessage1}</h4>
    <h4 align="center" style="margin-top: -15px; color: red">${responseMessage}</h4>

    <!-- Form container for editing customer details -->
    <div class="form-container" style="margin-top: 4%;">
        <h3 align="center">Edit Customer Details</h3>
        <img src="https://cdn-icons-png.flaticon.com/128/4449/4449949.png" width="50px" height="50px">

        <!-- Form for editing customer details -->
        <form action="${pageContext.request.contextPath}/updateMember">
            <input type="text" name="firstname" placeholder="First name" required value="${firstname}">
            <input type="text" name="lastname" placeholder="Last name" required value="${lastname}">
            <input type="text" name="street" placeholder="Street" required value="${street}">
            <input type="text" name="address" placeholder="Address" required value="${address}">
            <input type="text" name="city" placeholder="City" required value="${city}">
            <input type="text" name="state" placeholder="State" required value="${state}">
            <input type="email" name="email" placeholder="Email" required value="${email}">
            <input type="text" name="phone" placeholder="Phone" required value="${phone}">
            <input type="submit" value="Edit">
        </form>
    </div>

    <!-- Footer section -->
    <footer style="margin-top:%"></footer>

</body>
</html>
