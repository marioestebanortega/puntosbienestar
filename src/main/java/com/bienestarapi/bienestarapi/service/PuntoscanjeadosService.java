package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.entity.Puntoscanjeados;
import com.bienestarapi.bienestarapi.repository.PuntoscanjeadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PuntoscanjeadosService {

    @Autowired
    PuntoscanjeadosRepository PuntoscanjeadosRepository;

    public List<Puntoscanjeados> list(){

        return PuntoscanjeadosRepository.findAll();
    }

    public Optional<Puntoscanjeados> getOne(Long idpuntoscanjeados){

        return PuntoscanjeadosRepository.findByIdpuntoscanjeados(idpuntoscanjeados);
    }

    public Optional<Puntoscanjeados> getByIdentificacion(String identificacion){

        return PuntoscanjeadosRepository.findByIdentificacion(identificacion);
    }

    public Optional<Puntoscanjeados> getByFecharadica(String fecharadica){

        return PuntoscanjeadosRepository.findByFecharadica(fecharadica);
    }

    public Optional<Puntoscanjeados> getByIdvigencia(Long idvigencia){

        return PuntoscanjeadosRepository.findByIdvigencia(idvigencia);
    }

    public void save(Puntoscanjeados Puntoscanjeados){

        PuntoscanjeadosRepository.save(Puntoscanjeados);
    }
}
