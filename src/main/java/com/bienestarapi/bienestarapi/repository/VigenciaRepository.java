package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.Vigencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface VigenciaRepository extends JpaRepository<Vigencia, Long>{

    Optional<Vigencia> findByIdvigencia(Long idvigencia);
    Optional<Vigencia> findByVigencia(String vigencia);
}
