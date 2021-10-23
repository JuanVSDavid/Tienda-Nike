package com.tiendanike.web.service;

import java.util.List;

import com.tiendanike.web.models.ventas;

public interface CustomSaleService {
    abstract public List<ventas> listOfSale();
    abstract public ventas saveSale(ventas sale);
    public abstract Long countSale();
}
