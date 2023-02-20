package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.entity.Permisoacademico;
import com.bienestarapi.bienestarapi.repository.PermisoacademicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PermisoacademicoService {

    @Autowired
    PermisoacademicoRepository PermisoacademicoRepository;

    public List<Permisoacademico> list(){

        return PermisoacademicoRepository.findAll();
    }

    public Optional<Permisoacademico> getOne(Long idpermisoacademico){

        return PermisoacademicoRepository.findByIdpermisoacademico(idpermisoacademico);
    }

    public Optional<Permisoacademico> getByIdpermiso(Long idpermiso){

        return PermisoacademicoRepository.findByIdpermiso(idpermiso);
    }

    public long save(Permisoacademico Permisoacademico){

        return PermisoacademicoRepository.save(Permisoacademico).getIdpermisoacademico();
    }
}
