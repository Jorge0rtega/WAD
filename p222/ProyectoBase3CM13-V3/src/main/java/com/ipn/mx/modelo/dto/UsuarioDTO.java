/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Usuario;
import java.io.Serializable;

/**
 *
 * @author Jorge Ortega
 */

public class UsuarioDTO implements Serializable {
    private Usuario entidad;
    public UsuarioDTO() {
        entidad=new Usuario();
    }

    public Usuario getEntidad() {
        return entidad;
    }

    public void setEntidad(Usuario entidad) {
        this.entidad = entidad;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IdUsuario: ").append(getEntidad().getIdUsuario()).append("\n");
        sb.append("Nombre: ").append(getEntidad().getNombre()).append("\n");
        sb.append("Paterno: ").append(getEntidad().getPaterno()).append("\n");
        sb.append("Materno: ").append(getEntidad().getMaterno()).append("\n");
        sb.append("Email: ").append(getEntidad().getEmail()).append("\n");
        sb.append("Nombre Usuario: ").append(getEntidad().getNombreUsuario()).append("\n");
        sb.append("Clave Usuario: ").append(getEntidad().getClaveUsuario()).append("\n");
        sb.append("Tipo Usuario: ").append(getEntidad().getTipoUsuario()).append("\n");
        
        
        return sb.toString();
    }

    
}
