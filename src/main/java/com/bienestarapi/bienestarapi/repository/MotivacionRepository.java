package com.bienestarapi.bienestarapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bienestarapi.bienestarapi.entity.Motivacion;
import java.util.Optional;

@Repository
public interface MotivacionRepository extends JpaRepository<Motivacion, Long>{

    Optional<Motivacion> findByIdmotivacion(Long idmotivacion);
    Optional<Motivacion> findByNombre(String nombre);

}
