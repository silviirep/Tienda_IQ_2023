
package com.Tienda.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data //nos permite crear los set y get de forma dinamica
@Entity
@Table("cliente")
public class cliente {
    
    private  static final long serialVersionUID =1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    String nombre;
    String apellido;
    String correo;
    String telefono;
    
    
    public cliente(){
    }

    public cliente(String nombre, String apellido, String correo, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    } 
}
