package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.entity.Tipopermiso;
import com.bienestarapi.bienestarapi.repository.TipopermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipopermisoService {

    @Autowired
    TipopermisoRepository TipopermisoRepository;

    public List<Tipopermiso> list(){

        return TipopermisoRepository.findAll();
    }

    public Optional<Tipopermiso> getOne(Long idtipopermiso){

        return TipopermisoRepository.findByIdtipopermiso(idtipopermiso);
    }

    public Optional<Tipopermiso> getByNombre(String nombre){

        return TipopermisoRepository.findByNombre(nombre);
    }

    public void save(Tipopermiso tipopermiso){

        TipopermisoRepository.save(tipopermiso);
    }
}
