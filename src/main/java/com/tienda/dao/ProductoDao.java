/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Laboratorios
 */
public interface ProductoDao extends JpaRepository <Producto, Long>{
    //Ejemplo de un metodo que hace una consulta ampliada de JPA
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioI, double precioS);

    //Ejemplo de método utilizando Consultas con JPQL
    @Query(value="SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> consultaConJPQL(double precioInf, double precioSup);
    
    @Query(nativeQuery=true, value="SELECT * FROM producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> consultaConSQL(double precioInf, double precioSup);
    
}
    
