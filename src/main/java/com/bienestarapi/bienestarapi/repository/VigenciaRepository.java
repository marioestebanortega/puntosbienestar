package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.Vigencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface VigenciaRepository extends JpaRepository<Vigencia, Integer>{

    Optional<Vigencia> findByIdvigencia(Long idvigencia);
    Optional<Vigencia> findByVigencia(String vigencia);
    @Query("SELECT v FROM Vigencia v WHERE CURRENT_DATE BETWEEN v.fechaini AND v.fechafin")
    Optional<Vigencia> findActual();
}
