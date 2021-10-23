package com.tiendanike.web.repository;

import com.tiendanike.web.models.ventas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository("ventasRepository")
public interface ventasRepository extends JpaRepository<ventas, Long> {
    @Query(value =  "SELECT COUNT(*) FROM detalle_venta", nativeQuery = true)
    public long count();
}
