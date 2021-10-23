package com.tiendanike.web.service;

import com.tiendanike.web.models.detalle_venta;
import com.tiendanike.web.repository.detalle_ventasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("detalle_ventaService")
public class CustomSaleDetailsServiceImplements implements CustomSaleDetailsService {

    @Autowired
    @Qualifier("detalle_ventasRepository")
    private detalle_ventasRepository dvr;

    @Override
    public detalle_venta saveSaleDetails(detalle_venta detalle_ventas) {
        return dvr.save(detalle_ventas);
    }
}