package com.tiendanike.web.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class detalle_venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_detalle_venta;

    private Integer cantidad_producto;

    @ManyToOne
    @JoinColumn(name = "codigo_producto") // product_id
    private productos productos;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "codigo_venta")
    private ventas ventas;

    private Double valor_total;

    private Double valor_venta;

    private Double valor_iva;

    public detalle_venta() {
    }

    public detalle_venta(Long codigo_detalle_venta, Integer cantidad_producto,
            com.tiendanike.web.models.productos productos, com.tiendanike.web.models.ventas ventas, Double valor_total,
            Double valor_venta, Double valor_iva) {
        this.codigo_detalle_venta = codigo_detalle_venta;
        this.cantidad_producto = cantidad_producto;
        this.productos = productos;
        this.ventas = ventas;
        this.valor_total = valor_total;
        this.valor_venta = valor_venta;
        this.valor_iva = valor_iva;
    }

    public Long getCodigo_detalle_venta() {
        return codigo_detalle_venta;
    }

    public void setCodigo_detalle_venta(Long codigo_detalle_venta) {
        this.codigo_detalle_venta = codigo_detalle_venta;
    }

    public Integer getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(Integer cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public productos getProductos() {
        return productos;
    }

    public void setProductos(productos productos) {
        this.productos = productos;
    }

    public ventas getVentas() {
        return ventas;
    }

    public void setVentas(ventas ventas) {
        this.ventas = ventas;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public Double getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(Double valor_venta) {
        this.valor_venta = valor_venta;
    }

    public Double getValor_iva() {
        return valor_iva;
    }

    public void setValor_iva(Double valor_iva) {
        this.valor_iva = valor_iva;
    }

    @Override
    public String toString() {
        return "detalle_venta [cantidad_producto=" + cantidad_producto + ", codigo_detalle_venta="
                + codigo_detalle_venta + ", productos=" + productos + ", valor_iva=" + valor_iva + ", valor_total="
                + valor_total + ", valor_venta=" + valor_venta + ", ventas=" + ventas + "]";
    }

}
