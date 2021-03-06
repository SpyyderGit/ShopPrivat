<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.05.2017
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>

<tr><h2 align="Center">All products</h2></tr>

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
            <li><a href="../../">Home</a></li>
            <li class="active"><a href="byPrice">Filter by price</a></li>
            <li><a href="byId">Filter by id</a></li>
            <li><a href="byName">Filter by name</a></li>
            <li><a href="bySklad">Filter by sklad</a></li>
            <li><a href="byType">Filter by type</a></li>
            <li><a href="byView">Filter by view</a></li>
            <li><a href="byMr">Filter by manufacture</a></li>
        </ul>
    </div>
</nav>


<table class="table table-striped">
    <thead>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Remark:</th>
        <th>Sklad</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="productPrice" items="${price}">
        <tr>
            <td>${productPrice.productName}</td>
            <td>${productPrice.productPrice}</td>
            <td>${productPrice.productRemark}</td>
            <td>${productPrice.sklad}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
