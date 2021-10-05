package com.tiendanike.web.repository;

import com.tiendanike.web.models.proveedores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("proveedoresRepository")
public interface proveedoresRepository extends JpaRepository<proveedores,Long> {
}
