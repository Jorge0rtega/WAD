/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jorge Ortega
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "nombre",length = 50)
    private String nombre;
    @Column(name = "paterno",length = 50)
    private String paterno;
    @Column(name = "materno",length = 50)
    private String materno;

    @Column(name = "email",length = 100, unique = true)
    private String email;
    
    private String imagen;//Foto del usuario 1- almacenar la imagen dentro del atributo 2- almacenar la ruta de la imagen 
    
    @Size(min =8, max= 20, message = "El nombre debe de tener una logitud entre 5 y 20")
    @Column(name = "nombreUsuario",length = 20)
    private String nombreUsuario;
    
    @NotNull
    @Size(min =5, max= 20, message = "La clave debe de tener una logitud entre 5 y 20")
    @Column(name = "claveUsuario",length = 20)
    private String claveUsuario;
    @Column(name = "tipoUsuario",length = 1)
    private String tipoUsuario;
    
    @Column(name = "createAt")
    @Temporal(TemporalType.DATE)
    private Date createAt;//fecha de creacion
    
    @PrePersist
    public void prePersist(){
        createAt=new Date();
    }
    
    public static void main(String[] args) {
        Usuario u = new Usuario();
        //u.setIdUsuario(2);
//        u.setNombre("Actualizacion");
//        u.setPaterno("ya");
//        u.setMaterno("ye");
//        u.setEmail("email2@email.com");
//        u.setNombreUsuario("nombreprueba");
//        u.setClaveUsuario("estaeslaclave");
//        u.setTipoUsuario("A");
//        u.setImagen("sin imagen");
        
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("ProyectoBaseV5PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //em.persist(u);//crear
        //em.merge(u);//actualizar
        //System.out.println(em.find(Usuario.class, u.getIdUsuario()));//mostrar un usuario
        //u=em.find(Usuario.class, u.getIdUsuario());//para que eliminar
        //em.remove(u);//eliminar
        //TypedQuery<Usuario> q = em.createQuery("select u from Usuario u", Usuario.class);//todos los usuarios
        //System.out.println(q.getResultList());
        em.getTransaction().commit();
    }
}
