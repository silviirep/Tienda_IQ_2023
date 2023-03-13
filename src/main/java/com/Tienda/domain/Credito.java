package com.Tienda.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Silvinha
 */
@Data  //obtener los get y set automaticos
@Entity
@Table(name = "credito")
public class Credito implements Serializable {
    //el serializable ayuda a convertir los archivos en JSON o algun otro
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credito") //Permite indicar con cual campo de la base de datos se va a mapear
    private Long idCredito; //transforma en id_credito
    private double limite;

    public Credito() {
        //constructor base
    }

    public Credito(double limite) {
        this.limite = limite;  //no se crea con el id porque en la BD está autoincremental, por lo tanto es la BD la que determina el id
    }
}
