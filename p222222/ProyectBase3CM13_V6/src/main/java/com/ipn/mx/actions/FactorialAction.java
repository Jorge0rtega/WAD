/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.actions;

/**
 *
 * @author Jorge Ortega
 */
public class FactorialAction {

    private int resultado=5;
    public String execute(){
        getResultado();
        return "success";
    }
    
    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
