package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.entity.Rol;
import com.bienestarapi.bienestarapi.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository RolRepository;

    public List<Rol> list(){

        return RolRepository.findAll();
    }

    public Optional<Rol> getOne(Long idrol){

        return RolRepository.findByIdrol(idrol);
    }

    public Optional<Rol> getByNombre(String nombre){

        return RolRepository.findByNombre(nombre);
    }

    public void save(Rol Rol){

        RolRepository.save(Rol);
    }
}
