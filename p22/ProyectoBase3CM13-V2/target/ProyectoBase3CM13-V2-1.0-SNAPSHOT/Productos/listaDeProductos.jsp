<%-- 
    Document   : listadoDeCategorias
    Created on : 4 oct. 2021, 7:16:30
    Author     : Jorge Ortega
--%>

<%@page import="com.ipn.mx.modelo.dto.ProductoDTO"%>
<%@page import="com.ipn.mx.modelo.dao.ProductoDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
        <script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js' ></script>
        <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js' ></script>
    </head>
    <body>
        <div>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="../index.jsp">Home</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="../tablasDeMultiplicar.jsp">Tablas de Multiplicar</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../Categorias/listaDeCategorias.jsp">listado de Categorias</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="listaDeProductos.jsp">listado de Productos</a>
                            </li>
                        </ul>
                    </div>
                </div>

            </nav>
            <div class="card border-primary">
                <div class="card-header">
                    <h1>Listado de Productos</h1>
                    <div class="card-body text-primary">
                        <table class="table table-striped">
                            <tr>
                                <th>Clave Producto</th>
                                <th>Nombre Producto</th>
                                <th>Descripcion Producto</th>
                                <th>Precio Producto</th>
                                <th>Existencia Producto</th>
                                <th>Stock Producto</th>
                                <th>Clave Categoria</th>
                                <th>Eliminar</th>
                                <th>Actualiar</th>
                            </tr>
                            <%
                                ProductoDAO dao= new ProductoDAO();
                                List lista= dao.readAll();
                                //se puede indicar que hay o no hay valores con un if lista!= null
                                for (int i = 0; i<lista.size() ; i++) {
                                        ProductoDTO cat=(ProductoDTO)lista.get(i);
                                    
                            %>
                            <tr>
                                <td>
                                    <a href="verDatos.jsp?id=<%=cat.getEntidad().getIdProducto() %>" class="btn btn-warning"><%=cat.getEntidad().getIdProducto() %></a>
                                    <%--<%= cat.getEntidad().getIdCategoria() %>--%>
                                </td>
                                <td>
                                    <%= cat.getEntidad().getNombreProducto() %>
                                </td>
                                <td>
                                    <%= cat.getEntidad().getDescripcionProducto() %>
                                </td>
                                <td>
                                    <%= cat.getEntidad().getPrecio() %>
                                </td>
                                <td>
                                    <%= cat.getEntidad().getExistencia() %>
                                </td>
                                <td>
                                    <%= cat.getEntidad().getStockMinimo() %>
                                </td>
                                <td>
                                    <%= cat.getEntidad().getClaveCategoria() %>
                                </td>
                                <td>
                                    <a href="elimiar.jsp?id=<%=cat.getEntidad().getIdProducto() %>" class="btn btn-danger">Eliminar</a>
                                </td>
                                <td>
                                    <a href="actualizar.jsp?id=<%=cat.getEntidad().getIdProducto() %>" class="btn btn-success">Actualizar</a>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                    </div>
                </div>    
                        <a href="nuevoProducto.jsp" class="btn btn-primary">nuevo</a>
            </div>
        </div>
    </body>
</html>
