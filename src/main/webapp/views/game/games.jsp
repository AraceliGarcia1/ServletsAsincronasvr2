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
    <title>Listado de videojuegos</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${context}/assets/dist/css/styles.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>
<table id="container" class="table table-info table-striped border-">
    <thead class="table-danger">
    <tr>
        <th>#</th>
        <th>Nombre</th>
        <th>Fecha</th>
        <th>Imagen</th>
        <th>Estado</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody></tbody>
</table>
<%-- MODAL --%>
<div id="main" >
            <form action="${context}/createGames" method="POST">
                <input type="text" name="name" placeholder="Nombre"/>
                <input type="image" name="imgGame" placeholder="Imagen"/>
                <input type="text" name="datePremiere" placeholder="Fecha de Estreno"/>
                <input type="text" name="Category_idCategoria.name" placeholder="Categoria"/>
                <div style="display: block;width: 60%;margin: 0 auto">
                    <button type="submit" name="send" placeholder="enviar"/><i class="fas fa-check-square"></i> Registrar</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
                    <div id="status"></div>
                </div>
            </form>
</div>
<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="${context}/assets/dist/js/main.js"></script>
</body>



</html>
