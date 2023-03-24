package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.MotivacionVigencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MotivacionVigenciaRepository extends JpaRepository<MotivacionVigencia, Integer> {

    @Query(value = "SELECT m.nombre, m.idmotivacion,v.vigencia , v.idvigencia, mv.valor,mv.id  FROM motivacion_vigencia mv  RIGHT JOIN motivacion m ON mv.idmotivacion = m.idmotivacion  INNER JOIN vigencia v ON v.idvigencia = mv.idvigencia  WHERE mv.idvigencia=:idVigencia", nativeQuery = true)
    List<Object[]> getMotivacionesConValor(@Param("idVigencia") Integer idVigencia);

    @Query(value = "SELECT m.nombre ,m.idmotivacion from motivacion m ", nativeQuery = true)
    List<Object[]> getMotivacionesConValor2();
}
