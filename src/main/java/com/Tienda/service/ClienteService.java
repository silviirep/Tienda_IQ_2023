
package com.Tienda.service;

import com.Tienda.dao.clienteDao;
import com.Tienda.domain.cliente;
import java.util.List;

/**
 *
 * @author Silvinha
 */
public interface ClienteService {
    
    //define un contrato
    
    public List<cliente> getClientes(); //la firma de un metodo
    
//    public List<cliente> findByApellidos(String apellidos);
    
    
    public cliente getCliente(cliente cliente);
    
    public void save(cliente cliente); //la idea es que siempre sean booleanos, pero de momento se van a trabajar vacios
    //el save va a servir para modificar como insertar un registro
    
    public void delete(cliente cliente);
//    
    public List<cliente> consulta(String apellidos);


}



