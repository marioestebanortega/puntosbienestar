package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.Puntosacumulados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface PuntosacumuladosRepository extends JpaRepository<Puntosacumulados, Long> {

    Optional<Puntosacumulados> findByIdpuntosacumulados(Long idpuntosacumulados);

    Optional<Puntosacumulados> findByIdentificacion(String identificacion);
    public Optional<Puntosacumulados> findByIdentificacionAndIdvigencia(String identificacion,Long idvigencia);

    Optional<Puntosacumulados> findByIdvigencia(Long idvigencia);

    @Query(value = "select COALESCE(SUM(puntos), 0)  from bienestar.puntosacumulados  where identificacion =:cedula", nativeQuery = true)
    BigDecimal obtenerPuntosAcumulados(@Param("cedula") String cedula);

}

