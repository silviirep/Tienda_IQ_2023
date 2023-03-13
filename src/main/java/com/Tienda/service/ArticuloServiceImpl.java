package com.Tienda.service;

import com.Tienda.dao.ArticuloDao;
import com.Tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Silvinha
 */
@Service// es el que se encarga de reconocer los metodos, sin saltos de linea
public class ArticuloServiceImpl implements ArticuloService{

    @Autowired
    ArticuloDao articuloDao;
    
    
    @Override
    @Transactional(readOnly=true) //para manejar trasacciones de solo lectura
    public List<Articulo> getArticulos(boolean activos) {
       var lista = (List<Articulo>)articuloDao.findAll();
        
        if(activos){
            lista.removeIf(e -> !e.isActivo());
            
        }
        
        return lista;
    }

    @Override
    @Transactional(readOnly=true) //para manejar trasacciones de solo lectura
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional //los de modificacion solo se usa transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo); // con un save puedo modificar tambien
    }

    @Override
    @Transactional  
    public void delete(Articulo articulo) {
        articuloDao.deleteById(articulo.getIdArticulo());
    }
  
}
