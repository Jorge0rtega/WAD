/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.UsuarioDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.NamingException;

/**
 *
 * @author Jorge Ortega
 */
public class UsuarioDAO {
     public static final String SQL_INSERT = "select InsertarUsuario(?, ?, ?, ?, ?, ?, ?)";// funciones
    public static final String SQL_UPDATE = "select ActualizarUsuario(?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SQL_DELETE = "select BorrarUsuario(?) ";
    public static final String SQL_READ = "select * from LeerUsuario(?)";
    //public static final String SQL_READ_ALL = "select LeerTodasCategoria()";    
    public static final String SQL_READ_ALL = "select * from LeerTodosUsuario()";

    private Connection conexion;
    private Context initContext;//pool

    public Connection conectar() {
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
        return conexion;
    }
    
    public void create(UsuarioDTO dto) throws SQLException {
        //conectar();
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombre());//el uno se utiliza para decir que queremos el primero de categoria en la declracion de la trabla
            ps.setString(2, dto.getEntidad().getPaterno());
            ps.setString(3, dto.getEntidad().getMaterno());
            ps.setString(4, dto.getEntidad().getEmail());
            ps.setString(5, dto.getEntidad().getNombreUsuario());
            ps.setString(6, dto.getEntidad().getClaveUsuario());
            ps.setString(7, dto.getEntidad().getTipoUsuario());
            ps.executeQuery();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void update(UsuarioDTO dto) throws SQLException {
        //conectar();
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_UPDATE);
            ps.setInt(1, dto.getEntidad().getIdUsuario());
            ps.setString(2, dto.getEntidad().getNombre());
            ps.setString(3, dto.getEntidad().getPaterno());
            ps.setString(4, dto.getEntidad().getMaterno());
            ps.setString(5, dto.getEntidad().getEmail());
            ps.setString(6, dto.getEntidad().getNombreUsuario());
            ps.setString(7, dto.getEntidad().getClaveUsuario());
            ps.setString(8, dto.getEntidad().getTipoUsuario());
            
            ps.executeQuery();
        } finally {
            if (ps != null) {
                ps.close();
            }

            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void delete(UsuarioDTO dto) throws SQLException {
        //conectar();
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdUsuario());
            ps.executeQuery();
        } finally {
            if (ps != null) {
                ps.close();
            }

            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public UsuarioDTO read(UsuarioDTO dto) throws SQLException {
        //conectar();
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdUsuario());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (UsuarioDTO) resultados.get(0);
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
        
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_READ_ALL);
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
            UsuarioDTO dto = new UsuarioDTO();
            dto.getEntidad().setIdUsuario(rs.getInt("idUsuario"));
            dto.getEntidad().setNombre(rs.getString("nombre"));
            dto.getEntidad().setPaterno(rs.getString("paterno"));
            dto.getEntidad().setMaterno(rs.getString("materno"));
            dto.getEntidad().setEmail(rs.getString("email"));
            dto.getEntidad().setNombreUsuario(rs.getString("nombreUsuario"));
            dto.getEntidad().setClaveUsuario(rs.getString("claveUsuario"));
            dto.getEntidad().setTipoUsuario(rs.getString("tipoUsuario"));
            
            resultados.add(dto);
        }
        return resultados;
    }

    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        UsuarioDTO dto = new UsuarioDTO();

        //dto.getEntidad().setIdUsuario(1);
        dto.getEntidad().setNombre("Eduardo");
        dto.getEntidad().setPaterno("Ortega");
        dto.getEntidad().setMaterno("Silva");
        dto.getEntidad().setClaveUsuario("Prueba");
        dto.getEntidad().setEmail("Correo@gmail.com");
        dto.getEntidad().setNombreUsuario("Usuario1");
        dto.getEntidad().setTipoUsuario("Cliente");
        
         try {
             dao.create(dto);
             //System.out.println(dao.readALL());
             //dao.update(dto);
             //dao.delete(dto);
             System.out.println(dao.readALL());
             //System.out.println(dao.read(dto));
         } catch (SQLException ex) {
             Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NamingException ex) {
             Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
            
        

    }

}