package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.entity.Motivacion;
import com.bienestarapi.bienestarapi.repository.MotivacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MotivacionService {

    @Autowired
    MotivacionRepository motivacionRepository;

    public List<Motivacion> list(){

        return motivacionRepository.findAll();
    }

    public Optional<Motivacion> getOne(Long idmotivacion){

        return motivacionRepository.findByIdmotivacion(idmotivacion);
    }

    public Optional<Motivacion> getByNombre(String nombre){

        return motivacionRepository.findByNombre(nombre);
    }

    public void save(Motivacion motivacion){

        motivacionRepository.save(motivacion);
    }
}
