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
        <title>Formulario de Categoria</title>
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
                    <h1 class="text-center">Datos del Producto</h1>

                </div>
                <div class="card-body">

                    <c:if test="${hacer == ejecutar}">
                        <form method="post" action="ProductoServlet?accion=guardar&CreateOrUpdate=0" accept-charset="ISO-8859-1">
                            <div class="mb-3">
                                <labe class="form-label">Clave Producto</labe>
                                <input type="text" name="txtClaveProducto" id="txtClaveProducto" placeholder="Clave del Producto" 
                                       required="required" maxlength="50" readonly="readonly" value="<c:out value="${producto.entidad.idProducto}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Nombre Producto</labe>
                                <input type="text" name="txtNombreProducto" id="txtNombreProducto" placeholder="Nombre del Producto" 
                                       required="required" maxlength="50" value="<c:out value="${producto.entidad.nombreProducto}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Descripcion Producto</labe>
                                <input type="text" name="txtDescripcionProducto" id="txtDescripcionProducto" placeholder="Nombre del Producto" 
                                       required="required" maxlength="50" value="<c:out value="${producto.entidad.descripcionProducto}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Precio</labe>
                                <input type="text" name="txtPrecio" id="txtPrecio" placeholder='$00000.00'
                                       required="required"  value="<c:out value="${producto.entidad.precio}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Existencia</labe>
                                <input type="number" name="txtExistencia" id='txtExistencia' name='txtExistencia' step='1' min='1' placeholder="Existencia del Producto" 
                                       required="required" value="<c:out value="${producto.entidad.existencia}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Stock Minimio</labe>
                                <input type='number' id='txtStockMinimo' name='txtStockMinimo' placeholder='stock Producto' step='1' min='1' 
                                       required="required" value="<c:out value="${producto.entidad.stockMinimo}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Clave Categoria</labe>

                                <select id='claveCat' name='txtClaveCategoria' class='form-select' required='required' >
                                    <c:forEach var="categoria" items="${listaDeCategorias}" >
                                        <c:if test="${categoria.entidad.idCategoria == producto.entidad.claveCategoria}">
                                            <option value="<c:out value="${categoria.entidad.nombreCategoria}"/>" selected>  <c:out value="${categoria.entidad.nombreCategoria}"/>  </option>                                       
                                        </c:if>
                                        <c:if test="${categoria.entidad.idCategoria != producto.entidad.claveCategoria}">
                                            <option value="<c:out value="${categoria.entidad.nombreCategoria}"/>" ><c:out value="${categoria.entidad.nombreCategoria}"/></option>                                       
                                        </c:if>
                                    </c:forEach>
                                </select>                                 
                            </div>
                            <button type="submit" class="btn btn-outline-dark">Actualizar Categoria</button>
                        </form>
                    </c:if>
                    <c:if test="${ejecutar != hacer}">
                        <form method="post" action="ProductoServlet?accion=guardar&CreateOrUpdate=1" accept-charset="ISO-8859-1">
                            <div class="mb-3">
                                <labe class="form-label">Nombre Producto</labe>
                                <input type="text" name="txtNombreProducto" id="txtNombreProducto" placeholder="Nombre del Producto" 
                                       required="required" maxlength="50" value="<c:out value="${producto.entidad.nombreProducto}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Descripcion Producto</labe>
                                <input type="text" name="txtDescripcionProducto" id="txtDescripcionProducto" placeholder="Nombre del Producto" 
                                       required="required" maxlength="50" value="<c:out value="${producto.entidad.descripcionProducto}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Precio</labe>
                                <input type="text" name="txtPrecio" id="txtPrecio" placeholder='$00000.00'
                                       required="required"  value="<c:out value="${producto.entidad.precio}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Existencia</labe>
                                <input type="number" name="txtExistencia" id='txtExistencia' name='txtExistencia' step='1' min='1' placeholder="Existencia del Producto" 
                                       required="required" value="<c:out value="${producto.entidad.existencia}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Stock Minimio</labe>
                                <input type='number' id='txtStockMinimo' name='txtStockMinimo' placeholder='stock Producto' step='1' min='1' 
                                       required="required" value="<c:out value="${producto.entidad.stockMinimo}"/>" class="form-control"/>

                            </div>
                            <div class="mb-3">
                                <labe class="form-label">Clave Categoria</labe>

                                <select id='claveCat' name='txtClaveCategoria' class='form-select' required='required' >
                                    <c:forEach var="categoria" items="${listaDeCategorias}" >
                                        <option value="<c:out value="${categoria.entidad.nombreCategoria}"/>" ><c:out value="${categoria.entidad.nombreCategoria}"/></option>                                       
                                    </c:forEach>
                                </select>                                 
                            </div>
                            <button type="submit" class="btn btn-outline-primary">Guardar Producto</button>
                        </form>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>


