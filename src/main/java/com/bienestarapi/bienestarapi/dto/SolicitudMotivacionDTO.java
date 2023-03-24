package com.bienestarapi.bienestarapi.dto;

import com.bienestarapi.bienestarapi.entity.MotivacionVigencia;
import com.bienestarapi.bienestarapi.entity.SolicitudMotivacion;
import com.bienestarapi.bienestarapi.entity.Vigencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SolicitudMotivacionDTO {

    private String documento;
    private String nombreFuncionario;
    private String cargo;
    private String dependencia;
    private Date fechaSolicitud;
    private String observaciones;
    private Double valor;
    private Integer motivacionVigenciaId;
    private Integer vigenciaId;
    private String id;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getMotivacionVigenciaId() {
        return motivacionVigenciaId;
    }

    public void setMotivacionVigenciaId(Integer motivacionVigenciaId) {
        this.motivacionVigenciaId = motivacionVigenciaId;
    }

    public Integer getVigenciaId() {
        return vigenciaId;
    }

    public void setVigenciaId(Integer vigenciaId) {
        this.vigenciaId = vigenciaId;
    }

    public String getNombreFuncionario() {
        return nombreFuncionario;
    }

    public void setNombreFuncionario(String nombreFuncionario) {
        this.nombreFuncionario = nombreFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public static SolicitudMotivacionDTO fromSolicitudMotivacion(SolicitudMotivacion solicitudMotivacion) {
        SolicitudMotivacionDTO solicitudMotivacionDTO = new SolicitudMotivacionDTO();
        solicitudMotivacionDTO.setDocumento(solicitudMotivacion.getDocumento());
        solicitudMotivacionDTO.setFechaSolicitud(solicitudMotivacion.getFechaSolicitud());
        solicitudMotivacionDTO.setObservaciones(solicitudMotivacion.getObservaciones());
        solicitudMotivacionDTO.setId(String.valueOf(solicitudMotivacion.getId()));
        solicitudMotivacionDTO.setNombreFuncionario(solicitudMotivacion.getNombreFuncionario());
        solicitudMotivacionDTO.setDependencia(solicitudMotivacion.getDependencia());
        solicitudMotivacionDTO.setCargo(solicitudMotivacion.getCargo());
        return solicitudMotivacionDTO;
    }



    public static List<SolicitudMotivacionDTO> fromSolicitudMotivacionList(List<SolicitudMotivacion> solicitudMotivacionList) {
        List<SolicitudMotivacionDTO> solicitudMotivacionDTOList = new ArrayList<>();
        for (SolicitudMotivacion solicitudMotivacion : solicitudMotivacionList) {
            solicitudMotivacionDTOList.add(SolicitudMotivacionDTO.fromSolicitudMotivacion(solicitudMotivacion));
        }
        return solicitudMotivacionDTOList;
    }

    public static SolicitudMotivacion fromSolicitudMotivacionDTO(SolicitudMotivacionDTO solicitudMotivacionDTO) {
        SolicitudMotivacion solicitudMotivacion = new SolicitudMotivacion();
        solicitudMotivacion.setDocumento(solicitudMotivacionDTO.getDocumento());
        solicitudMotivacion.setFechaSolicitud(solicitudMotivacionDTO.getFechaSolicitud());
        solicitudMotivacion.setObservaciones(solicitudMotivacionDTO.getObservaciones());
        solicitudMotivacion.setValor(solicitudMotivacionDTO.getValor());
        solicitudMotivacion.setNombreFuncionario(solicitudMotivacionDTO.getNombreFuncionario());
        solicitudMotivacion.setDependencia(solicitudMotivacionDTO.getDependencia());
        solicitudMotivacion.setCargo(solicitudMotivacionDTO.getCargo());
        solicitudMotivacion.setValor(solicitudMotivacionDTO.getValor());
        Vigencia v=new Vigencia();
        v.setIdvigencia(solicitudMotivacionDTO.getVigenciaId());
        solicitudMotivacion.setVigencia(v);
        MotivacionVigencia mv=new MotivacionVigencia();
        mv.setId(solicitudMotivacionDTO.getMotivacionVigenciaId());
        solicitudMotivacion.setMotivacionVigencia(mv);
        return solicitudMotivacion;
    }

    // constructor, getters y setters
}
