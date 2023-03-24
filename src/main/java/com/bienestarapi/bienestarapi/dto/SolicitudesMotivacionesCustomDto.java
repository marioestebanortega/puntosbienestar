package com.bienestarapi.bienestarapi.dto;

import java.sql.Date;

public class SolicitudesMotivacionesCustomDto {


    private String id;
    private String documento;
    private String dependencia;
    private Date fechaSolicitud;
    private Double disposicion;
    private Double puntos;
    private String observaciones;
    private String esDisposicion;
    private String nombreFuncionario;
    private String cargo;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Double getDisposicion() {
        return disposicion;
    }

    public void setDisposicion(Double disposicion) {
        this.disposicion = disposicion;
    }

    public Double getPuntos() {
        return puntos;
    }

    public void setPuntos(Double puntos) {
        this.puntos = puntos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEsDisposicion() {
        return esDisposicion;
    }

    public void setEsDisposicion(String esDisposicion) {
        this.esDisposicion = esDisposicion;
    }


}
