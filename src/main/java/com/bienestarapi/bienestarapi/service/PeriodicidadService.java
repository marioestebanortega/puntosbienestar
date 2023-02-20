package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.entity.Periodicidad;
import com.bienestarapi.bienestarapi.repository.PeriodicidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PeriodicidadService {

    @Autowired
    PeriodicidadRepository PeriodicidadRepository;

    public List<Periodicidad> list(){

        return PeriodicidadRepository.findAll();
    }

    public Optional<Periodicidad> getOne(Long idperiodicidad){

        return PeriodicidadRepository.findByIdperiodicidad(idperiodicidad);
    }

    public Optional<Periodicidad> getByNombre(String nombre){

        return PeriodicidadRepository.findByNombre(nombre);
    }

    public void save(Periodicidad periodicidad){

        PeriodicidadRepository.save(periodicidad);
    }
}
