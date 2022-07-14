<%-- 
    Document   : CategoriasForm
    Created on : 14 oct. 2021, 7:44:43
    Author     : Jorge Ortega
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Usuarios</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" ></script>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img src="/images/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
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
            <div class="card border-primary">
                <div class=" card-header">
                    <h1 class="text-center">Datos del Usuario</h1>

                </div>
                <div class="card-body">

                    <c:if test="${hacer == ejecutar}">
                        <form method="post" action="UsuarioServlet?accion=guardar&CreateOrUpdate=0" accept-charset="ISO-8859-1">
                            <div class="mb-3">
                                <labe class="form-label">Id Usuario</labe>
                                <input type="text" name="txtIdU" id="txtIdU" placeholder="Clave del Usuario" 
                                       required="required" maxlength="10" readonly="readonly" value="<c:out value="${usuario.entidad.idUsuario}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Nombre</labe>
                                <input type="text" name="txtNombreU" id="txtNombreU" placeholder="Nombre del Usuario" 
                                       required="required" maxlength="50" value="<c:out value="${usuario.entidad.nombre}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Apellido Paterno</labe>
                                <input type="text" name="txtPaternoU" id="txtPaternoU" placeholder="Apellido Paterno del Usuario" 
                                       required="required" maxlength="50" value="<c:out value="${usuario.entidad.paterno}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Apellido Materno</labe>
                                <input type="text" name="txtMaternoU" id="txtMaternoU" placeholder="Apellido Materno del Usuario" 
                                       required="required" maxlength="50" value="<c:out value="${usuario.entidad.materno}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Correo Electronico</labe>
                                <input type="text" name="txtEmailU" id="txtEmailU" placeholder="xxxxx@correo.com" 
                                       required="required" maxlength="50" value="<c:out value="${usuario.entidad.email}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Nombre de la Cuenta de Usuario</labe>
                                <input type="text" name="txtNombreUsuario" id="txtNombreUsuario" placeholder="Nombre de la Cuenta de Usuario" 
                                       required="required" maxlength="50" value="<c:out value="${usuario.entidad.nombreUsuario}"/>" class="form-control"/>

                            </div>
                                       <div class="mb-3">
                                <labe class="form-label">Contraseña</labe>
                                <input type="text" name="txtClaveU" id="txtClaveU" placeholder="Contraseña del Usuario" 
                                       required="required" maxlength="50" value="<c:out value="${usuario.entidad.claveUsuario}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Tipo de Usuario</labe>
                                <input type="text" name="txtTipoU" id="txtTipoU" placeholder="Tipo de Usuario" 
                                       required="required" maxlength="50" value="<c:out value="${usuario.entidad.tipoUsuario}"/>" class="form-control"/>

                            </div>
                            <button type="submit" class="btn btn-outline-dark">Actualizar Usuario</button>
                        </form>
                    </c:if>
                    <c:if test="${ejecutar != hacer}">
                        <form method="post" action="UsuarioServlet?accion=guardar&CreateOrUpdate=1" accept-charset="ISO-8859-1">
                            
                            <div class="mb-3">
                                <labe class="form-label">Nombre</labe>
                                <input type="text" name="txtNombreU" id="txtNombreU" placeholder="Nombre del Usuario" 
                                       required="required"  value="<c:out value="${usuario.entidad.nombre}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Apellido Paterno</labe>
                                <input type="text" name="txtPaternoU" id="txtPaternoU" placeholder="Apellido Paterno del Usuario" 
                                       required="required" value="<c:out value="${usuario.entidad.paterno}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Apellido Materno</labe>
                                <input type="text" name="txtMaternoU" id="txtMaternoU" placeholder="Apellido Materno del Usuario" 
                                       required="required"  value="<c:out value="${usuario.entidad.materno}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Correo Electronico</labe>
                                <input type="text" name="txtEmailU" id="txtEmailU" placeholder="xxxxx@correo.com" 
                                       required="required" maxlength="50" value="<c:out value="${usuario.entidad.email}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Nombre de la Cuenta de Usuario</labe>
                                <input type="text" name="txtNombreUsuario" id="txtNombreUsuario" placeholder="Nombre de la Cuenta de Usuario" 
                                       required="required"  value="<c:out value="${usuario.entidad.nombreUsuario}"/>" class="form-control"/>

                            </div>
                                       <div class="mb-3">
                                <labe class="form-label">Contraseña</labe>
                                <input type="text" name="txtClaveU" id="txtClaveU" placeholder="Contraseña del Usuario" 
                                       required="required" value="<c:out value="${usuario.entidad.claveUsuario}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Tipo de Usuario</labe>
                                <input type="text" name="txtTipoU" id="txtTipoU" placeholder="Tipo de Usuario" 
                                       required="required"  value="<c:out value="${usuario.entidad.tipoUsuario}"/>" class="form-control"/>

                            </div>
                            <button type="submit" class="btn btn-outline-primary">Guardar Categoria</button>
                        </form>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>


