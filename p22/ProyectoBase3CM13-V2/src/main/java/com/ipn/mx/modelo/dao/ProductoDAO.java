/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;


import com.ipn.mx.modelo.dto.ProductoDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Jorge Ortega
 */
public class ProductoDAO {

    private static final String SQL_INSERT = "insert into Producto(nombreProducto, descripcionProducto, precio, existencia, stockMinimo, claveCategoria) values (?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update Producto set nombreProducto = ?, descripcionProducto = ?, precio = ?, existencia = ?, stockMinimo = ?, claveCategoria = ? where idProducto = ?";
    private static final String SQL_DELETE = "delete from Producto where idProducto = ?";
    private static final String SQL_READ = "Select idProducto, nombreProducto, descripcionProducto, precio, existencia, stockMinimo, claveCategoria from Producto where idProducto = ?";
    private static final String SQL_READ_ALL = "Select idProducto, nombreProducto, descripcionProducto, precio, existencia, stockMinimo, claveCategoria from Producto order by idProducto";
    private Context initContext;//pool
    private Connection conexion;

    private void conectar() {
        String user = "postgres"; //postgres
        String pwd = "jorge"; //admin
        String url = "jdbc:postgresql://localhost:5432/postgres";//lo ultimo es el nombre de la base
        String pgDriver = "org.postgresql.Driver";

        try {
            Class.forName(pgDriver);
            conexion = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//    private void conectar() {
//        String user = "hrlrhgidmimnwu"; //postgres
//        String pwd = "c887ceebfd9428666e5e54b60a2d4f28ba439e0246e74703ec29b50c6cea11a9"; //admin
//        String url = "jdbc:postgresql://ec2-3-220-214-162.compute-1.amazonaws.com:5432/de45fbh4g1lkn9";//lo ultimo es el nombre de la base
//        String pgDriver = "org.postgresql.Driver";                                                          //Pss
//
//        try {
//            Class.forName(pgDriver);
//            conexion = DriverManager.getConnection(url, user, pwd);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    
//    private void conectarPool() {
//          
//            initContext=new InitialContext();
//            DataSource ds= (DataSource) initContext.lookup("java:/comp/env/jdbc/postgresFinal");
//            try {
//                conexion=ds.getConnection();
//            } catch (SQLException ex) {
//                   Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//
//            try {
//                if((conexion==null)|| conexion.isClosed()){
//                    System.out.println("No hay conexion a la base de datos");     
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//    }
    public void create(ProductoDTO dto) throws SQLException {
        //conectar();
        conectar();
//        ConexionBD conex=new ConexionBD();
//        conexion=conex.conectarBD();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreProducto());//el uno se utiliza para decir que queremos el primero de categoria en la declracion de la trabla
            ps.setString(2, dto.getEntidad().getDescripcionProducto());
            ps.setDouble(3, dto.getEntidad().getPrecio());
            ps.setInt(4, dto.getEntidad().getExistencia());
            ps.setInt(5, dto.getEntidad().getStockMinimo());
            ps.setInt(6, dto.getEntidad().getClaveCategoria());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    
    public void update(ProductoDTO dto) throws SQLException {
        //conectar();
        conectar();
//        ConexionBD conex=new ConexionBD();
//        conexion=conex.conectarBD();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreProducto());//el uno se utiliza para decir que queremos el primero de categoria en la declracion de la trabla
            ps.setString(2, dto.getEntidad().getDescripcionProducto());
            ps.setDouble(3, dto.getEntidad().getPrecio());
            ps.setInt(4, dto.getEntidad().getExistencia());
            ps.setInt(5, dto.getEntidad().getStockMinimo());
            ps.setInt(6, dto.getEntidad().getClaveCategoria());
            ps.setInt(7, dto.getEntidad().getIdProducto());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    public void delete (ProductoDTO dto) throws SQLException {
        //conectar();
        conectar();
//        ConexionBD conex=new ConexionBD();
//        conexion=conex.conectarBD();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);      
            ps.setInt(1, dto.getEntidad().getIdProducto());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    public ProductoDTO read(ProductoDTO dto) throws SQLException {
        //conectar();
        conectar();
        //ConexionBD conex= new ConexionBD();
        //conexion=conex.conectarBD();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdProducto());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (ProductoDTO)resultados.get(0);
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    public List readAll() throws SQLException {
        //conectar();
        conectar();
        //ConexionBD conex= new ConexionBD();
        //conexion=conex.conectarBD();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {
            ProductoDTO p = new ProductoDTO();
            p.getEntidad().setIdProducto(rs.getInt("idProducto"));
            p.getEntidad().setNombreProducto(rs.getString("nombreProducto"));
            p.getEntidad().setDescripcionProducto(rs.getString("descripcionProducto"));
            p.getEntidad().setPrecio(rs.getDouble("precio"));
            p.getEntidad().setExistencia(rs.getInt("existencia"));
            p.getEntidad().setStockMinimo(rs.getInt("stockMinimo"));
            p.getEntidad().setClaveCategoria(rs.getInt("claveCategoria"));

            resultados.add(p);
        }
        return resultados;
    }

    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAO();
        ProductoDTO dto = new ProductoDTO();
            dto.getEntidad().setIdProducto(11);
//        dto.getEntidad().setNombreProducto("Profe Ingles");
//        dto.getEntidad().setDescripcionProducto("Da clases de Ingles");
//       dto.getEntidad().setExistencia(90);
//        dto.getEntidad().setPrecio(234);
//        dto.getEntidad().setStockMinimo(20);
//        dto.getEntidad().setClaveCategoria(2);
        try {
            //dao.create(dto);
//           dao.update(dto);
           
//             //System.out.println(dao.read(dto));
           dao.delete(dto);
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
