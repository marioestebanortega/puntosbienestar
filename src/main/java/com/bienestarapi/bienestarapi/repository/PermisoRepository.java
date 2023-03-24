package com.bienestarapi.bienestarapi.repository;

import com.bienestarapi.bienestarapi.entity.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Integer>{

    Optional<Permiso> findByIdpermiso(Long idpermiso);
    Optional<Permiso> findByIdentificacion(String identificacion);
    Optional<Permiso> findByIdvigencia(Long idvigencia);
    Optional<Permiso> findByFecharadicacion(String fecharadicacion);
    //
    @Query(value = "select * from permiso p where idvigencia =:idVigencia and identificacion =:idUser", nativeQuery = true)
    List<Permiso> permisosPorVigenciaYUsuario(@Param("idVigencia") Integer idVigencia,@Param("idUser") String idUser);

}
