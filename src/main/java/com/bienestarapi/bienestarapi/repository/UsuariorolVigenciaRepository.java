package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.UsuarioRolVigencia;
import com.bienestarapi.bienestarapi.entity.Usuariorol;
import com.bienestarapi.bienestarapi.entity.Vigencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariorolVigenciaRepository extends JpaRepository<UsuarioRolVigencia, Long>{
    @Query(value = "select puntos from usuariorol_vigencia uv where idvigencia =:idVigencia and idusuariorol =:idUsarioRol", nativeQuery = true)
    Double obtenerPuntosPorUsuarioYVigencia(@Param("idVigencia") Integer idVigencia,@Param("idUsarioRol") Integer idUsarioRol);

}
