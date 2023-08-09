/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Laboratorios
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Item extends Producto{
    private int cantidad;

    public Item() {
    }

    public Item(Producto producto) {
        super(producto.idProducto, producto.descripcion, producto.detalle, producto.precio, producto.existencias, producto.rutaImagen, producto.activo, producto.categoria);
        cantidad=0;
    }

    
    
    
    
}
