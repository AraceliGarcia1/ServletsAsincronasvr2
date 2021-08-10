<%--
  Created by IntelliJ IDEA.
  User: Araceli
  Date: 06/08/2021
  Time: 08:33 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Videojuegos</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${context}/assets/dist/css/styles.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>
<div id="content">
    <button type="button" class="btn btn-outline-success" onclick="listOfGames();">Listar Videojuegos</button>
    <table class="table table-info table-striped border-">
        <thead class="table-danger">

        <th>Nombre</th>
        <th>Fecha de estreno</th>
        <th>Fotografia</th>
        <th>Categoria</th>
        </thead>
        <tbody id="bodyGames">


        </tbody>

    </table>
</div>
<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript" src="${context}/assets/dist/js/main.js"></script>
</body>
</html>