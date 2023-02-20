package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.Periodicidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PeriodicidadRepository extends JpaRepository<Periodicidad, Long>{

    Optional<Periodicidad> findByIdperiodicidad(Long idperiodicidad);
    Optional<Periodicidad> findByNombre(String nombre);

}
