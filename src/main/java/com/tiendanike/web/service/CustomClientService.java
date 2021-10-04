package com.tiendanike.web.service;

import java.util.List;

import com.tiendanike.web.models.clientes;

public interface CustomClientService {
    public abstract List<clientes> listOfClients();
    public abstract clientes addCliente(clientes client);
    public abstract clientes updateClient(clientes client);
    public abstract void deleteClient(long client_cedula);
}
