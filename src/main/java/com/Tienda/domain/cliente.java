package com.Tienda.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente; //transforma en id_cliente

    String nombre;
    String apellidos;
    String correo;
    String telefono;

    @JoinColumn(name = "id_credito", referencedColumnName = "id_credito")
    @ManyToOne
    
    private Credito credito;

    public cliente() {
    }

    public cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }
}
