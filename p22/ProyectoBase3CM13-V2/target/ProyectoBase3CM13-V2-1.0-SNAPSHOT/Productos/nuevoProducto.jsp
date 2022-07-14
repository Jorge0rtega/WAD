<%-- 
    Document   : nuevoCategoria
    Created on : 7 oct. 2021, 7:24:02
    Author     : Jorge Ortega
--%>

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
                                <a class="nav-link" href="../Categorias/listaDeCategorias.jsp">listado de Categorias</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="listaDeProductos.jsp">listado de Productos</a>
                            </li>
                        </ul>
                    </div>
                </div>

            </nav>
            <div class=""mb-3"></div>
            <div class="card" border-success>
                <div class="card-header"> 
                <h1 class=" text-primary text-center">Datos del Producto</h1>
                </div>
                <div class="card-body">
                    <form method="post" action="agregarProducto.jsp"  accept-charset="ISO-8859-1">
                        <div class="mb-3">
                            <label class="form-label">Nombre del Producto</label>
                            <input type="text" name="txtNombre" id="txtNombre" placeholder="Nombre del Producto" required="required"
                                   maxlength="50" class="form-control"/>
                        </div>
                        
                        <div class="mb-3">
                            <label class="form-label">Descripcion del Producto</label>
                            <input type="text" name="txtDescripcion" id="txtDescipcion" placeholder="Descripcion del Producto" required="required"
                                   maxlength="50" class="form-control"/>
                        </div>
                        
                        <div class="mb-3">
                            <label class="form-label">Precio del Producto</label>
                            <input type="text" name="txtPrecio" id="txtPrecio" placeholder="$00000.00" required="required"
                                   maxlength="50" class="form-control"/>
                        </div>
                        
                        <div class="mb-3">
                            <label class="form-label">Existencia del Producto</label>
                            <input type="number" name="txtExistencia" id="txtExistencia" placeholder="Numero de Existencia" required="required"
                                   maxlength="50" class="form-control" step="1" min="1" max="100"/>
                        </div>
                        
                        <div class="mb-3">
                            <label for="txtStockMinimo" class="form-label"> Stock Producto</label>
                            <input type="number" id="txtStockMinimo" name="txtStockMinimo" placeholder="stock del Producto"
                                   class="form-control" required="required"/>
                        </div>
                        
                        <div class="mb-3">
                            <label for="txtClaveCategoria" class="form-label"> Clave Producto</label>
                            <input type="number" id="txtClaveCategoria" name="txtClaveCategoria" placeholder="Clave de la Categoria"
                               class="form-control" required="required"/>
                        </div>
                        <button type="submit" class="btn btn-primary">Registrar</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
