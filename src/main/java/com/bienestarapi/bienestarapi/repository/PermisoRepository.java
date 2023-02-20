package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Long>{

    Optional<Permiso> findByIdpermiso(Long idpermiso);
    Optional<Permiso> findByIdentificacion(String identificacion);
    Optional<Permiso> findByIdvigencia(Long idvigencia);
    Optional<Permiso> findByFecharadicacion(String fecharadicacion);
}
