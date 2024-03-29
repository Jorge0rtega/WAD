/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.utilerias;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.Metadata;

/**
 *
 * @author Jorge Ortega
 */
public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            try{
                registry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
                MetadataSources mds = new MetadataSources(registry);
                Metadata metadata= mds.getMetadataBuilder().build();
                sessionFactory= metadata.getSessionFactoryBuilder().build();
                
            }catch(Exception e){
                if(registry != null){
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }
    
    public static void shutdown(){
        if(registry != null){
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
