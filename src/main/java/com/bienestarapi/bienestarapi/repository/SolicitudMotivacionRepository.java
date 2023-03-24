package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.SolicitudMotivacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SolicitudMotivacionRepository extends JpaRepository<SolicitudMotivacion, Long> {

    @Query(value = "SELECT COALESCE(SUM(COALESCE(sm.valor,0)), 0) + COALESCE(SUM(COALESCE(mv.valor,0)), 0) as total FROM solicitud_motivacion sm, motivacion_vigencia mv   WHERE sm.motivacion_vigencia_id = mv.id  AND sm.documento = :idUser AND mv.idvigencia = :idVigencia", nativeQuery = true)
    public Double obtenerAcumulado(@Param("idVigencia") Integer idVigencia,@Param("idUser") String idUser);

    @Query(value = "select * from solicitud_motivacion where documento =:documento", nativeQuery = true)
    public List<SolicitudMotivacion> findByDocumento(@Param("documento") String documento);
}