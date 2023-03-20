package com.Tienda.service;

import com.Tienda.dao.CreditoDao;
import com.Tienda.dao.clienteDao;
import com.Tienda.domain.Credito;
import com.Tienda.domain.cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Silvinha
 */
@Service// es el que se encarga de reconocer los metodos, sin saltos de linea
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    clienteDao clienteDao;

    @Autowired
    CreditoDao creditoDao;

    @Override
    @Transactional(readOnly = true) //para manejar trasacciones de solo lectura
    public List<cliente> getClientes() {
        return (List<cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true) //para manejar trasacciones de solo lectura
    public cliente getCliente(cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional //los de modificacion solo se usa transactional
    public void save(cliente cliente) { //cliente tiene su idCliente= 0 y credito tiene idCredito que va a tener un limite, para setear el credito debe primero salvarlo y pueda realizar el cambio
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);
        cliente.setCredito(credito);
        clienteDao.save(cliente); // con un save puedo modificar tambien
    }

    @Override
    @Transactional
    public void delete(cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());
    }
    
    @Override
    public List<cliente> consulta(String apellidos) {
        return (List<cliente>) clienteDao.findByApellidos(apellidos);
    }

}
