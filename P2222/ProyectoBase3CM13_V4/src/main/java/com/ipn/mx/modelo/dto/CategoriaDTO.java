/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Categoria;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Jorge Ortega
 */
@Data
@AllArgsConstructor
public class CategoriaDTO implements Serializable{
    private Categoria entidad;
    
    public CategoriaDTO(){
        entidad = new Categoria();
    }
}
