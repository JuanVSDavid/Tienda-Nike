package com.tiendanike.web.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class productos {
    @Id
    private long product_id;

    private String product_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_nit")
    private proveedores proveedores;
    
    private double product_price;
    private double product_sale_price;
    private double product_sale_iva;

    public productos() {
        
    }

    public productos(long product_id, String product_name, double product_price, double product_sale_price,
    double product_sale_iva, com.tiendanike.web.models.proveedores proveedores) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_sale_price = product_sale_price;
        this.product_sale_iva = product_sale_iva;
        this.proveedores = proveedores;
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

    public proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(proveedores proveedores) {
        this.proveedores = proveedores;
    }

    @Override
    public String toString() {
        return "productos [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
                + product_price + ", product_sale_iva=" + product_sale_iva + ", product_sale_price="
                + product_sale_price + ", proveedores=" + proveedores + "]";
    }
}
