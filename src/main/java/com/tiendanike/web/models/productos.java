package com.tiendanike.web.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class productos {
    @Id
    private long product_id;

    private String product_name;

    @OneToMany(mappedBy = "productos", fetch = FetchType.LAZY)
    private List<detalle_venta> ventas;

    @ManyToOne
    @JoinColumn(name = "supplier_nit")
    private proveedores proveedores;
    
    private double product_price;
    private double product_sale_price;
    private double product_sale_iva;

    public productos() {
        
    }

    public productos(long product_id, String product_name, List<detalle_venta> ventas,
            com.tiendanike.web.models.proveedores proveedores, double product_price, double product_sale_price,
            double product_sale_iva) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.ventas = ventas;
        this.proveedores = proveedores;
        this.product_price = product_price;
        this.product_sale_price = product_sale_price;
        this.product_sale_iva = product_sale_iva;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public List<detalle_venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<detalle_venta> ventas) {
        this.ventas = ventas;
    }

    public proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public double getProduct_sale_price() {
        return product_sale_price;
    }

    public void setProduct_sale_price(double product_sale_price) {
        this.product_sale_price = product_sale_price;
    }

    public double getProduct_sale_iva() {
        return product_sale_iva;
    }

    public void setProduct_sale_iva(double product_sale_iva) {
        this.product_sale_iva = product_sale_iva;
    }

    @Override
    public String toString() {
        return "productos [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
                + product_price + ", product_sale_iva=" + product_sale_iva + ", product_sale_price="
                + product_sale_price + ", proveedores=" + proveedores + ", ventas=" + ventas + "]";
    }

    
}
