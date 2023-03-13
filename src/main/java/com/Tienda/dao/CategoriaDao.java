package com.Tienda.dao;

import com.Tienda.domain.Categoria;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Silvinha
 */
public interface CategoriaDao extends CrudRepository<Categoria, Long> {
    
}
