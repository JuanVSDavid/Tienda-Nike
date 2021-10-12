package com.tiendanike.web.service;

import java.util.List;

import com.tiendanike.web.models.proveedores;
import com.tiendanike.web.repository.proveedoresRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("proveedoresService")
public class CustomSupplierServiceImplements implements CustomSupplierService {

    @Autowired
    @Qualifier("proveedoresRepository")
    private proveedoresRepository pr;


    @Override
    public List<proveedores> listOfSupplier() {
        return pr.findAll();
    }

    @Override
    public proveedores addSupplier(proveedores supplier) {
        if(!pr.existsById(supplier.getSupplier_nit())){
            return pr.save(supplier);
        }
        return null;
    }

    @Override
    public proveedores updateSupplier(proveedores supplier) {
        if(pr.existsById(supplier.getSupplier_nit())){
            return pr.save(supplier);
        }
        return null;
    }

    @Override
    public void deleteSupplier(long supplier_nit) {
        pr.deleteById(supplier_nit);
    }

    @Override
    public proveedores searchSupplier(long supplier_nit) {
        if(pr.existsById(supplier_nit)){
            return pr.getById(supplier_nit);
        }
        return null;
    }
    
}
