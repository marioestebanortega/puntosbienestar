package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.entity.Usuariorol;
import com.bienestarapi.bienestarapi.repository.UsuariorolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuariorolService {

    @Autowired
    UsuariorolRepository UsuariorolRepository;

    public List<Usuariorol> list(){

        return UsuariorolRepository.findAll();
    }

    public Optional<Usuariorol> getOne(Long idusuariorol){

        return UsuariorolRepository.findByIdusuariorol(idusuariorol);
    }

    public Optional<Usuariorol> getByIdentificacion(String identificacion){

        return UsuariorolRepository.findByIdentificacion(identificacion);
    }

    public Optional<Usuariorol> getByIdrol(Long idrol){

        return UsuariorolRepository.findByIdrol(idrol);
    }

    public void save(Usuariorol Usuariorol){

        UsuariorolRepository.save(Usuariorol);
    }
}
