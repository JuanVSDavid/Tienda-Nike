package com.tiendanike.web.repository;

import com.tiendanike.web.models.detalle_venta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("detalle_ventasRepository")
public interface detalle_ventasRepository extends JpaRepository<detalle_venta, Long>{
}
