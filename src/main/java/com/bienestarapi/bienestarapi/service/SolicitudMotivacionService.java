package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.dto.SolicitudMotivacionDTO;
import com.bienestarapi.bienestarapi.dto.SolicitudesMotivacionesCustomDto;
import com.bienestarapi.bienestarapi.entity.Motivacion;
import com.bienestarapi.bienestarapi.entity.MotivacionVigencia;
import com.bienestarapi.bienestarapi.entity.SolicitudMotivacion;
import com.bienestarapi.bienestarapi.repository.MotivacionRepository;
import com.bienestarapi.bienestarapi.repository.MotivacionVigenciaRepository;
import com.bienestarapi.bienestarapi.repository.SolicitudMotivacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SolicitudMotivacionService {

    @Autowired
    private SolicitudMotivacionRepository solicitudMotivacionRepository;

    @Autowired
    private MotivacionRepository motivacionRepository;

    @Autowired
    private MotivacionVigenciaRepository motivacionVigenciaRepository;

    public SolicitudMotivacionDTO guardarSolicitudMotivacion(SolicitudMotivacionDTO solicitudMotivacionDTO) {
        SolicitudMotivacion solicitudMotivacion = SolicitudMotivacionDTO.fromSolicitudMotivacionDTO(solicitudMotivacionDTO);
        SolicitudMotivacion solicitudMotivacionGuardada = solicitudMotivacionRepository.save(solicitudMotivacion);
        return SolicitudMotivacionDTO.fromSolicitudMotivacion(solicitudMotivacionGuardada);
    }

    public SolicitudesMotivacionesCustomDto fromSolicitudMotivacion(SolicitudMotivacion solicitudMotivacion) {

        MotivacionVigencia mv=motivacionVigenciaRepository.findById(solicitudMotivacion.getMotivacionVigencia().getId()).get();

        SolicitudesMotivacionesCustomDto sdto = new SolicitudesMotivacionesCustomDto();
        sdto.setDocumento(solicitudMotivacion.getDocumento());
        sdto.setFechaSolicitud(solicitudMotivacion.getFechaSolicitud());
        sdto.setObservaciones(solicitudMotivacion.getObservaciones());
        sdto.setDisposicion(solicitudMotivacion.getValor());
        sdto.setId(String.valueOf(solicitudMotivacion.getId()));
        sdto.setEsDisposicion(solicitudMotivacion.getValor()==null?"N":"Y");
        sdto.setNombreFuncionario(solicitudMotivacion.getNombreFuncionario());
        sdto.setDependencia(solicitudMotivacion.getDependencia());
        sdto.setCargo(solicitudMotivacion.getCargo());
        sdto.setPuntos(mv.getValor());
        return sdto;
    }

    public List<SolicitudesMotivacionesCustomDto> obtenerTodasLasSolicitudesMotivacion(String user,String rol) {
        if(!rol.toLowerCase().contains("user")) {
            List<SolicitudMotivacion> solicitudesMotivacion = solicitudMotivacionRepository.findAll();
            return solicitudesMotivacion.stream()
                    .map(x -> fromSolicitudMotivacion(x))
                    .collect(Collectors.toList());
        }
        else{
            List<SolicitudMotivacion> solicitudesMotivacion = solicitudMotivacionRepository.findByDocumento(user);
            return solicitudesMotivacion.stream()
                    .map(x -> fromSolicitudMotivacion(x))
                    .collect(Collectors.toList());
        }
    }

    public Double obtenerAcumulado(Integer idvigencia, String idUser) {
        return solicitudMotivacionRepository.obtenerAcumulado(idvigencia,idUser);
    }
}