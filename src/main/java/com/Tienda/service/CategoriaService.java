
package com.Tienda.service;

import com.Tienda.domain.Categoria;
import java.util.List;

/**
 *
 * @author Silvinha
 */
public interface CategoriaService {
    
    //define un contrato
    
    public List<Categoria> getCategorias(boolean activos); //acá se recibe un parametro para las categorias que esten activas
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save(Categoria categoria); //la idea es que siempre sean booleanos, pero de momento se van a trabajar vacios
    //el save va a servir para modificar como insertar un registro
    
    public void delete(Categoria categoria);
}
