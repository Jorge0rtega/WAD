<%-- 
    Document   : verDatos
    Created on : 4 oct. 2021, 7:52:03
    Author     : Jorge Ortega
--%>

<%@page import="com.ipn.mx.modelo.dto.CategoriaDTO"%>
<%@page import="com.ipn.mx.modelo.dao.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                                <a class="nav-link" href="listaDeCategorias.jsp">listado de Categorias</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../Productos/listaDeProductos.jsp">listado de Productos</a>
                            </li>
                        </ul>
                    </div>
                </div>

            </nav>
        
        
            <div class="card border-primary">
                    <div class="card-header">
                        <h1>Vista Individual</h1>
                        <%
                            CategoriaDAO dao= new CategoriaDAO();
                            CategoriaDTO dto= new CategoriaDTO();
                            dto.getEntidad().setIdCategoria(Integer.parseInt(request.getParameter("id")));
                            dto= dao.read(dto);
                            if(dto!=null){
                         %>
                         <div class="card-body text-primary">
                            <table class="table table-striped">
                                <tr>
                                    <th>Clave Categoria</th>
                                    <td>
                                        <%= dto.getEntidad().getIdCategoria() %>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Nombre Categoria</th>
                                    <td>
                                        <%= dto.getEntidad().getNombreCategoria() %>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Descripcion Categoria</th>
                                    <td>
                                        <%= dto.getEntidad().getDescripcionCategoria() %>
                                    </td>
                                </tr>
                            </table>
                        </div>
                     <%
                        }else{
                            out.println("sin valores a mostrar");
                        }
                    %>
                    
                </div>    
                        <a href="listaDeCategorias.jsp" class="btn btn-warning">Regresar</a>
            </div>
        </div>
    </body>
</html>
