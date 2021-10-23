package com.tiendanike.web.service;

import java.util.List;

import com.tiendanike.web.models.clientes;
import com.tiendanike.web.repository.clientesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("clientesService")
public class CustomClientServiceImplements implements CustomClientService{

    @Autowired
    @Qualifier("clientesRepository")
    public clientesRepository uc;

    @Override
    public List<clientes> listOfClients() {
        return uc.findAll();
    }

    @Override
    public clientes addCliente(clientes client) {
        if(!uc.existsById(client.getClient_cedula())){
            return uc.save(client);
        }
        return null;
    }

    @Override
    public clientes updateClient(clientes client) {
        if(uc.existsById(client.getClient_cedula())){
            return uc.save(client);
        }
        return null;
    }

    @Override
    public void deleteClient(long client_cedula) {
        uc.deleteById(client_cedula);
    }

    @Override
    public clientes findbyId(long client_cedula) {
        return uc.getById(client_cedula);
    }
    
}
