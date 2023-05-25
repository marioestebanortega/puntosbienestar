package com.bienestarapi.bienestarapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "configuraciones_vigencia", schema = "bienestar")
public class ConfiguracionesVigencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_vigencia")
    private Integer idVigencia;

    @Column(name = "puntos_iniciales")
    private Double puntosIniciales;

    @Column(name = "codigo")
    private String codigo;

// Constructor, getters y setters

    public ConfiguracionesVigencia() {
    }

    public ConfiguracionesVigencia(Integer idVigencia, Double puntosIniciales) {
        this.idVigencia = idVigencia;
        this.puntosIniciales = puntosIniciales;
    }

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdVigencia() {
        return idVigencia;
    }

    public void setIdVigencia(Integer idVigencia) {
        this.idVigencia = idVigencia;
    }

    public Double getPuntosIniciales() {
        return puntosIniciales;
    }

    public void setPuntosIniciales(Double puntosIniciales) {
        this.puntosIniciales = puntosIniciales;
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
