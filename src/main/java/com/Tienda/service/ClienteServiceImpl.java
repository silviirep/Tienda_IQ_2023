
package com.Tienda.service;

import com.Tienda.dao.clienteDao;
import com.Tienda.domain.cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service// es el que se encarga de reconocer los metodos, sin saltos de linea
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    clienteDao clienteDao;
    
    
    @Override
    @Transactional(readOnly=true) //para manejar trasacciones de solo lectura
    public List<cliente> getClientes() {
        return (List<cliente>)clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly=true) //para manejar trasacciones de solo lectura
    public cliente getCliente(cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional //los de modificacion solo se usa transactional
    public void save(cliente cliente) {
        clienteDao.save(cliente); // con un save puedo modificar tambien
    }

    @Override
    @Transactional  
    public void delete(cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());
    }
    
    
    
}
