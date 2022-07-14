/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador;

import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.dao.ProductoDAO;
import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.dto.ProductoDTO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author Jorge Ortega
 */
@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");

            switch (accion) {
                case "listaDeProductos":
                    listaDeProductos(request, response);
                    break;
                case "nuevo":
                    agregarProducto(request, response);
                    break;
                case "eliminar":
                    eliminarProducto(request, response);
                    break;
                case "actualizar":
                    actualizarProducto(request, response);
                    break;
                case "guardar":
                    almacenarProducto(request, response);
                    break;
                case "ver":
                    mostrarProducto(request, response);
                    break;
                case "verReporte":
                    mostrarReporte(request, response);
                    break;
                case "reporteIndividual":
                    mostrarReporteIndividual(request, response);
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


    private void mostrarReporteIndividual(HttpServletRequest request, HttpServletResponse response) {
        CategoriaDAO dao = new CategoriaDAO();
        try {
            ServletOutputStream sos = response.getOutputStream();
            
            File reporte =new File(getServletConfig().getServletContext().getRealPath("/reportes/ReporteIndividual.jasper"));
            Map<String,Object> map= new HashMap<String, Object>();
            
            map.put("id", Integer.parseInt(request.getParameter("id")) );
            byte[] b = JasperRunManager.runReportToPdf(reporte.getPath(), map, dao.conectar());
            response.setContentType("application/pdf");
            response.setContentLength(b.length);
            
            sos.write(b,0, b.length);
            
            sos.flush();
            sos.close();
            
        } catch (IOException | JRException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarReporte(HttpServletRequest request, HttpServletResponse response) {
        CategoriaDAO dao = new CategoriaDAO();
        try {
            ServletOutputStream sos = response.getOutputStream();
            File reporte =new File(getServletConfig().getServletContext().getRealPath("/reportes/ReporteGeneral.jasper"));
//            Map<String,Object> map= new HashMap<String, Object>();
//            map.put("id", "7");
            byte[] b = JasperRunManager.runReportToPdf(reporte.getPath(), null, dao.conectar());
            response.setContentType("application/pdf");
            response.setContentLength(b.length);
            
            sos.write(b,0, b.length);
            sos.flush();
            sos.close();
            
        } catch (IOException | JRException ex) {
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarProducto(HttpServletRequest request, HttpServletResponse response) {
        ProductoDAO dao = new ProductoDAO();
        ProductoDTO dto = new ProductoDTO();
        dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher vista = request.getRequestDispatcher("/Productos/datosProducto.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("producto", dto);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void almacenarProducto(HttpServletRequest request, HttpServletResponse response) {
        ProductoDAO dao = new ProductoDAO();
        ProductoDTO dto = new ProductoDTO();

        dto.getEntidad().setNombreProducto(request.getParameter("txtNombreProducto"));
        dto.getEntidad().setDescripcionProducto(request.getParameter("txtDescripcionProducto"));
        dto.getEntidad().setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
        dto.getEntidad().setExistencia(Integer.parseInt(request.getParameter("txtExistencia")));
        dto.getEntidad().setStockMinimo(Integer.parseInt(request.getParameter("txtStockMinimo")));
        CategoriaDAO daoCat = new CategoriaDAO();
        List lista;
        try {
            lista = daoCat.readALL();

            for (int i = 0; i < lista.size(); i++) {
                CategoriaDTO dtoCat = (CategoriaDTO) lista.get(i);
                if ((dtoCat.getEntidad().getNombreCategoria()).equals(request.getParameter("txtClaveCategoria"))) {
                    dto.getEntidad().setClaveCategoria(dtoCat.getEntidad().getIdCategoria());
                }
            }
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String CA = request.getParameter("CreateOrUpdate");
            if (Integer.parseInt(CA) == 1) {
                dao.create(dto);
                request.setAttribute("mensaje", "Producto agregado con exito");
                request.setAttribute("ejecutado", "nuevo");
                request.setAttribute("nuevo", "nuevo");
                listaDeProductos(request, response);
            } else {
                dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("txtClaveProducto")));
                dao.update(dto);
                request.setAttribute("mensaje", "Producto actualizado con exito");
                request.setAttribute("ejecutado", "actualizar");
                request.setAttribute("actualizar", "actualizar");
                listaDeProductos(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) {
        ProductoDAO dao = new ProductoDAO();
        ProductoDTO dto = new ProductoDTO();
        CategoriaDAO dao1 = new CategoriaDAO();
        dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher vista = request.getRequestDispatcher("/Productos/productoForm.jsp");
        try {
            Collection categorias = dao1.readALL();
            request.setAttribute("listaDeCategorias", categorias);
            dto = dao.read(dto);
            request.setAttribute("producto", dto);
            request.setAttribute("hacer", "actualizar");
            request.setAttribute("ejecutar", request.getParameter("accion"));
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) {
        ProductoDAO dao = new ProductoDAO();
        ProductoDTO dto = new ProductoDTO();
        dto.getEntidad().setIdProducto(Integer.parseInt(request.getParameter("id")));
        try {
            dao.delete(dto);
            request.setAttribute("mensaje", "Producto Eliminado con exito");
            request.setAttribute("ejecutado", request.getParameter("accion"));
            request.setAttribute("eliminar", "eliminar");
            listaDeProductos(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarProducto(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/Productos/productoForm.jsp?hacer=nuevo");
        CategoriaDAO dao1 = new CategoriaDAO();
        try {
            Collection categorias = dao1.readALL();
            request.setAttribute("listaDeCategorias", categorias);

            request.setAttribute("hacer", "actualizar");
            request.setAttribute("ejecutar", request.getParameter("accion"));
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listaDeProductos(HttpServletRequest request, HttpServletResponse response) {
        ProductoDAO dao = new ProductoDAO();
        try {
            Collection lista = dao.readAll();
            request.setAttribute("listaDeProductos", lista);

            RequestDispatcher rd = request.getRequestDispatcher("/Productos/listaProductos.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CategoriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
