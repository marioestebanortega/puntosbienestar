package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.entity.Permiso;
import com.bienestarapi.bienestarapi.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PermisoService {

    @Autowired
    PermisoRepository PermisoRepository;

    public List<Permiso> list(){

        return PermisoRepository.findAll();
    }

    public Optional<Permiso> getOne(Long idpermiso){

        return PermisoRepository.findByIdpermiso(idpermiso);
    }

    public Optional<Permiso> getByFecharadicacion(String fecharadicacion){

        return PermisoRepository.findByFecharadicacion(fecharadicacion);
    }

    public Optional<Permiso> getByIdentificacion(String identificacion){

        return PermisoRepository.findByIdentificacion(identificacion);
    }

    public Optional<Permiso> getByIdvigencia(Long idvigencia){

        return PermisoRepository.findByIdvigencia(idvigencia);
    }

    public long save(Permiso permiso){

        return PermisoRepository.save(permiso).getIdpermiso();
    }
}
