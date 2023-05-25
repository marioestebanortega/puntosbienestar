package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.ConfiguracionesVigencia;
import com.bienestarapi.bienestarapi.entity.Puntoscanjeados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ConfiguracionesInicialesRepository extends JpaRepository<ConfiguracionesVigencia, Integer> {
    Optional<ConfiguracionesVigencia> findByCodigoAndIdVigencia(String codigo,Integer idVigencia);
}
