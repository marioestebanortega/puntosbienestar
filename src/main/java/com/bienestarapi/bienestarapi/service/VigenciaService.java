package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.entity.Vigencia;
import com.bienestarapi.bienestarapi.repository.VigenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VigenciaService {

    @Autowired
    VigenciaRepository VigenciaRepository;

    public List<Vigencia> list(){

        return VigenciaRepository.findAll();
    }

    public Optional<Vigencia> getOne(Long idvigencia){

        return VigenciaRepository.findByIdvigencia(idvigencia);
    }

    public Optional<Vigencia> getByVigencia(String vigencia){

        return VigenciaRepository.findByVigencia(vigencia);
    }

    public Optional<Vigencia> getAcutal(){
        return VigenciaRepository.findActual();
    }

    public void save(Vigencia Vigencia){

        VigenciaRepository.save(Vigencia);
    }
}
