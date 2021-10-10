package com.tiendanike.web.service;

import java.util.List;

import com.tiendanike.web.models.proveedores;

public interface CustomSupplierService {
    public abstract List<proveedores> listOfSupplier();
    public abstract proveedores addSupplier(proveedores supplier);
    public abstract proveedores updateSupplier(proveedores supplier);
    public abstract void deleteSupplier(long supplier_nit);
}
