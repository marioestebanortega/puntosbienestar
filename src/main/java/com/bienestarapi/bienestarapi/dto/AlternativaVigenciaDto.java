package com.bienestarapi.bienestarapi.dto;

import com.bienestarapi.bienestarapi.entity.AlternativaVigencia;

import java.io.Serializable;

public class AlternativaVigenciaDto implements Serializable {

    private Integer id;

    private Double valor;

    private String vigencia;

    private Integer idvigencia;

    private String alternativa;

    private Integer idalternativa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdalternativa() {
        return idalternativa;
    }

    public void setIdalternativa(Integer idalternativa) {
        this.idalternativa = idalternativa;
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

    public String getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(String alternativa) {
        this.alternativa = alternativa;
    }

    public static AlternativaVigenciaDto toMotiVacionVigenciaDto(AlternativaVigencia entidad){
        AlternativaVigenciaDto dto=new AlternativaVigenciaDto();
        dto.setId(entidad.getId());
        dto.setAlternativa(entidad.getAlternativa().getNombre());
        dto.setIdalternativa(entidad.getAlternativa().getIdalternativa());
        dto.setVigencia(entidad.getVigencia().getVigencia());
        dto.setIdvigencia(entidad.getVigencia().getIdvigencia());
        dto.setValor(entidad.getValor());

        return dto;
    }
}
