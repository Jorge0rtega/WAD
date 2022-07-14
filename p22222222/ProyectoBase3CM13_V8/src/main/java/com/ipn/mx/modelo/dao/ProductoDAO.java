/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;


import com.ipn.mx.modelo.entidades.Producto;
import com.ipn.mx.utilerias.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Jorge Ortega
 */
public class ProductoDAO {
    public void create(Producto dto){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        
        Transaction tx = s.getTransaction();
        try{
            tx.begin();
            s.save(dto.getClass());
            tx.commit();
        }catch(Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
        }
        
    }
    
    public void update(Producto dto){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try{
            tx.begin();
            s.update(dto.getClass());
            tx.commit();
        }catch(Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
        }
        
    }
    
    public void delete(Producto dto){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try{
            tx.begin();
            s.delete(dto.getClass());
            tx.commit();
        }catch(Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
        }
        
    }
    public Producto read(Producto dto){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.getTransaction();
        try{
            tx.begin();
            dto= s.get(dto.getClass(), dto.getIdCategoria());
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
            
            Query q= s.createQuery("from Producto c order by c.idProducto");
            lista=q.list();
//            for(Categoria c: (List<Categoria>) q.list()){
//                CategoriaDTO dto=new CategoriaDTO();
//                dto.setEntidad(c);
//                lista.add(dto);
//            }
//            //lista=q.list();
            tx.commit();
        }catch(Exception e){
            if(tx != null && tx.isActive()){
                tx.rollback();
            }
        }
        return lista;
        
    }
    
    public static void main(String[] args) {
        ProductoDAO dao= new ProductoDAO();
        Producto dto= new Producto();
////        dto.setNombreProducto("Prueba");
////        dto.setDescripcionProducto("esta es una prueba");
////        dto.setExistenciaProducto(12);
////        dto.setPrecioProducto(123);
////        dto.setStockMinimo(3);
            //dto.setIdProducto(1);
////        dao.create(dto);
//        //dao.update(dto);
//        //dao.delete(dao.read(dto));
//        //System.out.println(dao.read(dto));
        System.out.println(dao.readAll());
    }
}
