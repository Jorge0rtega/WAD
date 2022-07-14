<%-- 
    Document   : eliminar
    Created on : 4 oct. 2021, 7:49:17
    Author     : Jorge Ortega
--%>

<%@page import="java.lang.Integer"%>
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
            dto.getEntidad().setIdCategoria(Integer.parseInt(request.getParameter("id")));
            dao.delete(dto);
            response.sendRedirect("listaDeCategorias.jsp");
        %>
    </body>
</html>
