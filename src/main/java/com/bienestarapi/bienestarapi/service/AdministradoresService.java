package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.entity.Administradores;
import com.bienestarapi.bienestarapi.repository.AdministradoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AdministradoresService {

    @Autowired
    private AdministradoresRepository administradoresRepository;


    public boolean esAdministrador(String documento){
        Optional<Administradores> administradores=administradoresRepository.findByDocumento(documento);
        return administradores.isPresent();
    }
}
