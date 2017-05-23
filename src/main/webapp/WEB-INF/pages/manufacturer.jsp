<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.05.2017
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Manufacturer</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>

<h2 align="Center">Manufacture</h2>
<nav role="navigation" class="navbar navbar-default">

    <!-- Toggle menu for mobile display -->
    <div class="navbar-header">
        <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
    </div>

    <!-- default menu -->
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li><a href="/">Home</a></li>
            <li><a href="productView">show all Product View</a></li>
            <li><a href="productType">show all Product Type</a></li>
            <li class="active"><a href="#">show all manufacturer</a></li>
            <li><a href="products">show all products</a></li>
            <li><a href="admin/admin">Admin</a></li>
        </ul>
    </div>

</nav>


<table class="table table-striped">
    <thead>
    <tr>
        <th>mr id</th>
        <th>mr name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="manufacture" items="${mr}">
        <tr>
            <td>${manufacture.mrId}</td>
            <td>${manufacture.mrName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
