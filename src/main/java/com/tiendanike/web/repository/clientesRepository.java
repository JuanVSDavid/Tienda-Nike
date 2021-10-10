package com.tiendanike.web.repository;

import com.tiendanike.web.models.clientes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("clientesRepository")
public interface clientesRepository extends JpaRepository<clientes, Long> {
    
}
