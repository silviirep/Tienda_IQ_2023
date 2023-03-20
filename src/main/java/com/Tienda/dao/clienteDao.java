
package com.Tienda.dao;

import com.Tienda.domain.cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Silvinha
 */
public interface clienteDao extends CrudRepository<cliente, Long> {
//    List<cliente> findByCorreo(String correo);
    List<cliente> findByApellidos(String apellidos);
    
    
    
}
