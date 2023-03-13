
package com.Tienda.service;

import com.Tienda.dao.CategoriaDao;
import com.Tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Silvinha
 */
@Service// es el que se encarga de reconocer los metodos, sin saltos de linea
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    CategoriaDao categoriaDao;
    
    
    @Override
    @Transactional(readOnly=true) //para manejar trasacciones de solo lectura
    public List<Categoria> getCategorias(boolean activos) {
       var lista = (List<Categoria>)categoriaDao.findAll();
        
        if(activos){
            lista.removeIf(e -> !e.isActivo());
            
        }
        
        return lista;
    }

    @Override
    @Transactional(readOnly=true) //para manejar trasacciones de solo lectura
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional //los de modificacion solo se usa transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria); // con un save puedo modificar tambien
    }

    @Override
    @Transactional  
    public void delete(Categoria categoria) {
        categoriaDao.deleteById(categoria.getIdCategoria());
    }
    
    
    
}