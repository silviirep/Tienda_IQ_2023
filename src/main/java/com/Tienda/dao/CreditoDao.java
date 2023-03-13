package com.Tienda.dao;

import com.Tienda.domain.Credito;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Silvinha
 */
public interface CreditoDao extends CrudRepository < Credito, Long> {
    
}
