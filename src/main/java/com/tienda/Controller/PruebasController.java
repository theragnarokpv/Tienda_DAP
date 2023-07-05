/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.Controller;

import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import com.tienda.service.ProductoService;
import com.tienda.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Laboratorios
 */
@Controller
@RequestMapping("/pruebas")
public class PruebasController {
    
@Autowired
private ProductoService productoService;

@Autowired
private CategoriaService categoriaService;

@GetMapping("/listado")
public String listado(Model model){
    var productos = productoService.getProductos(false);
    model.addAttribute("productos", productos);
    var categorias = categoriaService.getCategorias(false);
    model.addAttribute("categorias", categorias);
    model.addAttribute("totalProductos", productos.size());
    
    return "/pruebas/listado";
}


    @GetMapping("/listado/{idCategoria}")
    public String listado(Categoria categoria, Model model) {
        var productos = categoriaService.getCategoria(categoria).getProductos();
        model.addAttribute("productos", productos);
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalProductos", productos.size());
        return "/pruebas/listado";
    }
    
}
