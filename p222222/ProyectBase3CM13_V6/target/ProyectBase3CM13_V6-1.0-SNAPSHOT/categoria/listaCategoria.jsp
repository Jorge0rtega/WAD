<%-- 
    Document   : listaCategoria
    Created on : 29 nov. 2021, 7:53:10
    Author     : Jorge Ortega
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <s:property value="tiulo"/>
        </title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img src="./images/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
                        Proyecto Base V6
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
                                <a class="nav-link" href="listarCategorias">Lista de Categorias</a>
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
            <div class="mb-3"></div>
            <div class="card text-primary border-primary mb-3">
                <div class="card-header txt-center">
                    <s:property value="titulo"/>
                </div>
                <div class="card-body table-responsive ">
                    <h4 class="card-title">
                        <a href="<s:url action="agregarCategoria"/>" class="btn btn-outline-success">
                            <s:property value="nuevo"/>
                    </h4>
                    <div class="mb-3"></div>
                    <table class="table table-stripped">
                        <tr>
                            <td>
                                <s:property value="idCategoria"/>
                            </td>
                            <td>
                                Nombre de la categoria
                            </td>
                            <td>
                                Descripcion de la categoria
                            </td>
                            <td>
                                Eliminar
                            </td>
                            <td>
                                Actualizar
                            </td>
                        </tr>
                        <s:iterator value="categorias">
                            <tr>
                                <td>
                                    <s:property value="idCategoria"/> 
                                </td>
                                <td>
                                    <s:property value="nombreCategoria"/> 
                                </td>
                                <td>
                                    <s:property value="descripcionCategoria"/> 
                                </td>
                                <td>
                                    <s:url action="eliminarCategoria" var="dto">
                                        <s:param name="categoria.idCategoria" value="%{idCategoria}"/>
                                    </s:url>
                                    <s:a href="%{dto}" class="btn btn-outline-danger">
                                        <s:property value="eliminar"/>
                                    </s:a>
                                </td>
                                <td>
                                    <s:url action="actualizarCategoria" var="dto">
                                        <s:param name="categoria.idCategoria" value="%{idCategoria}"/>
                                    </s:url>
                                    <s:a href="%{dto}" class="btn btn-outline-info">
                                        <s:property value="actualizar"/>
                                    </s:a>
                                </td>
                            </tr>
                        </s:iterator>
                    </table>

                </div>

            </div>

        </div>

    </body>
</html>


