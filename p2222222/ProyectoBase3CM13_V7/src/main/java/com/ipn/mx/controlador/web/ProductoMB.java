/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador.web;


import com.ipn.mx.modelo.dao.CategoriaDAO;
import com.ipn.mx.modelo.dao.ProductoDAO;
import com.ipn.mx.modelo.entidades.Categoria;
import com.ipn.mx.modelo.entidades.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Jorge Ortega
 */
@ManagedBean(name = "productoMB")
@SessionScoped
public class ProductoMB extends BaseBean implements Serializable {
    private final ProductoDAO dao= new ProductoDAO();
    private final CategoriaDAO catDAO= new CategoriaDAO();
    private Producto dto;
    private List<Producto> listaProducto;
    private List<Categoria> listaCategoria;
    
    /**
     * Creates a new instance of ProductoMB
     */
    public ProductoMB() {
    }

    public Producto getDto() {
        return dto;
    }

    public void setDto(Producto dto) {
        this.dto = dto;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public List<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
    
    @PostConstruct
    public void init(){
        listaCategoria= new ArrayList<>();
        listaProducto= new ArrayList<>();
        
        listaCategoria= catDAO.readAll();
        listaProducto= dao.readAll();
        
    }
    
    public String prepareAdd(){
        dto=new Producto();
        setAccion(ACC_CREAR);
        return "/producto/productoForm?faces-redirect=true";
    }
    public String prepareUpdate(){
        setAccion(ACC_ACTUALIZAR);
        return "/producto/productoForm?faces-redirect=true";
    }
    
    public String prepareIndex(){
        init();
        return "/producto/listadoProductos?faces-redirect=true";
    }
    
    public Boolean validate(){
        boolean valido=true;//este se pondra true ya que no se hacen las validaciones pero debe ser false y segun las validaciones cambiarlo a verdadero 
        //validaciones de que si el producto existe se debe crear etc
        //hacer las validaciones con producto y categoria eso entendi aunque dijo con los tres que tengamos
        //if(dto.getNombreProducto()!=null){
            
        //}
        return valido;
    }
    
    public String add(){
        Boolean valido=validate();
        if(valido){
            Categoria cat=new Categoria();
            cat.setIdCategoria(dto.getIdCat());
            cat=catDAO.read(cat);
            dto.setIdCategoria(cat);
            dao.create(dto);
            if(valido){
                return prepareIndex();
        
            }else{
                return prepareAdd();
            }
        }
        return prepareAdd();
    }
    public String update(){
        Boolean valido=validate();
        if(valido){Categoria cat=new Categoria();
            cat.setIdCategoria(dto.getIdCat());
            cat=catDAO.read(cat);
            dto.setIdCategoria(cat);
            dao.update(dto);
            if(valido){
                return prepareIndex();
        
            }else{
                return prepareUpdate();
            }
        }
        return prepareUpdate();
    }
    public String delete(){
        dao.delete(dto);
        return prepareIndex();
    }
    
    public void seleccionarProducto(ActionEvent event){
        String claveSel = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("claveSel");
        dto= new Producto();
        dto.setIdProducto(Integer.parseInt(claveSel));
        try {
            dto=dao.read(dto);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
