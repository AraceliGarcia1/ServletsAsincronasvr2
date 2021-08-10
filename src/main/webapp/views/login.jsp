<%--
  Created by IntelliJ IDEA.
  User: Araceli
  Date: 06/08/2021
  Time: 09:28 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Login | Inicio de Sesion</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>
<h1>Ingresar Sesion</h1>
<form action="${context}/login" method="POST">
    <label>Correo:</label>
    <input class="form-control" type="email" name="email" />
    <br>
    <label>Contraseña:</label>
    <input class="form-control" type="password" name="password" />
    <br>
    <button type="submit" class="btn btn-success"><i class="fas fa-check-square"></i> Iniciar</button>
    <button type="button" class="btn btn-secondary"><i class="fas fa-times"></i> Cancelar</button>
</form>
<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</body>
</html>
