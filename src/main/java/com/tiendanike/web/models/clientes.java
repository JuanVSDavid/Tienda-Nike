package com.tiendanike.web.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class clientes {
    @Id
    private Long client_cedula;
    private String client_address;
    private String client_email;
    private String client_name;
    private String client_tel;

    @OneToMany(mappedBy = "clientes", fetch = FetchType.LAZY)
    private List<ventas> ventas;

    public clientes() {

    }

    public clientes(Long client_cedula, String client_address, String client_email, String client_name,
            String client_tel, List<com.tiendanike.web.models.ventas> ventas) {
        this.client_cedula = client_cedula;
        this.client_address = client_address;
        this.client_email = client_email;
        this.client_name = client_name;
        this.client_tel = client_tel;
        this.ventas = ventas;
    }

    public Long getClient_cedula() {
        return client_cedula;
    }

    public void setClient_cedula(Long client_cedula) {
        this.client_cedula = client_cedula;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_tel() {
        return client_tel;
    }

    public void setClient_tel(String client_tel) {
        this.client_tel = client_tel;
    }

    public List<ventas> getVentas() {
        return ventas;
    }

    public void setVentas(List<ventas> ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "clientes [client_address=" + client_address + ", client_cedula=" + client_cedula + ", client_email="
                + client_email + ", client_name=" + client_name + ", client_tel=" + client_tel + ", ventas=" + ventas
                + "]";
    }

}
