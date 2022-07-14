/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
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
public class CategoriaDAO {

    public static final String SQL_INSERT = "insert into Categoria(nombreCategoria, descripcionCategoria) values (?, ?)";
    public static final String SQL_UPDATE = "update Categoria set nombreCategoria = ?, descripcionCategoria = ? where idCategoria= ?";
    public static final String SQL_DELETE = "delete from Categoria where idCategoria= ?";
    public static final String SQL_READ = "select idCategoria, nombreCategoria, descripcionCategoria from Categoria where idCategoria = ?";
    public static final String SQL_READ_ALL = "select idCategoria, nombreCategoria, descripcionCategoria from  Categoria order by idCategoria";


    private Connection conexion;
    private Context initContext;//pool

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
    
//    private void conectar() throws NamingException {
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
    
    
    public void create(CategoriaDTO dto) throws SQLException {
        //conectar();
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreCategoria());//el uno se utiliza para decir que queremos el primero de categoria en la declracion de la trabla
            ps.setString(2, dto.getEntidad().getDescripcionCategoria());
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

    public void update(CategoriaDTO dto) throws SQLException {
        //conectar();
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setInt(1, dto.getEntidad().getIdCategoria());
            ps.setString(2, dto.getEntidad().getNombreCategoria());
            ps.setString(3, dto.getEntidad().getDescripcionCategoria());
            
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

    public void delete(CategoriaDTO dto) throws SQLException {
        //conectar();
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdCategoria());
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

    public CategoriaDTO read(CategoriaDTO dto) throws SQLException {
        //conectar();
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdCategoria());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (CategoriaDTO) resultados.get(0);
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

    public List readALL() throws SQLException, NamingException {
        //conectar();
        conectar();
        
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
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdCategoria(rs.getInt("idCategoria"));
            dto.getEntidad().setNombreCategoria(rs.getString("nombreCategoria"));
            dto.getEntidad().setDescripcionCategoria(rs.getString("descripcionCategoria"));
            resultados.add(dto);
        }
        return resultados;
    }

    public static void main(String[] args) {
        CategoriaDAO dao = new CategoriaDAO();
        CategoriaDTO dto = new CategoriaDTO();

        //dto.getEntidad().setIdCategoria(3);
        //dto.getEntidad().setNombreCategoria("Trabajo");
//        //dto.getEntidad().setDescripcionCategoria("Cosas de la oficina");
//        try {
//            dao.create(dto);
//            dao.update(dto);
//            System.out.println(dao.readALL());
//            System.out.println(dao.read(dto));
//            dao.delete(dto);
//        } catch (NamingException ex) {
//            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

}
