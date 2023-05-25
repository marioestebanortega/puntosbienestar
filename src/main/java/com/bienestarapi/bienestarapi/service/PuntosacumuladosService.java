package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.entity.Puntosacumulados;
import com.bienestarapi.bienestarapi.repository.PuntosacumuladosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PuntosacumuladosService {

    @Autowired
    PuntosacumuladosRepository PuntosacumuladosRepository;

    public List<Puntosacumulados> list(){

        return PuntosacumuladosRepository.findAll();
    }

    public Optional<Puntosacumulados> getOne(Long idpuntosacumulados){

        return PuntosacumuladosRepository.findByIdpuntosacumulados(idpuntosacumulados);
    }

    public Optional<Puntosacumulados> getByIdentificacion(String identificacion){

        return PuntosacumuladosRepository.findByIdentificacion(identificacion);
    }
    public Optional<Puntosacumulados> getByIdentificacionAndVigencia(String identificacion,Long idVigencia){

        return PuntosacumuladosRepository.findByIdentificacionAndIdvigencia(identificacion,idVigencia);
    }


    public Optional<Puntosacumulados> getByIdvigencia(Long idvigencia){

        return PuntosacumuladosRepository.findByIdvigencia(idvigencia);
    }

    public void save(Puntosacumulados Puntosacumulados){

        PuntosacumuladosRepository.save(Puntosacumulados);
    }

    public BigDecimal obtenerPuntosAcumulados(String cedula){
        return PuntosacumuladosRepository.obtenerPuntosAcumulados(cedula);
    }


}
