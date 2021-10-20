package com.tiendanike.web.repository;

import com.tiendanike.web.models.ventas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("ventasRepository")
public interface ventasRepository extends JpaRepository<ventas, Long> {
    
}
