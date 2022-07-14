<%-- 
    Document   : agregarCategoria
    Created on : 7 oct. 2021, 7:30:40
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
    </head>
    <body>
        <%
            CategoriaDAO dao= new CategoriaDAO();
            CategoriaDTO dto= new CategoriaDTO();
            dto.getEntidad().setNombreCategoria(request.getParameter("txtNombre"));
            dto.getEntidad().setDescripcionCategoria(request.getParameter("txtDescripcion"));
            dao.create(dto);
            response.sendRedirect("listaDeCategorias.jsp");
            
        %>
    </body>
</html>
