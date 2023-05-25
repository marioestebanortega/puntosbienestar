package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.dto.AlternativaVigenciaDto;
import com.bienestarapi.bienestarapi.entity.Alternativa;
import com.bienestarapi.bienestarapi.entity.AlternativaVigencia;
import com.bienestarapi.bienestarapi.entity.Vigencia;
import com.bienestarapi.bienestarapi.repository.AlternativaRepository;
import com.bienestarapi.bienestarapi.repository.AlternativaVigenciaRepository;
import com.bienestarapi.bienestarapi.repository.VigenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlternativaVigenciaService {

    @Autowired
    private AlternativaVigenciaRepository alternativaVigenciaRepository;

    @Autowired
    private AlternativaRepository alternativaRepository;


    @Autowired
    private VigenciaRepository vigenciaRepository;

    public AlternativaVigencia  getAlternativaVigenciaPorId(Integer id){
        return alternativaVigenciaRepository.getById(id);
    }



    public List<AlternativaVigenciaDto> guardarConfiguracionesAlternativaesPorVigencia(List<AlternativaVigenciaDto> confs) {
        List<AlternativaVigenciaDto> out=new ArrayList<>();
        if(confs!=null&&!confs.isEmpty()){
            for (AlternativaVigenciaDto conf : confs) {
                AlternativaVigencia  mv=null;
                if(conf.getId()==null){
                    mv=new AlternativaVigencia();
                }
                else{
                    mv=alternativaVigenciaRepository.findById(conf.getId()).get();
                }

                Alternativa m=alternativaRepository.findById(conf.getIdalternativa()).get();
                Vigencia v=vigenciaRepository.findById(conf.getIdvigencia()).get();
                mv.setAlternativa(m);
                mv.setVigencia(v);
                mv.setValor(conf.getValor());
                mv=alternativaVigenciaRepository.save(mv);
                out.add(AlternativaVigenciaDto.toMotiVacionVigenciaDto(mv));
            }
        }
        return out;
    }


    public List<AlternativaVigenciaDto> getAlternativaesConValorPorVigencia(Integer idVigencia) {
        List<AlternativaVigenciaDto> out=null;
        try {
            out = alternativaVigenciaRepository.getAlternativaesConValor(idVigencia).stream().map(x ->
            {
                AlternativaVigenciaDto dto = new AlternativaVigenciaDto();
                dto.setAlternativa((String) x[0]);
                dto.setIdalternativa((Integer) x[1]);
                dto.setVigencia((String) x[2]);
                dto.setIdvigencia((Integer) x[3]);
                dto.setValor(((BigDecimal)x[4]).doubleValue());
                dto.setId((Integer) x[5]);
                return dto;
            }).collect(Collectors.toList());
            if (out.isEmpty()) {
                out = alternativaVigenciaRepository.getAlternativaesConValor2().stream().map(x ->
                {
                    AlternativaVigenciaDto dto = new AlternativaVigenciaDto();
                    dto.setAlternativa((String) x[0]);
                    dto.setIdalternativa((Integer) x[1]);
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
