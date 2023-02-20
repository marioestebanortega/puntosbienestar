package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.Permisoacademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermisoacademicoRepository extends JpaRepository<Permisoacademico, Long>{

    Optional<Permisoacademico> findByIdpermisoacademico(Long idpermisoacademico);
    Optional<Permisoacademico> findByIdpermiso(Long idpermiso);
}
