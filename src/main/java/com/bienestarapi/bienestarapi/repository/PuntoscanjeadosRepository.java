package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.Puntoscanjeados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PuntoscanjeadosRepository extends JpaRepository<Puntoscanjeados, Long>{

    Optional<Puntoscanjeados> findByIdpuntoscanjeados(Long idpuntoscanjeados);
    Optional<Puntoscanjeados> findByIdentificacion(String identificacion);
    Optional<Puntoscanjeados> findByIdvigencia(Long idvigencia);
    Optional<Puntoscanjeados> findByFecharadica(String fecharadica);
}
