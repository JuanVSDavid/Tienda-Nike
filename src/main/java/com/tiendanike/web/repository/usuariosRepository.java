package com.tiendanike.web.repository;

import com.tiendanike.web.models.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("usuariosRepository")
public interface usuariosRepository extends JpaRepository<usuarios, Long>{
}