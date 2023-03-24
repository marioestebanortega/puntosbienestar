package com.bienestarapi.bienestarapi.dto;

import com.bienestarapi.bienestarapi.entity.MotivacionVigencia;

import java.io.Serializable;

public class MotivacionVigenciaDto implements Serializable {

    private Integer id;

    private Double valor;

    private String vigencia;

    private Integer idvigencia;

    private String motivacion;

    private Integer idmotivacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdmotivacion() {
        return idmotivacion;
    }

    public void setIdmotivacion(Integer idmotivacion) {
        this.idmotivacion = idmotivacion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public Integer getIdvigencia() {
        return idvigencia;
    }

    public void setIdvigencia(Integer idvigencia) {
        this.idvigencia = idvigencia;
    }

    public String getMotivacion() {
        return motivacion;
    }

    public void setMotivacion(String motivacion) {
        this.motivacion = motivacion;
    }

    public static MotivacionVigenciaDto toMotiVacionVigenciaDto(MotivacionVigencia entidad){
        MotivacionVigenciaDto dto=new MotivacionVigenciaDto();
        dto.setId(entidad.getId());
        dto.setMotivacion(entidad.getMotivacion().getNombre());
        dto.setIdmotivacion(entidad.getMotivacion().getIdmotivacion());
        dto.setVigencia(entidad.getVigencia().getVigencia());
        dto.setIdvigencia(entidad.getVigencia().getIdvigencia());
        dto.setValor(entidad.getValor());

        return dto;
    }
}
