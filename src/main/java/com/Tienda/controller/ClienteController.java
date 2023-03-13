package com.Tienda.controller;

import com.Tienda.domain.cliente;
import com.Tienda.service.ClienteService;
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
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        log.info("Ahora utilizando MVC"); 
        var clientes= clienteService.getClientes();
       //var clientes = Arrays.asList();
            model.addAttribute("clientes", clientes);

        return "/cliente/listado"; //todas las vistas que vamos a retornar están en templates
    }
    
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(cliente cliente){
        return "/cliente/modificar";
    }
    
    @PostMapping("/cliente/guardar")
    public String guardarCliente(cliente cliente){
        clienteService.save(cliente);
        return "redirect:/cliente/listado";  //un redirect no llama una vista si no que llamada al metodo del MVC
        
    }
    
    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(cliente cliente, Model model){
        cliente= clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }
    
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
    
}
