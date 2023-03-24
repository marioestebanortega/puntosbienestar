package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.AlternativaVigencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlternativaVigenciaRepository extends JpaRepository<AlternativaVigencia, Integer> {

    @Query(value = "SELECT m.nombre, m.idalternativa,v.vigencia , v.idvigencia, mv.valor,mv.id  FROM alternativa_vigencia mv  RIGHT JOIN alternativa m ON mv.idalternativa = m.idalternativa  INNER JOIN vigencia v ON v.idvigencia = mv.idvigencia  WHERE mv.idvigencia=:idVigencia", nativeQuery = true)
    List<Object[]> getAlternativaesConValor(@Param("idVigencia") Integer idVigencia);

    @Query(value = "SELECT m.nombre ,m.idalternativa from alternativa m ", nativeQuery = true)
    List<Object[]> getAlternativaesConValor2();
}
