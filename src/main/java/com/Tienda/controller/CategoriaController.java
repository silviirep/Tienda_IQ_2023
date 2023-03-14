
package com.Tienda.controller;

import com.Tienda.domain.Categoria;
import com.Tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Silvinha
 */
@Controller
public class CategoriaController {
    
    @Autowired
    CategoriaService categoriaService;
    
    @GetMapping("/categoria/listado") //detallaremos que tipo de mapping es cada uno, dentro de parentesis vendra el recurso que solicitamos
    public String inicio(Model model) { //Loguear informacion o pistas de donde va el programa, pero se puede crear bitacoras
        //en BD 
//        String fecha = new Date().toString();
//        String mensaje="Estamos en semana 4, Saludos";
//        model.addAttribute("MensajeSaludo", mensaje);
//        model.addAttribute("fecha", fecha);
//        
//        cliente cliente= new cliente("Silvia", "peralta", "silviirep@hotmail.com", "72546348");
//        cliente cliente2= new cliente("Marco", "hidalgo", "marcohidalgo@hotmail.com", "725434348");
//        model.addAttribute("cliente", cliente);
//        model.addAttribute("cliente2", cliente2);
        
        //List<cliente> clientes = Arrays.asList(cliente, cliente2); //var es cuando no se sabe el tipo de variable que es 
        var categorias= categoriaService.getCategorias(false);
       //var clientes = Arrays.asList();
            model.addAttribute("categorias", categorias);
            
            
        
        return "/categoria/listado"; //todas las vistas que vamos a retornar están en templates
    }
    
    @GetMapping("/categoria/nuevo")
    public String nuevaCategoria(Categoria categoria){
        return "/categoria/modificar";
    }
    
    @PostMapping("/categoria/guardar")
    public String guardarCategoria(Categoria categoria){
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";  //un redirect no llama una vista si no que llamada al metodo del MVC
        
    }
    
    @GetMapping("/categoria/modificar/{idCategoria}")
    public String modificarCliente(Categoria categoria, Model model){
        categoria= categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modificar";
    }
    
    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String eliminarCategoria(Categoria categoria){
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
    
}
