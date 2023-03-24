package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.entity.Alternativa;
import com.bienestarapi.bienestarapi.repository.AlternativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AlternativaService {

    @Autowired
    AlternativaRepository alternativaRepository;

    public List<Alternativa> list(){

        return alternativaRepository.findAll();
    }

    public Optional<Alternativa> getOne(Long idalternativa){

        return alternativaRepository.findByIdalternativa(idalternativa);
    }

    public Optional<Alternativa> getByNombre(String nombre){

        return alternativaRepository.findByNombre(nombre);
    }

    public void save(Alternativa alternativa){

        alternativaRepository.save(alternativa);
    }
}
