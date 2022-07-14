<%-- 
    Document   : tablasDeMultiplicar
    Created on : 27 sept. 2021, 8:12:51
    Author     : Jorge Ortega
--%>



<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
                    <a class="navbar-brand" href="index.jsp">Home</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="tablasDeMultiplicar.jsp">Tablas de Multiplicar</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Categorias/listaDeCategorias.jsp">listado de Categorias</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Productos/listaDeProductos.jsp">Listado de Productos</a>
                            </li>
                        </ul>
                    </div>
                </div>

            </nav>
            <table class="table table-striped">
                <%
                    for (int i = 0; i < 10; i++) {
                        out.println("<tr>");
                        for (int j = 0; j < 10; j++) {
                        out.println("<td>"+(i*j)+"</td>");
                        }
                        out.println("<tr>");
                    }
                %>
                <%--<%!ArrayList tablas(){
                    for (int i = 0; i < 10; i++) {
                        //
                        for (int j = 0; j < 10; j++) {
                        //out.println("<td>"+(i*j)+"</td>");
                        List<Integer> tablaMul= new ArrayList();
                        tablaMul.add(i*j);
                        }
                        //out.println("<tr>");
                    }
                    return tablaMul;
                }
                %>
                <%
                    tablas();
                  %>  --%>
                
        </div>
    </body>
</html>
