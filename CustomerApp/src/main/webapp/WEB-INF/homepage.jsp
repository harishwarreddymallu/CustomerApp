<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>

    <!-- Add styling for the search box and link to external CSS file -->
    <style>
        .search-box {
            position: relative;
            display: inline-block;
        }

        .search-box input[type="text"] {
            padding-right: 20px; /* Space for the search icon */
        }

        .search-icon {
            position: absolute;
            top: 50%;
            right: 0px;
            transform: translateY(-50%);
            cursor: pointer;
        }
        
        /* Add styling for other elements and classes */
        #in {
            display: inline-block;
            margin: 10px;
        }
        
        #background {
            background-color: #FCFFB2;
        }
    </style>

    <!-- Link to external CSS file -->
    <link rel="stylesheet" type="text/css" href="<c:url value="resources/css/index.css"></c:url>">
</head>

<body bgcolor="white">
    <!-- Header section with company logo and name -->
    <header style="margin-top: -1%;">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtT48Xru65tY6-EGjuHU_IvILXsfphYzpfzQ&s"
            width="50px" height="50px" style="padding-left: 5px; padding-top: 5px">
        <h2 style="margin-top: -5%; margin-left: 23%">
            <!-- Company name with colored letters -->
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
    <div id="background">
        <!-- Form for adding a new customer -->
        <form id="in" action="register">
            <input type="submit" value="Add Customer">
        </form>

        <!-- Form for searching customers by different criteria -->
        <form id="in" action="searchBy">
            <select id="searchByDropdown" name="searchby" required>
                <!-- Options for searching by different criteria -->
                <option value="" disabled selected hidden>Search by</option>
                <option value="firstname">First Name</option>
                <option value="lastname">Last Name</option>
                <option value="address">Address</option>
                <option value="street">Street</option>
                <option value="city">City</option>
                <option value="state">State</option>
                <option value="email">Email</option>
                <option value="phone">Phone</option>
            </select>
            <!-- Search box with search icon -->
            <div class="search-box">
                <input type="text" id="searchInput" placeholder="Enter search value" name="search" required>
                <div class="search-icon"><input type="submit" value="&#128269;"></div>
            </div>
        </form>

        <!-- Form for sorting customers by different criteria -->
        <form id="in">
            <select id="sortDropdown" onchange="sortTable()">
                <!-- Options for sorting by different criteria -->
                <option value="" disabled selected hidden>Sort by</option>
                <option value="firstname">First Name</option>
                <option value="lastname">Last Name</option>
                <option value="address">Address</option>
                <option value="street">Street</option>
                <option value="city">City</option>
                <option value="state">State</option>
                <option value="email">Email</option>
                <option value="phone">Phone</option>
            </select>
        </form>
    </div>

    <!-- Display success and error messages -->
    <h3 style="text-align:center;color:green;">${responseMessagee}</h3>
    <h3 style="text-align:center;color:red;">${responseMessag}</h3>

    <!-- Table for displaying customer details -->
    <table border="" width="100%" style="background-color:#FBE8E7;">
        <tr>
            <!-- Table headers with placeholders for column names -->
            <th>${M1}</th>
            <th>${M2}</th>
            <th>${M3}</th>
            <th>${M4}</th>
            <th>${M5}</th>
            <th>${M6}</th>
            <th>${M7}</th>
            <th>${M8}</th>
        </tr>

        <!-- Loop through the customer list and display details in the table -->
        <c:forEach var="getCustomerr" items="${getCustomerr}">
            <tr>
                <td>${getCustomerr.firstname}</td>
                <td>${getCustomerr.lastname}</td>
                <td>${getCustomerr.address}</td>
                <td>${getCustomerr.street}</td>
                <td>${getCustomerr.city}</td>
                <td>${getCustomerr.state}</td>
                <td>${getCustomerr.email}</td>
                <td>${getCustomerr.phone}</td>
            </tr>
        </c:forEach>
    </table>

    <br><br>

    <!-- Table for editing and deleting customer details -->
    <table border="1" width="100%" style="background-color:;" id="customerTable">
        <tr>
            <!-- Table headers with placeholders for column names -->
            <th>${firstName}</th>
            <th>${lastName}</th>
            <th>${address}</th>
            <th>${street}</th>
            <th>${city}</th>
            <th>${state}</th>
            <th>${email}</th>
            <th>${phone}</th>
            <th>${EDIT}</th>
            
        </tr>

        <!-- Loop through the customer list and provide options to edit or delete -->
        <c:forEach var="getCustomer" items="${getCustomer}">
            <tr>
                <td>${getCustomer.firstname}</td>
                <td>${getCustomer.lastname}</td>
                <td>${getCustomer.address}</td>
                <td>${getCustomer.street}</td>
                <td>${getCustomer.city}</td>
                <td>${getCustomer.state}</td>
                <td>${getCustomer.email}</td>
                <td>${getCustomer.phone}</td>
                <!-- Links to edit and delete customer details -->
			    <td>
				    <div style="display: flex; align-items: center;margin-left: 10px;">
				        <a href="editCustomer/${getCustomer.email}" style="margin-right: 1px;">
				            <button>
				                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS2bNB-TMdwUAdWlEqZYyXXZKIXS7Pdh4OGbg&s" width="10px" height="10px">
				            </button>
				        </a>
				        <a href="deleteCustomer/${getCustomer.email}">
				            <button>
				                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsonhmPgu3zfBvXPhCdsd3pbxNsa3eRMXf5g&s" width="10px" height="10px">
				            </button>
				        </a>
				    </div>
			   </td>
		</c:forEach>
    </table>

    <!-- JavaScript functions for sorting the table -->
    <script>
        function sortTable() {
            var dropdown = document.getElementById("sortDropdown");
            var selectedOption = dropdown.options[dropdown.selectedIndex].value;

            var table = document.getElementById("customerTable");
            var rows = Array.from(table.rows).slice(1); // Exclude the header row

            rows.sort(function (a, b) {
                var x = a.cells[getColumnIndex(selectedOption)].innerText.toLowerCase();
                var y = b.cells[getColumnIndex(selectedOption)].innerText.toLowerCase();
                return x.localeCompare(y);
            });

            // Clear existing rows in the table
            while (table.rows.length > 1) {
                table.deleteRow(1);
            }

            // Append sorted rows to the table
            rows.forEach(function (row) {
                table.appendChild(row);
            });
        }

        function getColumnIndex(columnName) {
            var headers = document.getElementById("customerTable").rows[0].cells;
            for (var i = 0; i < headers.length; i++) {
                if (headers[i].innerText.toLowerCase() === columnName.toLowerCase()) {
                    return i;
                }
            }
            return -1;
        }
    </script>

    <!-- Footer section -->
    <footer style="margin-top:28%;position: fixed; width:100%;"></footer>
</body>
</html>
