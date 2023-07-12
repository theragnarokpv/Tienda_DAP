/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Laboratorios
 */
@Service
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaAmpliada (double precioI, double precioS){
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioI, precioS);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaConJPQL(double precioI, double precioS){
        return productoDao.consultaConJPQL(precioI, precioS);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaConSQL(double precioI, double precioS){
        return productoDao.consultaConSQL(precioI, precioS);
    }
    
}
