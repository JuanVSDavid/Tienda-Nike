package com.tiendanike.web.service;

import java.util.List;

import com.tiendanike.web.models.ventas;
import com.tiendanike.web.repository.ventasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ventaService")
public class CustomSaleServiceImplements implements CustomSaleService {

    @Autowired
    @Qualifier("ventasRepository")
    private ventasRepository vr;
    
    @Override
    public List<ventas> listOfSale() {
        return vr.findAll();
    }

    @Override
    public ventas saveSale(ventas sale) {
        return vr.save(sale);
    }
    
}