/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Tienda.controller;


import com.Tienda.domain.cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class indexController {

    
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Ahora utilizando MVC");
        String mensaje="Estamos en semana 4, saludos!";
        model.addAttribute("mensajeSaludo", mensaje);
            
        
        cliente cliente= new cliente("Silvia", "Peralta", "silviirep@hotmail.com", "72546348");
        model.addAttribute("cliente", cliente);
        return "index";
    }
    
}
