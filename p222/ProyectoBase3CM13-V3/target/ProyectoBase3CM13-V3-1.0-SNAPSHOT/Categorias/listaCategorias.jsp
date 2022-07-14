<%-- 
    Document   : listaCategorias
    Created on : 11 oct. 2021, 8:28:45
    Author     : Jorge Ortega
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Categoria</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img src="./images/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
                        Proyecto Base V3
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="CategoriaServlet?accion=listaDeCategorias">Lista de Categorias</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="ProductoServlet?accion=listaDeProductos">Listas de Productos</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="UsuarioServlet?accion=listaDeUsuarios">Listas de Usuarios</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="card borde-primary">
                <div class="card-header text-center">
                    Lista de Categorias

                </div>

                <div class="card-body">


                    
                    <div class="container">
                        <div class="row">
                            <div class="col text-start">
                                <h4 class="card-title">
                                    <a href="CategoriaServlet?accion=nuevo" class="btn btn-outline-success">Crear Categoria</a>
                                </h4>
                            </div>                            
                            <div class="col text-end">
                                <h4 class="card-title">
                                    <a href="CategoriaServlet?accion=graficar" class="btn btn-outline-primary" target="_blank">Mostrar Grafica</a>
                                    <a href="CategoriaServlet?accion=verReporte" class="btn btn-outline-warning" target="_blank">Reporte General</a>                                    
                                </h4>
                            </div>
                            
                        </div>
                    </div>
                    
                    <c:if test="${mensaje != null}">
                        <c:if test="${ejecutado == nuevo}">
                            <div class="alert alert-success alert-dismissible fade show fade show" role="alert">
                                <strong>${mensaje}</strong>
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        </c:if>
                        <c:if test="${ejecutado == actualizar}">
                            <div class="alert alert-info alert-dismissible fade show fade show" role="alert">
                                <strong>${mensaje}</strong>
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        </c:if>
                        <c:if test="${ejecutado == eliminar}">
                            <div class="alert alert-danger alert-dismissible fade show fade show" role="alert">
                                <strong>${mensaje}</strong>
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>
                        </c:if>
                    </c:if>
                    <table class ="table table-striped">
                        <thead>
                            <tr>
                                <th>CLave Categoria</th>
                                <th>Nombre Categoria</th>
                                <th>Descripcion Categoria</th>
                                <th>Eliminar</th>
                                <th>Actualizar</th>
                                <th>Reporte</th>
                            </tr>
                        </thead>
                        <c:forEach var="dto" items="${listaDeCategorias}" >
                            <tbody>

                                <tr>
                                    <td>
                                        <a href="CategoriaServlet?accion=ver&id=<c:out value="${dto.entidad.idCategoria}"/>" class="btn btn-outline-warning"><c:out value="${dto.entidad.idCategoria}"/></a>
                                    </td>
                                    <td>
                                        <c:out value="${dto.entidad.nombreCategoria}"/>
                                    </td>
                                    <td>
                                        <c:out value="${dto.entidad.descripcionCategoria}"/>
                                    </td>
                                    <td>
                                        <a href="CategoriaServlet?accion=eliminar&id=<c:out value="${dto.entidad.idCategoria}"/>" class="btn btn-outline-danger">Eliminar</a>
                                    </td>  
                                    <td>
                                        <a href="CategoriaServlet?accion=actualizar&id=<c:out value="${dto.entidad.idCategoria}"/>" class="btn btn-outline-warning">Actualizar</a>
                                    </td> 
                                    <td>
                                        <a href="CategoriaServlet?accion=reporteIndividual&id=<c:out value="${dto.entidad.idCategoria}"/>" class="btn btn-outline-info" target="_blank">Reporte</a>
                                    </td> 
                                </tr>

                            </tbody>
                        </c:forEach>
                    </table>
                </div>

            </div>
        </div>
    </body>
</html>

