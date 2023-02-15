
package com.Tienda.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class cliente {
    
    private  static final long serialVersionUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente; //transforma en id_cliente
    String name;
    String apellido;
    String correo;
    String telefono;
    
    
    public cliente(){
    }

    public cliente(String name, String apellido, String correo, String telefono) {
        this.name = name;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    
    
    
}
