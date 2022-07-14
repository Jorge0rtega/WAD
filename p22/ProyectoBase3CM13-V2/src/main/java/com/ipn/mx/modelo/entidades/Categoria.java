/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;

/**
 *
 * @author Jorge Ortega
 */
public class Categoria implements Serializable {
    private int idCategoria;
    private String nombreCategoria;
    private String DescripcionCategoria;

    public Categoria(){
        
    }
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return DescripcionCategoria;
    }

    public void setDescripcionCategoria(String DescripcionCategoria) {
        this.DescripcionCategoria = DescripcionCategoria;
    }
    

/*    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("idCategoria= ").append(idCategoria).append("\n");
        sb.append("nombreCategoria= ").append(nombreCategoria).append("\n");
        sb.append("DescripcionCategoria= ").append(DescripcionCategoria).append("\n");
        return sb.toString();
    }*/
 
    
    
}
