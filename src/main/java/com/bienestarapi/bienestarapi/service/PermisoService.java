package com.bienestarapi.bienestarapi.service;

import com.bienestarapi.bienestarapi.dto.PermisoResponseDto;
import com.bienestarapi.bienestarapi.entity.Alternativa;
import com.bienestarapi.bienestarapi.entity.Permiso;
import com.bienestarapi.bienestarapi.entity.Usuariorol;
import com.bienestarapi.bienestarapi.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PermisoService {

    @Autowired
    PermisoRepository PermisoRepository;

    @Autowired
    AlternativaVigenciaRepository alternativaVigenciaRepository;

    @Autowired
    UsuariorolVigenciaRepository usuariorolVigenciaRepository;

    @Autowired
    UsuariorolRepository usuariorolRepository;

    public List<Permiso> list(){

        return PermisoRepository.findAll();
    }

    public Optional<Permiso> getOne(Long idpermiso){

        return PermisoRepository.findByIdpermiso(idpermiso);
    }

    public Optional<Permiso> getByFecharadicacion(String fecharadicacion){

        return PermisoRepository.findByFecharadicacion(fecharadicacion);
    }

    public Optional<Permiso> getByIdentificacion(String identificacion){

        return PermisoRepository.findByIdentificacion(identificacion);
    }

    public Optional<Permiso> getByIdvigencia(Long idvigencia){

        return PermisoRepository.findByIdvigencia(idvigencia);
    }

    public long save(Permiso permiso){

        return PermisoRepository.save(permiso).getIdpermiso();
    }

    public List<PermisoResponseDto> permisosPorVigenciaYUsuario(Integer idvigencia, String idUser,String rol) {
        List<Permiso> permisos=null;
        if(!rol.equals("user")){
            permisos=PermisoRepository.findAll();
        }
        else{
            permisos=PermisoRepository.permisosPorVigenciaYUsuario(idvigencia,idUser);
        }
       List<PermisoResponseDto> out= permisos.stream().map(permiso->{
         PermisoResponseDto permisoResponseDto = new PermisoResponseDto();
         permisoResponseDto.setIdPermiso(permiso.getIdpermiso());
         permisoResponseDto.setDocumento(permiso.getIdentificacion());
         Usuariorol usuariorol= usuariorolRepository.findByIdentificacion(permiso.getIdentificacion()).get();
         permisoResponseDto.setNombrePersona(usuariorol.getNombre());
         permisoResponseDto.setCargo(usuariorol.getCargo());
         permisoResponseDto.setDependencia(usuariorol.getDependencia());
         permisoResponseDto.setPermisoDesc(alternativaVigenciaRepository.findById(permiso.getIdtipopermiso()).get().getAlternativa().getNombre());
         permisoResponseDto.setPuntos(usuariorolVigenciaRepository.obtenerPuntosPorUsuarioYVigencia(idvigencia,usuariorol.getIdusuariorol()));

         if(permiso.getIdestadopermiso()==1L){
               permisoResponseDto.setEstado("EN TRAMITE");
         }
         else if(permiso.getIdestadopermiso()==2L){
             permisoResponseDto.setEstado("APROBADO");
         }
         else if(permiso.getIdestadopermiso()==3L){
             permisoResponseDto.setEstado("RECHAZADO");
         }
         permisoResponseDto.setIdEstado(permiso.getIdestadopermiso());
         return  permisoResponseDto;
        }).collect(Collectors.toList());
       return out;
    }

    public Permiso actualizarEstado(Integer id, Integer estado) {
        Permiso per= PermisoRepository.findById(id).get();
        per.setIdestadopermiso(estado);
        return PermisoRepository.save(per);

    }
}
