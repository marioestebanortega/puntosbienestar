package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.Tipopermiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipopermisoRepository extends JpaRepository<Tipopermiso, Long>{

    Optional<Tipopermiso> findByIdtipopermiso(Long idtipopermiso);
    Optional<Tipopermiso> findByNombre(String nombre);

}
