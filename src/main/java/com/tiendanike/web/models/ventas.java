package com.tiendanike.web.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_ventas;

    @OneToMany(mappedBy = "ventas")
    private List<detalle_venta> detalle_venta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cedula_cliente") // client_cedula
    private clientes clientes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cedula_usuario") // user_cedula
    private usuarios usuarios;

    private Double iva_venta;

    private Double total_venta;

    private Double valor_venta;

    public ventas() {
    }

    public ventas(Long codigo_ventas, List<com.tiendanike.web.models.detalle_venta> detalle_venta,
            com.tiendanike.web.models.clientes clientes, com.tiendanike.web.models.usuarios usuarios, Double iva_venta,
            Double total_venta, Double valor_venta) {
        this.codigo_ventas = codigo_ventas;
        this.detalle_venta = detalle_venta;
        this.clientes = clientes;
        this.usuarios = usuarios;
        this.iva_venta = iva_venta;
        this.total_venta = total_venta;
        this.valor_venta = valor_venta;
    }

    public Long getCodigo_ventas() {
        return codigo_ventas;
    }

    public void setCodigo_ventas(Long codigo_ventas) {
        this.codigo_ventas = codigo_ventas;
    }

    public List<detalle_venta> getDetalle_venta() {
        return detalle_venta;
    }

    public void setDetalle_venta(List<detalle_venta> detalle_venta) {
        this.detalle_venta = detalle_venta;
    }

    public clientes getClientes() {
        return clientes;
    }

    public void setClientes(clientes clientes) {
        this.clientes = clientes;
    }

    public usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Double getIva_venta() {
        return iva_venta;
    }

    public void setIva_venta(Double iva_venta) {
        this.iva_venta = iva_venta;
    }

    public Double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(Double total_venta) {
        this.total_venta = total_venta;
    }

    public Double getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(Double valor_venta) {
        this.valor_venta = valor_venta;
    }

    @Override
    public String toString() {
        return "ventas [clientes=" + clientes + ", codigo_ventas=" + codigo_ventas + ", detalle_venta=" + detalle_venta
                + ", iva_venta=" + iva_venta + ", total_venta=" + total_venta + ", usuarios=" + usuarios
                + ", valor_venta=" + valor_venta + "]";
    }

}
