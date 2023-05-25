package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.Administradores;
import com.bienestarapi.bienestarapi.entity.ConfiguracionesVigencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AdministradoresRepository extends JpaRepository<Administradores, Integer> {
    Optional<Administradores> findByDocumento(String documento);
}
