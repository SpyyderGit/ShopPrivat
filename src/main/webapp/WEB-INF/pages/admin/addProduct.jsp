<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 23.05.17
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>

<h2 align="Center">Create product</h2>
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
            <li><a href="../">Home</a></li>
            <li class="active"><a href="addProduct">Create</a></li>
            <li><a href="updateProduct">Update</a></li>
            <li><a href="delProduct">Delete</a></li>

        </ul>
    </div>
</nav>

<form:form method="post" action="addResult">
    <table align="Center">
        <tr>
            <td><form:label path="productName">Name</form:label></td>
            <td><form:input path="productName"/></td>
        <tr>
        <tr>
            <td><form:label path="productPrice">Price</form:label></td>
            <td><form:input path="productPrice"/></td>
        <tr>
        <tr>
            <td><form:label path="productRemark">Remark</form:label></td>
            <td><form:input path="productRemark"/></td>
        <tr>
        <tr>
            <td><form:label path="sklad">Sklad(Y/N)</form:label></td>
            <td><form:input path="sklad"/></td>
        <tr>
        <tr>
            <td><form:label path="mrIdFk">id_manuf_re</form:label></td>
            <td><form:input path="mrIdFk"/></td>
        <tr>
        <tr>
            <td><form:label path="typeIdFk">id_type</form:label></td>
            <td><form:input path="typeIdFk"/></td>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
