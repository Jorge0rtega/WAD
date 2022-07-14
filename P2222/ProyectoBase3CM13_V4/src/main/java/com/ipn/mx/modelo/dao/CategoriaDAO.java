/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.entidades.Categoria;
import com.ipn.mx.utilerias.HibernateUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Jorge Ortega
 */
public class CategoriaDAO {
    public void create(CategoriaDTO dto){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        /*
        getCurrentSession: crea una nueva sesión si no existe; de ​​lo contrario, usa la misma sesión 
        actual. Vacía y cierra automáticamente la sesión cuando 
        finaliza la transacción, por lo que no es necesario que lo haga de forma externa.
        
        openSession:  siempre crea un nuevo objeto Session de nuevo y se lo da. 
        Necesita vaciar y cerrar explícitamente estos objetos de sesión. */
        
        Transaction tx = s.getTransaction();
        try{
            tx.begin();
            s.save(dto.getEntidad());
            tx.commit();
        }catch(Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
        }
        
    }
    
    public void update(CategoriaDTO dto){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try{
            tx.begin();
            s.update(dto.getEntidad());
            tx.commit();
        }catch(Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
        }
        
    }
    
    public void delete(CategoriaDTO dto){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try{
            tx.begin();
            s.delete(dto.getEntidad());
            tx.commit();
        }catch(Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
        }
        
    }
    
    public CategoriaDTO read(CategoriaDTO dto){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try{
            tx.begin();
            dto.setEntidad(s.get(dto.getEntidad().getClass(), dto.getEntidad().getIdCategoria()));
            tx.commit();
        }catch(Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
        }
        return dto;
        
    }
    
    public List readAll(){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        List lista = new ArrayList();
        try{
            tx.begin();
            
            Query q= s.createQuery("from Categoria c order by c.idCategoria");
            for(Categoria c: (List<Categoria>) q.list()){
                CategoriaDTO dto=new CategoriaDTO();
                dto.setEntidad(c);
                lista.add(dto);
            }
            //lista=q.list();
            tx.commit();
        }catch(Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
        }
        return lista;
        
    }
    
    public static void main(String[] args) {
        CategoriaDAO dao= new CategoriaDAO();
        CategoriaDTO dto= new CategoriaDTO();
//        dto.getEntidad().setNombreCategoria("Categoria");
//        dto.getEntidad().setDescripcionCategoria("descripcion de categoria 1");
//        dto.getEntidad().setIdCategoria(1);
//        dao.create(dto);
//        dao.update(dto);
//        dao.delete(dao.read(dto));
//        System.out.println(dao.read(dto));
        System.out.println(dao.readAll());
    }
    
}
