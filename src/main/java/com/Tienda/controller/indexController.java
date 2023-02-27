
package com.Tienda.controller;

import com.Tienda.dao.clienteDao;
import com.Tienda.domain.cliente;
import com.Tienda.service.ClienteService;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; //nos permite tener notacion de controlador
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; 

/**
 *
 * @author Silvinha
 */

@Slf4j //esto es de lombok
@Controller
public class indexController {
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/") //detallaremos que tipo de mapping es cada uno, dentro de parentesis vendra el recurso que solicitamos
    public String inicio(Model model) {
        log.info("Ahora utilizando MVC"); //Loguear informacion o pistas de donde va el programa, pero se puede crear bitacoras
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
        var clientes= clienteService.getClientes();
       //var clientes = Arrays.asList();
            model.addAttribute("clientes", clientes);
            
            
        
        return "index"; //todas las vistas que vamos a retornar están en templates
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(cliente cliente){
        return "modificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";  //un redirect no llama una vista si no que llamada al metodo del MVC
        
    }
    
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(cliente cliente, Model model){
        cliente= clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }
    
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/";
    }
    
}
