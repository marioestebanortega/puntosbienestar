package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.dto.MotivacionVigenciaDto;
import com.bienestarapi.bienestarapi.entity.Motivacion;
import com.bienestarapi.bienestarapi.entity.MotivacionVigencia;
import com.bienestarapi.bienestarapi.entity.Vigencia;
import com.bienestarapi.bienestarapi.repository.MotivacionRepository;
import com.bienestarapi.bienestarapi.repository.MotivacionVigenciaRepository;
import com.bienestarapi.bienestarapi.repository.VigenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class MotivacionVigenciaService {

    @Autowired
    private MotivacionVigenciaRepository motivacionVigenciaRepository;

    @Autowired
    private MotivacionRepository motivacionRepository;

    @Autowired
    private VigenciaRepository vigenciaRepository;


    public List<MotivacionVigenciaDto> guardarConfiguracionesMotivacionesPorVigencia(List<MotivacionVigenciaDto> confs) {
        List<MotivacionVigenciaDto> out=new ArrayList<>();
        if(confs!=null&&!confs.isEmpty()){
                 for (MotivacionVigenciaDto conf : confs) {
                     MotivacionVigencia  mv=null;
                     if(conf.getId()==null){
                        mv=new MotivacionVigencia();
                     }
                     else{
                         mv=motivacionVigenciaRepository.findById(conf.getId()).get();
                     }

                     Motivacion m=motivacionRepository.findById(conf.getIdmotivacion()).get();
                     Vigencia v=vigenciaRepository.findById(conf.getIdvigencia()).get();
                     mv.setMotivacion(m);
                     mv.setVigencia(v);
                     mv.setValor(conf.getValor());
                     mv=motivacionVigenciaRepository.save(mv);
                     out.add(MotivacionVigenciaDto.toMotiVacionVigenciaDto(mv));
                 }
        }
        return out;
    }


    public List<MotivacionVigenciaDto> getMotivacionesConValorPorVigencia(Integer idVigencia) {
        List<MotivacionVigenciaDto> out=null;
        try {
            out = motivacionVigenciaRepository.getMotivacionesConValor(idVigencia).stream().map(x ->
            {
                MotivacionVigenciaDto dto = new MotivacionVigenciaDto();
                dto.setMotivacion((String) x[0]);
                dto.setIdmotivacion((Integer) x[1]);
                dto.setVigencia((String) x[2]);
                dto.setIdvigencia((Integer) x[3]);
                dto.setValor(((BigDecimal)x[4]).doubleValue());
                dto.setId((Integer) x[5]);
                return dto;
            }).collect(Collectors.toList());
            if (out.isEmpty()) {
                out = motivacionVigenciaRepository.getMotivacionesConValor2().stream().map(x ->
                {
                    MotivacionVigenciaDto dto = new MotivacionVigenciaDto();
                    dto.setMotivacion((String) x[0]);
                    dto.setIdmotivacion((Integer) x[1]);
                    return dto;
                }).collect(Collectors.toList());
            }
            return out;
        }
        catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
