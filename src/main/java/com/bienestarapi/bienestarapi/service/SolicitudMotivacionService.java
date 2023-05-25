package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.controller.MotivacionController;
import com.bienestarapi.bienestarapi.dto.EstadoPuntos;
import com.bienestarapi.bienestarapi.dto.SolicitudMotivacionDTO;
import com.bienestarapi.bienestarapi.dto.SolicitudesMotivacionesCustomDto;
import com.bienestarapi.bienestarapi.entity.*;
import com.bienestarapi.bienestarapi.repository.ConfiguracionesInicialesRepository;
import com.bienestarapi.bienestarapi.repository.MotivacionRepository;
import com.bienestarapi.bienestarapi.repository.MotivacionVigenciaRepository;
import com.bienestarapi.bienestarapi.repository.SolicitudMotivacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    ConfiguracionesInicialesRepository configuracionesInicialesRepository;

    @Autowired
    private MotivacionVigenciaRepository motivacionVigenciaRepository;

    @Autowired
    private PuntosacumuladosService puntosacumuladosService;

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
        if(solicitudMotivacion.getIdEstado()!=null){
            sdto.setIdEstado(solicitudMotivacion.getIdEstado().getValor());
            sdto.setEstado(solicitudMotivacion.getIdEstado().name());
        }

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


    public Double puntosIniciales(Integer idVigencia){
        Optional<ConfiguracionesVigencia> conf= configuracionesInicialesRepository.findByCodigoAndIdVigencia("PINI",idVigencia);
        return conf.get().getPuntosIniciales();
    };

    public SolicitudesMotivacionesCustomDto actualizarEstado(String id,Integer idEstado) {
        SolicitudMotivacion sm=solicitudMotivacionRepository.findById(Long.valueOf(id)).get();
        Optional<Puntosacumulados> pac =puntosacumuladosService.getByIdentificacionAndVigencia(sm.getDocumento(),Long.valueOf(sm.getVigencia().getIdvigencia()));
        EstadoPuntos estadoActaul=EstadoPuntos.fromValor(idEstado);
        if(estadoActaul.equals(EstadoPuntos.APROBADO_RRHH)){
            if(!pac.isPresent()){
                Puntosacumulados pacu=new Puntosacumulados();
                pacu.setPuntos(puntosIniciales(sm.getVigencia().getIdvigencia()));
                pacu.setFechacrea(new Date());
                pacu.setFechamodifica(new Date());
                pacu.setUsumodifica("admin");
                pacu.setIdentificacion(sm.getDocumento());
                pacu.setUsucrea("admin");
                pacu.setIdvigencia(Long.valueOf(sm.getVigencia().getIdvigencia()));
                puntosacumuladosService.save(pacu);
                pac=Optional.of(pacu);
            }
            Double nuevosPuntos=sm.getMotivacionVigencia().getValor();
            pac.get().setPuntos((pac.get().getPuntos()==null?puntosIniciales(sm.getVigencia().getIdvigencia()):pac.get().getPuntos()+nuevosPuntos));
            puntosacumuladosService.save(pac.get());
        }
        sm.setIdEstado(estadoActaul);
        solicitudMotivacionRepository.save(sm);
        return fromSolicitudMotivacion(sm);
    }
}