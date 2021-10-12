package com.tiendanike.web.repository;

import com.tiendanike.web.models.productos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("productosRepository")
public interface productosRepository extends JpaRepository<productos, Long>{
    
}
