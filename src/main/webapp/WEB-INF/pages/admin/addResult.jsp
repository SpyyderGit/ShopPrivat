<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.05.2017
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>


</head>
<body>
<h2 align="Center">All Directories</h2>


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
            <li class="active"><a href="../">Home</a></li>
            <li><a href="../productView">show all Product View</a></li>
            <li><a href="../productType">show all Product Type</a></li>
            <li><a href="../manufacturer">show all manufacturer</a></li>
            <li><a href="../products">show all products</a></li>

        </ul>
    </div>
</nav>

<div>
    <p>
    <h3>Product add successfull</h3></p>
    <p>Name: ${name}</p>
    <p>Price: ${price}</p>
    <p>Remark: ${remark}</p>
    <p>Sllad: ${sklad}</p>
    <p>Manufacture id: ${mr_id}</p>
    <p>Type id: ${type_id} </p>
</div>

</body>
</html>
