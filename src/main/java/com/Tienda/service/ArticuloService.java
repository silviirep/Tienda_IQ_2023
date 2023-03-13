
package com.Tienda.service;

import com.Tienda.domain.Articulo;
import com.Tienda.domain.Articulo;
import java.util.List;

/**
 *
 * @author Silvinha
 */
public interface ArticuloService {
    
//define un contrato
    
    public List<Articulo> getArticulos(boolean activos); //la firma de un metodo
    
    public Articulo getArticulo(Articulo articulo);
    
    public void save(Articulo articulo); //la idea es que siempre sean booleanos, pero de momento se van a trabajar vacios
    //el save va a servir para modificar como insertar un registro
    
    public void delete(Articulo Articulo);
    
}
