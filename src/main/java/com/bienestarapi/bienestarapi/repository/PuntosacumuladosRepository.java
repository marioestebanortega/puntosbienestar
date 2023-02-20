package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.Puntosacumulados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PuntosacumuladosRepository extends JpaRepository<Puntosacumulados, Long>{

    Optional<Puntosacumulados> findByIdpuntosacumulados(Long idpuntosacumulados);
    Optional<Puntosacumulados> findByIdentificacion(String identificacion);
    Optional<Puntosacumulados> findByIdvigencia(Long idvigencia);
    Optional<Puntosacumulados> findByFecharadica(String fecharadica);
}
