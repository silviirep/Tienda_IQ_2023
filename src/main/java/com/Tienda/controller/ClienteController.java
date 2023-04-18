package com.Tienda.controller;

import com.Tienda.dao.clienteDao;
import com.Tienda.domain.cliente;
import com.Tienda.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        var clientes = clienteService.getClientes();
        //var clientes= clienteService.getClienteApellidos("Mena Loria");
        //var clientes = Arrays.asList();
//        model.addAttribute("clientes", clientes);
//
//        return "/cliente/listado"; //todas las vistas que vamos a retornar están en templates
//    }

        var limiteTotal=0;
        for (var c: clientes) {
            limiteTotal+=c.getCredito().getLimite();
        }
        model.addAttribute("limiteTotal",limiteTotal);
        model.addAttribute("totalClientes",clientes.size());
        
        model.addAttribute("clientes",clientes);
        return "/cliente/listado";
    }

    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(cliente cliente) {
        return "/cliente/modificar";
    }

    @PostMapping("/cliente/guardar")
    public String guardarCliente(cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";  //un redirect no llama una vista si no que llamada al metodo del MVC

    }

    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }

    @RequestMapping(value = "cliente/consulta", method= RequestMethod.GET)
    public String consulta(@RequestParam (value= "apellidos", required =false) String apellidos, Model model){
        model.addAttribute("cliente", clienteService.consulta(apellidos));
        return "cliente/consulta";
    }
    
}
