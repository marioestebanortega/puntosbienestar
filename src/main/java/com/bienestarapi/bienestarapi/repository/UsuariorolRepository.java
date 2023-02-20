package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.Usuariorol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariorolRepository extends JpaRepository<Usuariorol, Long>{

    Optional<Usuariorol> findByIdusuariorol(Long idusuariorol);
    Optional<Usuariorol> findByIdentificacion(String identificacion);
    Optional<Usuariorol> findByIdrol(Long idrol);
}
