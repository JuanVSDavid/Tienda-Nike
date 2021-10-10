package com.tiendanike.web.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class proveedores {
    @Id
    private long supplier_nit;

    private String supplier_name;
    private String supplier_tel;
    private String supplier_address;
    private String supplier_city;
    
    public long getSupplier_nit() {
        return supplier_nit;
    }
    public void setSupplier_nit(long supplier_nit) {
        this.supplier_nit = supplier_nit;
    }
    public String getSupplier_name() {
        return supplier_name;
    }
    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }
    public String getSupplier_tel() {
        return supplier_tel;
    }
    public void setSupplier_tel(String supplier_tel) {
        this.supplier_tel = supplier_tel;
    }
    public String getSupplier_address() {
        return supplier_address;
    }
    public void setSupplier_address(String supplier_address) {
        this.supplier_address = supplier_address;
    }
    public String getSupplier_city() {
        return supplier_city;
    }
    public void setSupplier_city(String supplier_city) {
        this.supplier_city = supplier_city;
    }
    @Override
    public String toString() {
        return "proveedores [supplier_address=" + supplier_address + ", supplier_city=" + supplier_city
                + ", supplier_name=" + supplier_name + ", supplier_nit=" + supplier_nit + ", supplier_tel="
                + supplier_tel + "]";
    }
    
}
