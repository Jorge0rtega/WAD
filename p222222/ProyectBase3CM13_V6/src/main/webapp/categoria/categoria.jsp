<%-- 
    Document   : categoria
    Created on : 29 nov. 2021, 7:52:07
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
                    <s:form action="almacenarCategoria">
                        <s:hidden name="categoria.idCategoria"/>
                        <div class="form-group row">
                            <s:textfield name="categoria.nombreCategoria" 
                                         key="categoria.nombreCategoria"
                                         maxlength="50"
                                         class="form-control"
                                         requiredLabel="Es obligatorio"/>
                        </div>
                        <div class="form-group row">
                            <s:textfield name="categoria.descripcionCategoria" 
                                         key="categoria.descripcionCategoria"
                                         maxlength="100"
                                         class="form-control"
                                         requiredLabel="Es obligatorio"/>
                        </div>
                        <div class="mb-3"></div>
                        <s:submit key="categoria.boton.guardar" class="btn-btn-outline-success"/>   

                    </s:form>

                </div>

            </div>

        </div>

    </body>
</html>



